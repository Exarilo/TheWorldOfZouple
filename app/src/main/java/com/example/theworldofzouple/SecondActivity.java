package com.example.theworldofzouple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Random;


public class SecondActivity extends AppCompatActivity {

    //region déclaration des objets

    private Button btMenuCaracter;
    private Button btAttack;
    private Button btInventory;
    private Button btShop;
    private Button btCraft;
    private Button btRunAway;

    private ProgressBar pbHPennemi;
    private ProgressBar pbHPCar;
    private ProgressBar pbXP;


    private TextView tvMaxHPOfCaracter;

    private TextView tvEnnemiLVL;
    private TextView tvMaxEnnemiHP;
    private TextView tvCurrentHPEnnemi;
    private TextView tvCurrentCarHP;


    private TextView tvLVL;
    private TextView tvGold;
    private TextView tvDamages;
    private TextView tvMalusDamages;

    private ImageView imgMonster;
    private ImageView imgEpeeAttack;
    private ImageView imgLvlUp;

    static int initialEnnemiHP;
    static int initialCarHP;
    static int currentEnnemiHP;
    static int currentCarHP;
    static int damages;
    static int xp;
    static int maxXP;
    static int lvl;
    static int gold;
    static int nbZoupleTue;
    static int nbGolds;

    HashMap<String, Loot> dic_loots = new HashMap<String, Loot>();
    HashMap<String, Monster> dic_monsters = new HashMap<String,Monster>();
    Monster currentMonster;

    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Function create loot


        dic_loots.put("cuir",new Loot("cuir",null,50));
        dic_loots.put("peau",new Loot("peau",null,25));

        //Function create monster

        Monster monster;
        monster=new Monster("Monster0","larve_foreground",null,49,50);
        monster.setCaracteristic(1,1000,0,40,0,0);
        dic_monsters.put("Monster0",monster);

        monster=new Monster("Monster1","souris_foreground",null,62,100);
        monster.setCaracteristic(2,1500,0,60,0,0);
        dic_monsters.put("Monster1",monster);

        monster=new Monster("Monster2","alien_foreground",null,800,1400);
        monster.setCaracteristic(5,3000,0,200,0,0);
        dic_monsters.put("Monster2",monster);





        //region Find objet in activity
        btMenuCaracter= findViewById(R.id.btCaracter);
        btAttack= findViewById(R.id.btAttack);
        btInventory= findViewById(R.id.btInventory);
        btShop= findViewById(R.id.btShop);
        btCraft= findViewById(R.id.btCraft);
        btRunAway= findViewById(R.id.btRunAway);

        pbHPennemi= findViewById(R.id.pbEnnemiHP);
        pbHPCar=findViewById(R.id.pbCarHP);
        pbXP=findViewById(R.id.pbXP);

        tvCurrentCarHP=findViewById(R.id.tvCurrentCarHP);
        tvCurrentHPEnnemi=findViewById(R.id.tvCurrentEnnemiHP);
        tvLVL=findViewById(R.id.tvLVL);
        tvGold=findViewById(R.id.tvGold);

        imgEpeeAttack=findViewById(R.id.imgPenguAttack);
        imgLvlUp=findViewById(R.id.imLvlUp);
        imgMonster=findViewById(R.id.imgMonster);

        tvMalusDamages=findViewById(R.id.tvMalusDamages);
        tvDamages=findViewById(R.id.tvDamages);
        tvMaxHPOfCaracter=findViewById(R.id.tvMaxHP);
        tvMaxEnnemiHP=findViewById(R.id.tvMaxEnnemiHP);

        tvEnnemiLVL=findViewById(R.id.tvEnnemiLVL);


        //endregion

        //region Set initial values of static var
        lvl=1;
        maxXP=100;
        gold=0;
        nbZoupleTue=0;
        nbGolds=0;


        initialEnnemiHP= pbHPennemi.getProgress();
        currentEnnemiHP= initialEnnemiHP;
        initialCarHP=Integer.parseInt(tvMaxHPOfCaracter.getText().toString());
        currentCarHP=initialCarHP;
        setDamages();
        //endregion

        changeMonster("Monster0");


        //region click
        btAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAttack();
            }
        });
        btRunAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomMonster =new Random().nextInt(3);
                changeMonster("Monster"+String.valueOf(randomMonster));
            }
        });


        btMenuCaracter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToMenuCaracter();
            }
        });
        btInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToInventory();
            }
        });

        btShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToShop();
            }
        });

        btCraft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToCraft();
            }
        });
        //endregion


    }

        //function call when the user click on "Personnage".
    //region move to other Activity

    private void moveToMenuCaracter(){
        Intent intent =new Intent(SecondActivity.this,CaracterActivity.class);
        intent.putExtra("CurrentLVL", tvLVL.getText().toString());
        intent.putExtra("MaxHP", tvMaxHPOfCaracter.getText().toString());
        intent.putExtra("ZouplesKill", nbZoupleTue);
        intent.putExtra("TotalGolds", nbGolds);
        intent.putExtra("Damages", damages);
        startActivity(intent);
    }

    private void moveToInventory(){
        Intent intent =new Intent(SecondActivity.this,InventoryActivity.class);
        startActivity(intent);
    }
    private void moveToShop(){
        Intent intent =new Intent(SecondActivity.this,ShopActivity.class);
        intent.putExtra("CurrentGolds",Integer.parseInt(tvGold.getText().toString()));
        startActivity(intent);
    }
    private void moveToCraft(){
        Intent intent =new Intent(SecondActivity.this,CraftActivity.class);
        startActivity(intent);
    }

    //endregion



    //function wich define the user damages. We can change the value because the variable damages is in static.
    //When user change his items we can set current damages.

   public boolean changeMonster(String name){
        if(!dic_monsters.containsKey(name))
            return false;
        currentMonster = dic_monsters.get(name);
        int id= getResources().getIdentifier(currentMonster.monsterImg,"mipmap",getPackageName());
        if(id<=0)
            return false;

        imgMonster.setImageResource(id);
        tvEnnemiLVL.setText(String.valueOf(currentMonster.caracteristic.lvl));


        return true;

    }


    private void setDamages(){
        damages=400;
    }


    //Function wich define the current HP of the ennemi
    //If HP under 0 we can reset HP with the static var initial damages
    //TODOO Maybe set the current gold/lvl here
    private void setAnimation(){
        imgEpeeAttack.setVisibility(View.VISIBLE);
        tvDamages.setVisibility(View.VISIBLE);
        tvMalusDamages.setVisibility(View.VISIBLE);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imgEpeeAttack.setVisibility(View.INVISIBLE);
                tvDamages.setVisibility(View.INVISIBLE);
                tvMalusDamages.setVisibility(View.INVISIBLE);
            }
        }, 300);
    }
    private  void setGold(){
        gold=gold+100; //TODOO We should set golds with the value in the MonsterClass
        nbGolds=nbGolds+100;
        tvGold.setText(String.valueOf(gold));
    }
    private  void resetEnnemiHp(){
        pbHPennemi.setMax(currentMonster.caracteristic.hp);
        initialEnnemiHP=currentMonster.caracteristic.hp;
        pbHPennemi.setProgress(initialEnnemiHP);
        tvMaxEnnemiHP.setText(String.valueOf(currentMonster.caracteristic.hp));
        tvCurrentHPEnnemi.setText(String.valueOf(currentMonster.caracteristic.hp));
        currentEnnemiHP=initialEnnemiHP;
        tvCurrentHPEnnemi.setText(String.valueOf(currentEnnemiHP));
    }
    private  void resetCarHp(){
        currentCarHP=initialCarHP;
        tvCurrentCarHP.setText(String.valueOf(currentCarHP));
    }


    private  void setCaracterAttack(){
        currentEnnemiHP=currentEnnemiHP-damages;
        tvCurrentHPEnnemi.setText(String.valueOf(currentEnnemiHP));
        tvDamages.setText(String.valueOf(damages));
        setAnimation();

        if(currentEnnemiHP<=0){
            nbZoupleTue++;
            setGold();
            setXP();
            int randomMonster =new Random().nextInt(3);
            changeMonster("Monster"+String.valueOf(randomMonster));
            resetEnnemiHp();


        }
        pbHPennemi.setProgress(currentEnnemiHP);



    }

    public void setDeath(){

        int Malus= Integer.parseInt(tvGold.getText().toString());
        Malus=Malus/2;
        gold=gold-Malus;
        tvGold.setText(String.valueOf(Malus));


        tvGold.setTextColor(Color.parseColor("#FF2D00"));
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tvGold.setTextColor(Color.parseColor("#000000"));
            }
        }, 2000);
    }
    private  void setEnnemiAttack(){
        currentCarHP=currentCarHP- currentMonster.caracteristic.damages;
        tvCurrentCarHP.setText(String.valueOf(currentCarHP));
        if(currentCarHP<=0){
            resetCarHp();
            setDeath();
        }

        //tvDamages.setText(String.valueOf(damages));
        //setAnimation();

        //if(currentEnnemiHP<=0){
          //  nbZoupleTue++;
            //setGold();
            //resetHp();
            //setXP();

        //}

        pbHPCar.setProgress(currentCarHP);
    }

    private void setAttack(){
        setCaracterAttack();
        setEnnemiAttack();

    }




    private void setXP(){
        xp=xp+currentMonster.xp;
        //xp=xp+48; //TODOO We should set the xp with the value in the MonsterClass


        if(xp>=pbXP.getMax())
        {
            xp = xp%pbXP.getMax();
            setLVL();
        }

        pbXP.setProgress(xp);
    }

    private void setLVL(){
        lvl++;
        maxXP=maxXP*2;
        tvLVL.setText(String.valueOf(lvl));
        pbXP.setMax(maxXP);
        imgLvlUp.setVisibility(View.VISIBLE);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imgLvlUp.setVisibility(View.INVISIBLE);
            }
        }, 2000);

    }

}