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
    private TextView CaracterTvDef;
    private TextView CaracterTvCritRate;

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

        ZoupleTue=SecondActivity.nbZoupleTue;
        Golds=SecondActivity.nbGolds;




        CaracterTvLVL=findViewById(R.id.CaracterTvLVL);
        CaracterTvMaxHP=findViewById(R.id.CaracterTvMaxHP);
        tvZoupleTue=findViewById(R.id.tvZoupleTue);
        tvGoldEarn=findViewById(R.id.tvGoldEarn);
        CaracterTvDamages=findViewById(R.id.CaracterTvDamages);
        CaracterTvDef=findViewById(R.id.CaracterTvDef);
        CaracterTvCritRate=findViewById(R.id.CaracterTvCritRate);




        CaracterTvLVL.setText(String.valueOf(SecondActivity.currentCaracter.caracteristic.lvl));
        CaracterTvMaxHP.setText(String.valueOf(SecondActivity.currentCaracter.caracteristic.hp));
        tvZoupleTue.setText(String.valueOf(ZoupleTue));
        tvGoldEarn.setText(String.valueOf(Golds));
        CaracterTvDamages.setText(String.valueOf(Math.round(SecondActivity.currentCaracter.caracteristic.damages)));
        CaracterTvDef.setText(String.valueOf(SecondActivity.currentCaracter.caracteristic.def));
        CaracterTvCritRate.setText(String.valueOf(SecondActivity.currentCaracter.caracteristic.critRate)+"%");
        //tvLVL.getText().toString()
    }
}