package com.example.theworldofzouple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
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
    private Button btSpells;
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
    static TextView tvGold;
    private TextView tvDamages;
    private TextView tvDamages2;
    private TextView tvMalusDamages;
    private TextView tvMalusDamages2;

    private ImageView imgMonster;
    private ImageView imgCarAttack;
    private ImageView imgLvlUp;
    private ImageView imgEnnemiAttack;


    static boolean ennemiDead=false;
    static int initialEnnemiHP;
    static int currentEnnemiHP;
    static int currentCarHP;

    static int xp;
    static double maxXP;
    static int nbZoupleTue;
    static int nbGolds;
    static int lvlUPMonster;


    static int randomMonster=0;

    HashMap<String, Loot> dic_loots = new HashMap<String, Loot>();
    HashMap<String, Monster> dic_monsters = new HashMap<String,Monster>();

    Monster currentMonster;
    static UserCaracter currentCaracter;

    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        //create User
        UserCaracter userCaracter;

        userCaracter=new UserCaracter("Pingu","pingucaracter_foreground","spelldepart_foreground",null,0);
        userCaracter.setCaracteristic(1,1000,10,400,10,0);
        currentCaracter=userCaracter;



        //create loot

        dic_loots.put("cuir",new Loot("cuir",null,50));
        dic_loots.put("peau",new Loot("peau",null,25));


        //Create monster


        Monster monster;
        monster=new Monster("Monster0","larve_foreground","larveattack_foreground","larvedegats_foreground",49,50);
        monster.setCaracteristic(1,1000,0,40,0,0);
        dic_monsters.put("Monster0",monster);

        monster=new Monster("Monster1","souris_foreground","sourisattack_foreground","sourisdegats_foreground",62,100);
        monster.setCaracteristic(2,1500,0,60,0,0);
        dic_monsters.put("Monster1",monster);

        monster=new Monster("Monster2","canardchemine_foreground","canarchemineattack_foreground","canardcheminedegats_foreground",98,147);
        monster.setCaracteristic(3,2000,0,80,0,0);
        dic_monsters.put("Monster2",monster);

        monster=new Monster("Monster3","extraterrestre_foreground","extraterrestreattack_foreground","extraterrestredegats_foreground",188,267);
        monster.setCaracteristic(4,2500,0,125,0,0);
        dic_monsters.put("Monster3",monster);

        monster=new Monster("Monster4","alien_foreground","alienattack_foreground","aliendegats_foreground",275,398);
        monster.setCaracteristic(5,3000,0,200,0,0);
        dic_monsters.put("Monster4",monster);

        monster=new Monster("Monster5","hypo_foreground","hyppoattack_foreground","hypodegats_foreground",386,482);
        monster.setCaracteristic(6,3500,0,242,0,0);
        dic_monsters.put("Monster5",monster);







        //region Find objet in activity
        btMenuCaracter= findViewById(R.id.btCaracter);
        btAttack= findViewById(R.id.btAttack);
        btInventory= findViewById(R.id.btInventory);
        btShop= findViewById(R.id.btShop);
        btCraft= findViewById(R.id.btCraft);
        btSpells= findViewById(R.id.btSpells);
        btRunAway= findViewById(R.id.btRunAway);

        pbHPennemi= findViewById(R.id.pbEnnemiHP);
        pbHPCar=findViewById(R.id.pbCarHP);
        pbXP=findViewById(R.id.pbXP);

        tvCurrentCarHP=findViewById(R.id.tvCurrentCarHP);
        tvCurrentHPEnnemi=findViewById(R.id.tvCurrentEnnemiHP);
        tvLVL=findViewById(R.id.tvLVL);
        tvGold=findViewById(R.id.tvGold);

        imgCarAttack=findViewById(R.id.imgPenguAttack);
        imgLvlUp=findViewById(R.id.imLvlUp);
        imgMonster=findViewById(R.id.imgMonster);

        tvMalusDamages=findViewById(R.id.tvMalusDamages);
        tvDamages=findViewById(R.id.tvDamages);
        tvMalusDamages2=findViewById(R.id.tvMalusDamages2);
        tvDamages2=findViewById(R.id.tvDamages2);
        imgEnnemiAttack=findViewById(R.id.imgEnnemiAttack);

        tvMaxHPOfCaracter=findViewById(R.id.tvMaxHP);
        tvMaxEnnemiHP=findViewById(R.id.tvMaxEnnemiHP);

        tvEnnemiLVL=findViewById(R.id.tvEnnemiLVL);


        //endregion

        //region Set initial values of static var

        maxXP=100;
        nbZoupleTue=0;
        nbGolds=0;
        lvlUPMonster=0;
        initialEnnemiHP= pbHPennemi.getProgress();
        currentEnnemiHP= initialEnnemiHP;
        currentCarHP=currentCaracter.caracteristic.hp;

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
                int addNewMonster=currentCaracter.caracteristic.lvl/2;
                if(addNewMonster>=4)
                    addNewMonster=4;
                int newRandomMonster=new Random().nextInt(2+addNewMonster);
                while (newRandomMonster==randomMonster)
                    newRandomMonster=new Random().nextInt(2+addNewMonster);
                changeMonster("Monster"+String.valueOf(newRandomMonster));
                randomMonster=newRandomMonster;
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
        btSpells.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToSpells();
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
        startActivity(intent);
    }

    private void moveToInventory(){
        Intent intent =new Intent(SecondActivity.this,InventoryActivity.class);
        startActivity(intent);
    }
    private void moveToShop(){
        Intent intent =new Intent(SecondActivity.this,ShopActivity.class);
        startActivity(intent);
    }
    private void moveToCraft(){
        Intent intent =new Intent(SecondActivity.this,CraftActivity.class);
        startActivity(intent);
    }
    private void moveToSpells(){
        Intent intent =new Intent(SecondActivity.this,SpellsActivity.class);
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
        resetEnnemiHp();



        return true;

    }




    //Function wich define the current HP of the ennemi
    //If HP under 0 we can reset HP with the static var initial damages
    //TODOO Maybe set the current gold/lvl here
    private void setAnimation(){
        int id= getResources().getIdentifier(currentCaracter.CaracterAttackImg,"mipmap",getPackageName());
        if(id<=0)
            return;

        imgCarAttack.setImageResource(id);
        imgCarAttack.setVisibility(View.VISIBLE);
        tvDamages.setVisibility(View.VISIBLE);
        tvMalusDamages.setVisibility(View.VISIBLE);


        int idMonsterDegats= getResources().getIdentifier(currentMonster.monsterDamagesImg,"mipmap",getPackageName());
        if(idMonsterDegats<=0)
            return;

        imgMonster.setImageResource(idMonsterDegats);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imgCarAttack.setVisibility(View.INVISIBLE);
                tvDamages.setVisibility(View.INVISIBLE);
                tvMalusDamages.setVisibility(View.INVISIBLE);
            }
        }, 300);


        final Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                int idMonster= getResources().getIdentifier(currentMonster.monsterImg,"mipmap",getPackageName());
                if(idMonster<=0)
                    return;
                imgMonster.setImageResource(idMonster);
            }
        }, 400);

    }
    private void setAnimation2(boolean DefSupThanDamages) {
        int id= getResources().getIdentifier(currentMonster.monsterAttackImg,"mipmap",getPackageName());
        if(id<=0 )
            return;


        imgEnnemiAttack.setImageResource(id);
        imgEnnemiAttack.setVisibility(View.VISIBLE);

        if (!DefSupThanDamages){
            tvDamages2.setText(String.valueOf(Math.round(currentMonster.caracteristic.damages)-currentCaracter.caracteristic.def));
            tvDamages2.setVisibility(View.VISIBLE);
            tvMalusDamages2.setVisibility(View.VISIBLE);
        }


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                tvDamages2.setVisibility(View.INVISIBLE);
                tvMalusDamages2.setVisibility(View.INVISIBLE);
                imgEnnemiAttack.setVisibility(View.INVISIBLE);
            }
        }, 500);
    }


        private  void setGold(){
        currentCaracter.gold=currentCaracter.gold+currentMonster.gold; //TODOO We should set golds with the value in the MonsterClass
        nbGolds=nbGolds+currentMonster.gold;
        tvGold.setText(String.valueOf(currentCaracter.gold));
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
        currentCarHP=currentCaracter.caracteristic.hp;
        tvCurrentCarHP.setText(String.valueOf(currentCarHP));
    }


    private boolean setCaracterAttack(){

        int randomCrit =new Random().nextInt(99);

        if(randomCrit <= currentCaracter.caracteristic.critRate - 1){
            currentEnnemiHP=(currentEnnemiHP-(int)Math.round(currentCaracter.caracteristic.damages))*2;
            tvDamages.setText(String.valueOf(Math.round(currentCaracter.caracteristic.damages)*2));
            tvDamages.setTextColor(Color.parseColor("#FF0000"));
            tvMalusDamages.setTextColor(Color.parseColor("#FF0000"));
        }
        else {
            currentEnnemiHP = currentEnnemiHP - (int) Math.round(currentCaracter.caracteristic.damages);
            tvDamages.setText(String.valueOf(Math.round(currentCaracter.caracteristic.damages)));
            tvDamages.setTextColor(Color.parseColor("#ffff8800"));
            tvMalusDamages.setTextColor(Color.parseColor("#ffff8800"));
        }
        tvCurrentHPEnnemi.setText(String.valueOf(Math.round(currentEnnemiHP)));

        setAnimation();

        if(currentEnnemiHP<=0){
            nbZoupleTue++;
            setGold();
            setXP();
            int addNewMonster=currentCaracter.caracteristic.lvl/2;
            if(addNewMonster>=4)
                addNewMonster=4;
            randomMonster =new Random().nextInt(2+addNewMonster);
            changeMonster("Monster"+String.valueOf(randomMonster));
            resetEnnemiHp();
            ennemiDead=true;
            return ennemiDead;
            //currentMonster.caracteristic.setLvl(currentMonster.caracteristic.getLvl()+lvlUPMonster);
        }

        pbHPennemi.setProgress(currentEnnemiHP);
        ennemiDead=false;
        return ennemiDead;

    }

    public void setDeath(){

        int Malus= Integer.parseInt(tvGold.getText().toString());
        Malus=Malus/2;

        //gold=gold-Malus;
        //tvGold.setText(String.valueOf(Malus));


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
        boolean defSupThanDamages= false;
        if(currentCaracter.caracteristic.def<currentMonster.caracteristic.damages) {
            currentCarHP = (currentCarHP - (int) currentMonster.caracteristic.damages) + currentCaracter.caracteristic.def;
        }
        else
            defSupThanDamages=true;
        tvCurrentCarHP.setText(String.valueOf(currentCarHP));
        setAnimation2(defSupThanDamages);
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

        ennemiDead=setCaracterAttack();
        if(ennemiDead)
            return;
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setEnnemiAttack();
            }
        }, 800);



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

        currentCaracter.caracteristic.lvl++;
        maxXP=maxXP*1.5;
        maxXP=Math.round(maxXP);
        tvLVL.setText(String.valueOf(currentCaracter.caracteristic.lvl));
        pbXP.setMax((int)maxXP);
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