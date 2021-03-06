package com.example.theworldofzouple;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class SecondActivity extends AppCompatActivity {

    //region déclaration des objets

    Database db = new Database(SecondActivity.this);

    private Button btMenuCaracter;
    private Button btAttack;
    private Button btInventory;
    private Button btShop;
    private Button btCraft;
    private Button btSpells;
    private Button btRunAway;
    private Button btSuccess;




    private ProgressBar pbHPennemi;
    private ProgressBar pbHPCar;
    private ProgressBar pbXP;




    private TextView tvEnnemiLVL;

    private TextView tvEnnemiHP;
    private TextView tvCarHP;


    private TextView tvLVL;
    static TextView tvGold;
    private TextView tvDamages;
    private TextView tvDamages2;



    private TextView tvHistorique;

    private ImageView imgMonster;
    private ImageView imgCarAttack;
    private ImageView imgLvlUp;
    private ImageView imgEnnemiAttack;
    private ImageView imgCaracter;

    static boolean LoadMonster =false;
    static boolean ennemiDead;




    static int nbZoupleTue=0;
    static int nbGolds=0;
    static int lvlUPMonster=0;

    static int nbDeath=0;
    static int NbZoupleTueSuccess=0;
    static int gold=1400000;


    ScrollView ScrollViewHistorique;

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


        db.LoadStatistics();



        //create User
        UserCaracter userCaracter;

        userCaracter=new UserCaracter("Pingu","pingucaracter_foreground","spelldepart_foreground","pingucaracterdegats_foreground",0,0,100,0);
        userCaracter.setCaracteristic(1,1000,1000,10,400,1,1);
        currentCaracter=userCaracter;

        db.LoadCar(currentCaracter);


        //create loot

        dic_loots.put("cuir",new Loot("cuir",null,50));
        dic_loots.put("peau",new Loot("peau",null,25));


        //Create monster


        Monster monster;
        monster=new Monster("Monster0","larve_foreground","larveattack_foreground","larvedegats_foreground",49,50);
        monster.setCaracteristic(1,1000,1000,0,40,0,0);
        dic_monsters.put("Monster0",monster);

        monster=new Monster("Monster1","souris_foreground","sourisattack_foreground","sourisdegats_foreground",62,100);
        monster.setCaracteristic(2,1500,1500,0,60,0,0);
        dic_monsters.put("Monster1",monster);

        monster=new Monster("Monster2","canardchemine_foreground","canarchemineattack_foreground","canardcheminedegats_foreground",98,147);
        monster.setCaracteristic(3,2000,2000,0,80,0,0);
        dic_monsters.put("Monster2",monster);

        monster=new Monster("Monster3","extraterrestre_foreground","extraterrestreattack_foreground","extraterrestredegats_foreground",188,267);
        monster.setCaracteristic(4,2500,2500,0,125,0,0);
        dic_monsters.put("Monster3",monster);

        monster=new Monster("Monster4","alien_foreground","alienattack_foreground","aliendegats_foreground",275,398);
        monster.setCaracteristic(5,3000,3000,0,200,0,0);
        dic_monsters.put("Monster4",monster);

        monster=new Monster("Monster5","hypo_foreground","hyppoattack_foreground","hypodegats_foreground",386,482);
        monster.setCaracteristic(6,3500,3500,0,242,0,0);
        dic_monsters.put("Monster5",monster);

        monster=new Monster("Monster6","autruche_foreground","autrucheattack_foreground","autruchedegats_foreground",706,681);
        monster.setCaracteristic(7,4000,4000,0,326,0,0);
        dic_monsters.put("Monster6",monster);

        monster=new Monster("Monster7","robot_foreground","robotattack_foreground","robotdegats_foreground",952,952);
        monster.setCaracteristic(7,4500,4500,0,452,0,0);
        dic_monsters.put("Monster7",monster);

        monster=new Monster("Monster8","vampire_foreground","vampireattack_foreground","vampiredegats_foreground",1294,1411);
        monster.setCaracteristic(8,5000,5000,0,598,0,0);
        dic_monsters.put("Monster8",monster);



        //Create Spell





        //region Find objet in activity
        btMenuCaracter= findViewById(R.id.btCaracter);
        btAttack= findViewById(R.id.btAttack);
        btInventory= findViewById(R.id.btInventory);
        btShop= findViewById(R.id.btShop);
        btCraft= findViewById(R.id.btCraft);
        btSpells= findViewById(R.id.btSpells);
        btRunAway= findViewById(R.id.btRunAway);
        btSuccess= findViewById(R.id.btSuccess);

        pbHPennemi= findViewById(R.id.pbEnnemiHP);
        //pbHPennemi.getProgressDrawable().setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
        pbHPCar=findViewById(R.id.pbCarHP);


        //pbHPCar.getProgressDrawable().setColorFilter(Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);
        pbXP=findViewById(R.id.pbXP);
        pbXP.setProgress(currentCaracter.xp);
        pbXP.setMax((int)currentCaracter.maxXP);
        tvCarHP=findViewById(R.id.carHP);
        //tvCarHP.setText("HP : "+String.valueOf(currentCaracter.caracteristic.hp)+" / "+ String.valueOf(currentCaracter.caracteristic.hp));
        tvEnnemiHP=findViewById(R.id.EnnemiHP);
        tvLVL=findViewById(R.id.tvLVL);
        tvLVL.setText("Lvl : "+String.valueOf(currentCaracter.caracteristic.lvl));
        tvGold=findViewById(R.id.tvGold);
        tvGold.setText(String.valueOf(currentCaracter.gold));

        imgCarAttack=findViewById(R.id.imgPenguAttack);
        imgLvlUp=findViewById(R.id.imLvlUp);
        imgMonster=findViewById(R.id.imgMonster);

        tvDamages=findViewById(R.id.tvDamages);

        tvDamages2=findViewById(R.id.tvDamages2);
        imgEnnemiAttack=findViewById(R.id.imgEnnemiAttack);
        tvEnnemiLVL=findViewById(R.id.tvEnnemiLVL);


        imgCaracter=findViewById(R.id.imgCaracter);

        tvHistorique=findViewById(R.id.tvHistorique);
        tvHistorique.setText("\n\n\n\n");
        tvHistorique.setMovementMethod(new ScrollingMovementMethod());



        ScrollViewHistorique=findViewById(R.id.ScrollViewHistorique);

        pbHPCar.setProgress(currentCaracter.caracteristic.currentHP);
        pbHPCar.setMax(currentCaracter.caracteristic.hp);


        tvCarHP.setText("HP : "+String.valueOf(currentCaracter.caracteristic.hp)+" / "+ String.valueOf(currentCaracter.caracteristic.hp));

        //ScrollViewHistorique.fullScroll(ScrollView.FOCUS_DOWN);
        //endregion

        //region Set initial values of static var

        ennemiDead=false;

        //currentCarHP=currentCaracter.caracteristic.hp;

        //endregion

        changeMonster("Monster0");

        //Loading spells for the inventory
        SpellsActivity.initialiseSpells();
        List<String> listSpells = db.LoadSpells();
        for (String name:listSpells) {
            if(SpellsActivity.dic_spells.containsKey(name))
                currentCaracter.inventory.addSpell(SpellsActivity.dic_spells.get(name));
        }
        for (Spell sp :currentCaracter.inventory.getSpellList()) {
            sp.setisBuy(true);
        }



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
                if(addNewMonster>=7)
                    addNewMonster=7;
                int newRandomMonster=new Random().nextInt(2+addNewMonster);
                while (newRandomMonster==randomMonster)
                    newRandomMonster=new Random().nextInt(2+addNewMonster);
                changeMonster("Monster"+String.valueOf(newRandomMonster));
                randomMonster=newRandomMonster;
            }
        });

        btSuccess.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                flipBt(v,btSuccess);
                moveToMenuSuccess();
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

    private void moveToMenuSuccess(){
        Intent intent =new Intent(SecondActivity.this,SuccessActivity.class);
        startActivity(intent);
    }

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
        if(!LoadMonster){
            db.LoadMonster(currentMonster);
            LoadMonster=true;
        }
        else
            resetEnnemiHp();

        int id= getResources().getIdentifier(currentMonster.monsterImg,"mipmap",getPackageName());
        if(id<=0)
            return false;

        imgMonster.setImageResource(id);
        tvEnnemiLVL.setText("Lvl : "+String.valueOf(currentMonster.caracteristic.lvl));
        pbHPennemi.setMax(currentMonster.caracteristic.hp);
        pbHPennemi.setProgress(currentMonster.caracteristic.currentHP);
        tvEnnemiHP.setText("HP : "+String.valueOf(currentMonster.caracteristic.currentHP)+" / "+String.valueOf(currentMonster.caracteristic.hp));




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
    private void setAnimation2(boolean DefSupThanDamages,boolean isDodge) {
        int id= getResources().getIdentifier(currentMonster.monsterAttackImg,"mipmap",getPackageName());
        if(id<=0 )
            return;



        imgEnnemiAttack.setImageResource(id);
        imgEnnemiAttack.setVisibility(View.VISIBLE);

        if (isDodge)
        {
            tvDamages2.setText("MISS");
            tvDamages2.setVisibility(View.VISIBLE);
        }
        else {
            if (!DefSupThanDamages){
                tvDamages2.setText("- "+String.valueOf(Math.round(currentMonster.caracteristic.damages)-currentCaracter.caracteristic.def));
                tvDamages2.setVisibility(View.VISIBLE);

                int id2= getResources().getIdentifier(currentCaracter.CaracterDamagesImg,"mipmap",getPackageName());
                if(id2<=0)
                    return;

                imgCaracter.setImageResource(id2);
            }
        }



        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                tvDamages2.setVisibility(View.INVISIBLE);

                imgEnnemiAttack.setVisibility(View.INVISIBLE);
                int id= getResources().getIdentifier(currentCaracter.CaracterImg,"mipmap",getPackageName());
                if(id<=0)
                    return;
                imgCaracter.setImageResource(id);
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
        currentMonster.caracteristic.currentHP=currentMonster.caracteristic.hp;
        pbHPennemi.setProgress(currentMonster.caracteristic.currentHP);

        tvEnnemiHP.setText("HP : "+String.valueOf(currentMonster.caracteristic.currentHP)+" / "+String.valueOf(currentMonster.caracteristic.hp));


    }
    private  void resetCarHp(){
        currentCaracter.caracteristic.currentHP=currentCaracter.caracteristic.hp;
        pbHPCar.setMax(currentCaracter.caracteristic.hp);
        pbHPCar.setProgress(currentCaracter.caracteristic.hp);
        tvCarHP.setText("HP : "+String.valueOf(currentCaracter.caracteristic.currentHP)+" / "+String.valueOf(currentCaracter.caracteristic.hp));

    }


    private boolean setCaracterAttack(){

        int randomCrit =new Random().nextInt(99);

        if(randomCrit <= currentCaracter.caracteristic.critRate - 1){
            currentMonster.caracteristic.currentHP=currentMonster.caracteristic.currentHP-((int)Math.round(currentCaracter.caracteristic.damages*2));
            tvDamages.setText(String.valueOf("- "+Math.round(currentCaracter.caracteristic.damages)*2));
            tvDamages.setTextColor(Color.parseColor("#FF0000"));

        }
        else {
            currentMonster.caracteristic.currentHP = currentMonster.caracteristic.currentHP - (int) Math.round(currentCaracter.caracteristic.damages);
            tvDamages.setText("- "+String.valueOf(Math.round(currentCaracter.caracteristic.damages)));
            tvDamages.setTextColor(Color.parseColor("#ffff8800"));
        }
        tvEnnemiHP.setText("HP : "+String.valueOf(Math.round(currentMonster.caracteristic.currentHP))+" / "+String.valueOf(currentMonster.caracteristic.hp));

        setAnimation();

        if(currentMonster.caracteristic.currentHP<=0){
            nbZoupleTue++;
            NbZoupleTueSuccess++;
            setGold();
            setXP();
            int addNewMonster=currentCaracter.caracteristic.lvl/2;
            if(addNewMonster>=7)
                ;
            randomMonster =new Random().nextInt(2+addNewMonster);
            changeMonster("Monster"+String.valueOf(randomMonster));
            resetEnnemiHp();
            ennemiDead=true;
            return ennemiDead;
            //currentMonster.caracteristic.setLvl(currentMonster.caracteristic.getLvl()+lvlUPMonster);
        }

        pbHPennemi.setProgress(currentMonster.caracteristic.currentHP);
        ennemiDead=false;
        return ennemiDead;

    }

    public void setDeath(){

        int Malus= Integer.parseInt(tvGold.getText().toString());
        Malus=Malus/2;
        nbDeath++;

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
        boolean isDodge= false;

        int randomDodge =new Random().nextInt(99);
        if(randomDodge <= currentCaracter.caracteristic.dodgeRate - 1){
            tvDamages2.setTextColor(Color.parseColor("#FF0000"));

            isDodge=true;
        }

        else{
            if(currentCaracter.caracteristic.def<currentMonster.caracteristic.damages)
            {
                currentCaracter.caracteristic.currentHP = (currentCaracter.caracteristic.currentHP - (int) currentMonster.caracteristic.damages) + currentCaracter.caracteristic.def;
                tvDamages2.setTextColor(Color.parseColor("#ffff8800"));
            }
            else
                defSupThanDamages=true;
        }
        tvCarHP.setText("HP : "+String.valueOf(currentCaracter.caracteristic.currentHP)+" / "+String.valueOf(currentCaracter.caracteristic.hp));

        setAnimation2(defSupThanDamages,isDodge);
        if(currentCaracter.caracteristic.currentHP<=0){
            resetCarHp();
            setDeath();
        }

        pbHPCar.setProgress(currentCaracter.caracteristic.currentHP);
    }

    private void setAttack(){

        ennemiDead=setCaracterAttack();
        if(ennemiDead){

            tvHistorique.setText(tvHistorique.getText()+"Loot gagné : Peau de Zouple x2\n");

            ScrollViewHistorique.fullScroll(ScrollView.FOCUS_DOWN);

            return;}
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setEnnemiAttack();
            }
        }, 800);



    }


    private void setXP(){
        currentCaracter.xp=currentCaracter.xp+currentMonster.xp;
        if(currentCaracter.xp>=pbXP.getMax())
        {
            currentCaracter.xp = currentCaracter.xp%pbXP.getMax();
            setLVL();
        }

        pbXP.setProgress(currentCaracter.xp);

    }

    private void setLVL(){
        currentCaracter.ptsARepartir+=5;
        currentCaracter.caracteristic.lvl++;
        currentCaracter.maxXP=currentCaracter.maxXP*1.5;
        currentCaracter.maxXP=Math.round(currentCaracter.maxXP);
        tvLVL.setText("Lvl : "+String.valueOf(currentCaracter.caracteristic.lvl));
        pbXP.setMax((int)currentCaracter.maxXP);
        imgLvlUp.setVisibility(View.VISIBLE);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imgLvlUp.setVisibility(View.INVISIBLE);
            }
        }, 2000);


    }
    @Override
    public void onResume(){
        super.onResume();
        pbHPCar.setMax(currentCaracter.caracteristic.hp);
        tvGold.setText(String.valueOf(currentCaracter.gold));
        tvCarHP.setText("HP : "+String.valueOf(currentCaracter.caracteristic.currentHP) + " / "+String.valueOf(currentCaracter.caracteristic.hp));
    }

    public static void flipBt (View view,Button bt){
        long animationDuration=500;
        //ObjectAnimator animator = ObjectAnimator.ofFloat(btSuccess, "translationX", -50f);

        ObjectAnimator animator =ObjectAnimator.ofFloat(bt,"rotation",0f,360f);
        animator.setDuration(animationDuration);
        animator.start();

        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation,Button bt) {
                long animationDuration = 500;
                ObjectAnimator animator2 =ObjectAnimator.ofFloat(bt,"rotation",360f,0f);
                //ObjectAnimator animator2 = ObjectAnimator.ofFloat(btSuccess, "translationX", 25f);
                animator2.setDuration(animationDuration);
                animator2.start();
            }
        });
    }
    @Override
    public void onStop() {
        super.onStop();
        db.SaveCar(currentCaracter);
        db.SaveMonster(currentMonster);
        db.SaveInventory(currentCaracter.inventory);
        db.SaveStatistics();
        /*db.updateXP(xp);
        db.updateMaxXP((int)maxXP);
        db.updateLvl(currentCaracter.caracteristic.lvl);
        db.updateGold(currentCaracter.gold);
        db.updateCurrentHP(currentCarHP);
        db.updateMaxHP(currentCaracter.caracteristic.hp);*/
    }
}