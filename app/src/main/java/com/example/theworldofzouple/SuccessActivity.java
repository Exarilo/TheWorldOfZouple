package com.example.theworldofzouple;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SuccessActivity extends AppCompatActivity {
    private Button btCloseSucces;
    private ImageView btButinMission1;
    private ProgressBar pbNbZoupleTue;
    Activity SuccessActivity;


    private int nbZouplePourMission=10;
    private int nbZoupleTue=SecondActivity.nbZoupleTue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        btCloseSucces=findViewById(R.id.btCloseSucces);
        pbNbZoupleTue=findViewById(R.id.pbNbZoupleTue);

        btButinMission1=findViewById(R.id.btButinMission1);

        pbNbZoupleTue.setProgress(SecondActivity.nbZoupleTue);
        pbNbZoupleTue.setMax(nbZouplePourMission);

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
    }
    public void setZoupleATuer(){
        nbZoupleTue=(nbZouplePourMission-nbZoupleTue)*(-1);
        if(nbZoupleTue<0)
            nbZoupleTue=0;

        nbZouplePourMission*=2;
        pbNbZoupleTue.setMax(nbZouplePourMission);
        pbNbZoupleTue.setProgress(nbZoupleTue+nbZouplePourMission-(nbZouplePourMission-nbZoupleTue));
        showReward();

    }
    public void showReward(){
        if(pbNbZoupleTue.getProgress()>=pbNbZoupleTue.getMax())
            btButinMission1.setVisibility(View.VISIBLE);
        else
            btButinMission1.setVisibility(View.INVISIBLE);
    }
}