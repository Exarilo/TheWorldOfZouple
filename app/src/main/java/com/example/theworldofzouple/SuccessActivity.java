package com.example.theworldofzouple;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SuccessActivity extends AppCompatActivity {
    private Button btCloseSucces;
    private ImageView btButinMission1;
    private ImageView btButinMission2;
    private ImageView imgGoldDamages;
    private ImageView imgGoldZouples;

    private ProgressBar pbNbZoupleTue;
    private ProgressBar pbNbDamages;

    private TextView tvNbDamages;
    private TextView tvNbZouple;
    private TextView tvCurrentNbZouple;
    private TextView tvCurrentDamagesSucces;
    private TextView tvGoldDamages;
    private TextView tvGoldZouples;

    private TextView tvNbLvl;
    private ProgressBar pbNbLvl;
    private TextView tvCurrentLvl;
    private ImageView btButinMission3;
    private ImageView imgGoldLvl;
    private TextView tvGoldLvl;

    TextView tvNbDeath;
    ProgressBar pbNbDeath;
    TextView tvCurrentDeath;
    TextView tvGoldDeath;
    ImageView imgGoldDeath;
    ImageView btButinMission4;


    private static int nbZouplePourMission=10;
    private static int nbDamagesPourMission=900;
    private static int nbLvlPourMission=10;
    private static int goldRewardZouple=500;
    private static int goldRewardDamages=1000;
    private static int goldRewardLvl=1000;
    private static int nbDeathPourMission=5;
    private static int goldRewardDeath=1500;


    private int nbZoupleTue=SecondActivity.nbZoupleTue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        btCloseSucces=findViewById(R.id.btCloseSucces);
        pbNbZoupleTue=findViewById(R.id.pbNbZoupleTue);

        tvGoldZouples=findViewById(R.id.tvGoldZouples);
        imgGoldDamages=findViewById(R.id.imgGoldDamages);
        imgGoldZouples=findViewById(R.id.imgGoldZouples);
        tvNbDamages=findViewById(R.id.tvNbDamages);
        tvNbZouple=findViewById(R.id.tvNbZouple);
        tvCurrentNbZouple=findViewById(R.id.tvCurrentNbZouple);
        tvCurrentDamagesSucces=findViewById(R.id.tvCurrentDamagesSucces);
        tvGoldDamages=findViewById(R.id.tvGoldDamages);

        btButinMission1=findViewById(R.id.btButinMission1);
        btButinMission2=findViewById(R.id.btButinMission2);
        pbNbDamages=findViewById(R.id.pbNbDamages);
        pbNbDamages.setMax(nbDamagesPourMission);
        pbNbZoupleTue.setProgress(SecondActivity.NbZoupleTueSuccess);


        tvNbLvl=findViewById(R.id.tvNbLvl);
        pbNbLvl=findViewById(R.id.pbNbLvl);
        tvCurrentLvl=findViewById(R.id.tvCurrentLvl);
        btButinMission3=findViewById(R.id.btButinMission3);
        imgGoldLvl=findViewById(R.id.imgGoldLvl);
        tvGoldLvl=findViewById(R.id.tvGoldLvl);


        tvNbDeath=findViewById(R.id.tvNbDeath);
        pbNbDeath=findViewById(R.id.pbNbDeath);
        tvCurrentDeath=findViewById(R.id.tvCurrentDeath);
        tvGoldDeath=findViewById(R.id.tvGoldDeath);
        imgGoldDeath=findViewById(R.id.imgGoldDeath);
        btButinMission4=findViewById(R.id.btButinMission4);


        tvGoldZouples.setText(String.valueOf(goldRewardZouple));
        tvGoldDamages.setText(String.valueOf(goldRewardDamages));
        tvGoldLvl.setText(String.valueOf(goldRewardLvl));
        tvGoldDeath.setText(String.valueOf(goldRewardDeath));

        tvNbZouple.setText("Tuer "+String.valueOf(pbNbZoupleTue.getMax()+" zouples"));
        tvNbDamages.setText("Atteindre "+String.valueOf(pbNbDamages.getMax())+" de degats");
        tvNbLvl.setText("Atteindre le niveau "+String.valueOf(pbNbLvl.getMax()));
        tvNbDeath.setText("Mourir "+String.valueOf(pbNbDeath.getMax()+" fois"));
        pbNbDeath.setProgress(SecondActivity.nbDeath);
        pbNbDeath.setMax(nbDeathPourMission);


            //pbNbZoupleTue.setProgress(nbZoupleTue + nbZouplePourMission - (nbZouplePourMission - nbZoupleTue));

        tvCurrentNbZouple.setText(String.valueOf(pbNbZoupleTue.getProgress())+" /"+String.valueOf(nbZouplePourMission));
        tvCurrentDamagesSucces.setText(String.valueOf((int)SecondActivity.currentCaracter.caracteristic.damages)+" /"+String.valueOf(pbNbDamages.getMax()));
        tvCurrentLvl.setText(String.valueOf(SecondActivity.currentCaracter.caracteristic.lvl)+" /"+String.valueOf(pbNbLvl.getMax()));
        tvCurrentDeath.setText(String.valueOf(SecondActivity.nbDeath)+" /"+String.valueOf(pbNbDeath.getMax()));

        pbNbZoupleTue.setMax(nbZouplePourMission);
        pbNbDamages.setProgress((int)SecondActivity.currentCaracter.caracteristic.damages);
        pbNbDamages.setMax(nbDamagesPourMission);
        pbNbLvl.setMax(nbLvlPourMission);
        pbNbLvl.setProgress(SecondActivity.currentCaracter.caracteristic.lvl);

        showReward();



        btCloseSucces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SuccessActivity.this.finish();
            }
        });

        btButinMission1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setZoupleATuer();
            }
        });
        btButinMission2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDamages();
            }
        });
        btButinMission3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLvl();
            }
        });
        btButinMission4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDeath();
            }
        });
    }
    public void setZoupleATuer(){
        nbZoupleTue=(nbZouplePourMission-nbZoupleTue)*(-1);
        if(nbZoupleTue<0)
            nbZoupleTue=0;



        //pbNbZoupleTue.setProgress(nbZoupleTue+nbZouplePourMission-(nbZouplePourMission-nbZoupleTue));
        SecondActivity.NbZoupleTueSuccess-=nbZouplePourMission;
        pbNbZoupleTue.setProgress(SecondActivity.NbZoupleTueSuccess);
        nbZouplePourMission*=2;
        pbNbZoupleTue.setMax(nbZouplePourMission);
        tvNbZouple.setText("Tuer "+String.valueOf(pbNbZoupleTue.getMax()+" zouples"));
        tvCurrentNbZouple.setText(String.valueOf(pbNbZoupleTue.getProgress())+" /"+String.valueOf(pbNbZoupleTue.getMax()));
        SecondActivity.currentCaracter.gold+=Integer.parseInt(tvGoldZouples.getText().toString());
        goldRewardZouple+=300;
        tvGoldZouples.setText(String.valueOf(goldRewardZouple));
        showReward();


    }
    public void setDamages() {
        nbDamagesPourMission*=2;
        pbNbDamages.setMax(nbDamagesPourMission);
        tvCurrentDamagesSucces.setText(String.valueOf((int)SecondActivity.currentCaracter.caracteristic.damages)+" /"+String.valueOf(pbNbDamages.getMax()));
        tvNbDamages.setText("Atteindre "+String.valueOf(pbNbDamages.getMax())+" de degats");
        SecondActivity.currentCaracter.gold+=Integer.parseInt(tvGoldDamages.getText().toString());
        goldRewardDamages*=1.25;
        tvGoldDamages.setText(String.valueOf(goldRewardDamages));
        showReward();

    }

    public void setLvl() {

        nbLvlPourMission+=5;
        pbNbLvl.setMax(nbLvlPourMission);
        tvCurrentLvl.setText(String.valueOf(SecondActivity.currentCaracter.caracteristic.lvl)+" /"+String.valueOf(pbNbLvl.getMax()));
        tvNbLvl.setText("Atteindre le niveau "+String.valueOf(pbNbLvl.getMax()));
        SecondActivity.currentCaracter.gold+=Integer.parseInt(tvGoldLvl.getText().toString());
        goldRewardLvl*=2.2;
        tvGoldLvl.setText(String.valueOf(goldRewardLvl));
        showReward();
    }
    public void setDeath() {

        nbDeathPourMission+=5;
        pbNbDeath.setMax(nbDeathPourMission);
        tvCurrentDeath.setText(String.valueOf(SecondActivity.nbDeath)+" /"+String.valueOf(pbNbDeath.getMax()));
        tvNbDeath.setText("Mourir "+String.valueOf(pbNbDeath.getMax()+" fois"));
        SecondActivity.currentCaracter.gold+=Integer.parseInt(tvGoldDeath.getText().toString());
        goldRewardDeath*=3;
        tvGoldDeath.setText(String.valueOf(goldRewardDeath));
        showReward();
    }

    public void showReward(){
        hideShow(pbNbZoupleTue,btButinMission1,tvGoldZouples,imgGoldZouples);
        hideShow(pbNbDamages,btButinMission2,tvGoldDamages,imgGoldDamages);
        hideShow(pbNbLvl,btButinMission3,tvGoldLvl,imgGoldLvl);
        hideShow(pbNbDeath,btButinMission4,tvGoldDeath,imgGoldDeath);


    }

    public void hideShow(ProgressBar pb,ImageView bt,TextView tv,ImageView img){
        if(pb.getProgress()>=pb.getMax())
        {
            bt.setVisibility(View.VISIBLE);
            tv.setVisibility(View.VISIBLE);
            img.setVisibility(View.VISIBLE);
        }
        else
        {
            bt.setVisibility(View.INVISIBLE);
            tv.setVisibility(View.INVISIBLE);
            img.setVisibility(View.INVISIBLE);
        }
    }
}