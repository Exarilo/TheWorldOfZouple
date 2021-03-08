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

    private ProgressBar pbNbZoupleTue;
    private ProgressBar pbNbDamages;

    private TextView tvNbDamages;
    private TextView tvNbZouple;
    private TextView tvCurrentNbZouple;

    private static int newNbZoupleTue=SecondActivity.nbZoupleTue;
    private static int nbZouplePourMission=10;
    private int nbZoupleTue=SecondActivity.nbZoupleTue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        btCloseSucces=findViewById(R.id.btCloseSucces);
        pbNbZoupleTue=findViewById(R.id.pbNbZoupleTue);


        tvNbDamages=findViewById(R.id.tvNbDamages);
        tvNbZouple=findViewById(R.id.tvNbZouple);
        tvCurrentNbZouple=findViewById(R.id.tvCurrentNbZouple);

        btButinMission1=findViewById(R.id.btButinMission1);
        btButinMission2=findViewById(R.id.btButinMission2);
        pbNbDamages=findViewById(R.id.pbNbDamages);
        pbNbZoupleTue.setProgress(SecondActivity.nbZoupleTue);
        pbNbZoupleTue.setMax(nbZouplePourMission);

        tvNbZouple.setText("Tuer un total de "+String.valueOf(pbNbZoupleTue.getMax()+" zouples"));
        tvNbDamages.setText("Atteindre "+String.valueOf(pbNbDamages.getMax())+" de degats");


        if(pbNbZoupleTue.getMax()>10)
            pbNbZoupleTue.setProgress(nbZoupleTue-(nbZouplePourMission/2));
        else
            pbNbZoupleTue.setProgress(nbZoupleTue);
            //pbNbZoupleTue.setProgress(nbZoupleTue + nbZouplePourMission - (nbZouplePourMission - nbZoupleTue));

        tvCurrentNbZouple.setText(String.valueOf(pbNbZoupleTue.getProgress())+" /"+String.valueOf(pbNbZoupleTue.getMax()));

        pbNbZoupleTue.setMax(nbZouplePourMission);
        pbNbDamages.setProgress((int)SecondActivity.currentCaracter.caracteristic.damages);

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
    }
    public void setZoupleATuer(){
        nbZoupleTue=(nbZouplePourMission-nbZoupleTue)*(-1);
        if(nbZoupleTue<0)
            nbZoupleTue=0;



        //pbNbZoupleTue.setProgress(nbZoupleTue+nbZouplePourMission-(nbZouplePourMission-nbZoupleTue));
        newNbZoupleTue=nbZoupleTue%nbZouplePourMission;
        pbNbZoupleTue.setProgress(newNbZoupleTue);
        nbZouplePourMission*=2;
        pbNbZoupleTue.setMax(nbZouplePourMission);
        tvNbZouple.setText("Tuer un total de "+String.valueOf(pbNbZoupleTue.getMax()+" zouples"));
        tvCurrentNbZouple.setText(String.valueOf(pbNbZoupleTue.getProgress())+" /"+String.valueOf(pbNbZoupleTue.getMax()));
        showReward();


    }
    public void setDamages() {
        pbNbDamages.setMax(pbNbDamages.getMax()*2);
        tvNbDamages.setText("Atteindre "+String.valueOf(pbNbDamages.getMax())+" de degats");
        showReward();

    }

    public void showReward(){
        if(pbNbZoupleTue.getProgress()>=pbNbZoupleTue.getMax())
            btButinMission1.setVisibility(View.VISIBLE);
        else
            btButinMission1.setVisibility(View.INVISIBLE);
        if(pbNbDamages.getProgress()>=pbNbDamages.getMax())
            btButinMission2.setVisibility(View.VISIBLE);
        else
            btButinMission2.setVisibility(View.INVISIBLE);


    }

}