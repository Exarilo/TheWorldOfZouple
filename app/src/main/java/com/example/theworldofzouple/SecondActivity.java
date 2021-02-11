package com.example.theworldofzouple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;




public class SecondActivity extends AppCompatActivity {

    //Variables
    private Button btMenuCaracter;
    private Button btAttack;
    private ProgressBar pbHPennemi;

    private TextView tvCurrentHP;
    private TextView tvCurrentXP;
    private TextView tvMaxXP;
    private TextView tvLVL;
    private TextView tvGold;
    private TextView tvDamages;

    private ImageView imgEpeeAttack;

    static int initialHP;
    static int currentHP;
    static int damages;
    static int xp;
    static int maxXP;
    static int lvl;
    static int gold;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        //Find objet in activity
        btMenuCaracter= findViewById(R.id.btCaracter);
        btAttack= findViewById(R.id.btAttack);
        pbHPennemi= findViewById(R.id.pbEnnemiHP);
        tvCurrentHP=findViewById(R.id.tvCurrentEnnemiHP);
        tvCurrentXP=findViewById(R.id.tvCurrentXP);
        tvMaxXP=findViewById(R.id.tvMaxXP);
        tvLVL=findViewById(R.id.tvLVL);
        tvGold=findViewById(R.id.tvGold);
        imgEpeeAttack=findViewById(R.id.imgEpeeAttack);
        tvDamages=findViewById(R.id.tvDamages);


        //Set initial values of static var
        lvl=1;
        maxXP=100;
        gold=0;


        initialHP= pbHPennemi.getProgress();
        currentHP= initialHP;
        setDamages();

        btMenuCaracter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToMenuCaracter();
            }
        });

        btAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEnnemiHp();
            }
        });



        btMenuCaracter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToMenuCaracter();
            }
        });


    }
    //function call when the user click on "Personnage".
    private void moveToMenuCaracter(){
        Intent intent =new Intent(SecondActivity.this,CaracterActivity.class);
        startActivity(intent);
    }


    //function wich define the user damages. We can change the value because the variable damages is in static.
    //When user change his items we can set current damages.
    private void setDamages(){
        damages=100;
    }


    //Function wich define the current HP of the ennemi
    //If HP under 0 we can reset HP with the static var initial damages
    //TODOO Maybe set the current gold/lvl here
    private void setEnnemiHp(){

        currentHP=currentHP-damages;
        tvCurrentHP.setText(String.valueOf(currentHP));
        imgEpeeAttack.setVisibility(View.VISIBLE);
        tvDamages.setText(String.valueOf(damages));
        tvDamages.setVisibility(View.VISIBLE);


        if(currentHP<=0){
            gold=gold+100; //TODOO We should set golds with the value in the MonsterClass
            tvGold.setText(String.valueOf(gold));
            currentHP=initialHP;
            tvCurrentHP.setText(String.valueOf(currentHP));
            setXP();
        }

        pbHPennemi.setProgress(currentHP);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imgEpeeAttack.setVisibility(View.INVISIBLE);
                tvDamages.setVisibility(View.INVISIBLE);
            }
        }, 300);
        //SystemClock.sleep(500);

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

    }

}