package com.example.theworldofzouple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

public class CaracterActivity extends AppCompatActivity {
    private TextView CaracterTvLVL;
    private TextView CaracterTvMaxHP;
    private TextView tvZoupleTue;
    private TextView tvGoldEarn;
    private TextView CaracterTvDamages;

    private String CurrentLVL;
    private String MaxHP;
    private int ZoupleTue;
    private int Golds;
    private int Damages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracter);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Slidr.attach(this);
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("CurrentLVL")){ // check if CurrentLVL exist
                CurrentLVL = intent.getStringExtra("CurrentLVL"); // get the value
            }
            if (intent.hasExtra("MaxHP")){ // check if MaxHP exist
                MaxHP = intent.getStringExtra("MaxHP"); // get the value
            }

            ZoupleTue = intent.getIntExtra("ZouplesKill",0); // get the value
            Golds = intent.getIntExtra("TotalGolds",0); // get the value
            Damages = intent.getIntExtra("Damages",0); // get the value
        }


        CaracterTvLVL=findViewById(R.id.CaracterTvLVL);
        CaracterTvMaxHP=findViewById(R.id.CaracterTvMaxHP);
        tvZoupleTue=findViewById(R.id.tvZoupleTue);
        tvGoldEarn=findViewById(R.id.tvGoldEarn);
        CaracterTvDamages=findViewById(R.id.CaracterTvDamages);


        CaracterTvLVL.setText(CurrentLVL);
        CaracterTvMaxHP.setText(MaxHP);
        tvZoupleTue.setText(String.valueOf(ZoupleTue));
        tvGoldEarn.setText(String.valueOf(Golds));
        CaracterTvDamages.setText(String.valueOf(Damages));
        //tvLVL.getText().toString()
    }
}