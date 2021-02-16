package com.example.theworldofzouple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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


public class SecondActivity extends AppCompatActivity {

    //region déclaration des objets

    private Button btMenuCaracter;
    private Button btAttack;
    private Button btInventory;
    private Button btShop;
    private Button btCraft;

    private ProgressBar pbHPennemi;
    private ProgressBar pbHPCar;

    private TextView tvMaxHPOfCaracter;


    private TextView tvCurrentHPEnnemi;
    private TextView tvCurrentCarHP;

    private TextView tvCurrentXP;
    private TextView tvMaxXP;
    private TextView tvLVL;
    private TextView tvGold;
    private TextView tvDamages;

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
        monster=new Monster("Monster1","larve_foreground",null,60,50);
        monster.setCaracteristic(1,1000,0,60,0,0);
        dic_monsters.put("Monster1",monster);

        monster=new Monster("Monster2","marchand_foreground",null,60,50);
        monster.setCaracteristic(1,1000,0,60,0,0);
        dic_monsters.put("Monster2",monster);




        //region Find objet in activity
        btMenuCaracter= findViewById(R.id.btCaracter);
        btAttack= findViewById(R.id.btAttack);
        btInventory= findViewById(R.id.btInventory);
        btShop= findViewById(R.id.btShop);
        btCraft= findViewById(R.id.btCraft);

        pbHPennemi= findViewById(R.id.pbEnnemiHP);
        pbHPCar=findViewById(R.id.pbCarHP);

        tvCurrentCarHP=findViewById(R.id.tvCurrentCarHP);
        tvCurrentHPEnnemi=findViewById(R.id.tvCurrentEnnemiHP);
        tvCurrentXP=findViewById(R.id.tvCurrentXP);
        tvMaxXP=findViewById(R.id.tvMaxXP);
        tvLVL=findViewById(R.id.tvLVL);
        tvGold=findViewById(R.id.tvGold);

        imgEpeeAttack=findViewById(R.id.imgPenguAttack);
        imgLvlUp=findViewById(R.id.imLvlUp);
        imgMonster=findViewById(R.id.imgMonster);

        tvDamages=findViewById(R.id.tvDamages);
        tvMaxHPOfCaracter=findViewById(R.id.tvMaxHP);

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

        changeMonster("Monster1");


        //region click
        btAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAttack();
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

        return true;

    }


    private void setDamages(){
        damages=100;
    }


    //Function wich define the current HP of the ennemi
    //If HP under 0 we can reset HP with the static var initial damages
    //TODOO Maybe set the current gold/lvl here
    private void setAnimation(){
        imgEpeeAttack.setVisibility(View.VISIBLE);
        tvDamages.setVisibility(View.VISIBLE);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imgEpeeAttack.setVisibility(View.INVISIBLE);
                tvDamages.setVisibility(View.INVISIBLE);
            }
        }, 300);
    }
    private  void setGold(){
        gold=gold+100; //TODOO We should set golds with the value in the MonsterClass
        nbGolds=nbGolds+100;
        tvGold.setText(String.valueOf(gold));
    }
    private  void resetEnnemiHp(){
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
            resetEnnemiHp();
            setXP();
            changeMonster("Monster2");

        }

        pbHPennemi.setProgress(currentEnnemiHP);
    }

    private  void setEnnemiAttack(){
        currentCarHP=currentCarHP-60;
        tvCurrentCarHP.setText(String.valueOf(currentCarHP));
        if(currentCarHP<=0){
            resetCarHp();
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
        xp=xp+48; //TODOO We should set the xp with the value in the MonsterClass


        if(xp>=Integer.parseInt(tvMaxXP.getText().toString()))
        {
            xp = xp%Integer.parseInt(tvMaxXP.getText().toString());
            setLVL();
        }
        tvCurrentXP.setText(String.valueOf(xp));
    }

    private void setLVL(){
        lvl++;
        maxXP=maxXP*2;
        tvLVL.setText(String.valueOf(lvl));
        tvMaxXP.setText(String.valueOf(maxXP));

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