package com.example.theworldofzouple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    private TextView CaracterTvDodgeRate;
    private TextView tvPtsARepartir;

    private Button btUpgradeHP;
    private Button btUpgradeDef;
    private Button btUpgradeDamages;
    private Button btUpgradeCritRate;
    private Button btUpgradeDodgeRate;
    private Button btCloseCaracter;

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
        CaracterTvDodgeRate=findViewById(R.id.CaracterTvDodgeRate);
        tvPtsARepartir=findViewById(R.id.tvPtsARepartir);


        btUpgradeHP=findViewById(R.id.btUpgradeHP);
        btUpgradeDef=findViewById(R.id.btUpgradeDef);
        btUpgradeDamages=findViewById(R.id.btUpgradeDamages);
        btUpgradeCritRate=findViewById(R.id.btUpgradeCritRate);
        btUpgradeDodgeRate=findViewById(R.id.btUpgradeDodgeRate);

        CaracterTvLVL.setText(String.valueOf(SecondActivity.currentCaracter.caracteristic.lvl));
        CaracterTvMaxHP.setText(String.valueOf(SecondActivity.currentCaracter.caracteristic.hp));
        tvZoupleTue.setText(String.valueOf(ZoupleTue));
        tvGoldEarn.setText(String.valueOf(Golds));
        CaracterTvDamages.setText(String.valueOf(Math.round(SecondActivity.currentCaracter.caracteristic.damages)));
        CaracterTvDef.setText(String.valueOf(SecondActivity.currentCaracter.caracteristic.def));
        CaracterTvCritRate.setText(String.valueOf(SecondActivity.currentCaracter.caracteristic.critRate)+"%");
        CaracterTvDodgeRate.setText(String.valueOf(SecondActivity.currentCaracter.caracteristic.dodgeRate)+"%");

        tvPtsARepartir.setText(String.valueOf(SecondActivity.ptsARepartir));
        showPts();

        btCloseCaracter=findViewById(R.id.btCloseCaracter);

        btCloseCaracter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CaracterActivity.this.finish();
            }
        });




        btUpgradeHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Upgrade(btUpgradeHP.getTag().toString());
            }
        });

        btUpgradeDef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Upgrade(btUpgradeDef.getTag().toString());
            }
        });
        btUpgradeDamages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Upgrade(btUpgradeDamages.getTag().toString());
            }
        });
        btUpgradeCritRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Upgrade(btUpgradeCritRate.getTag().toString());
            }
        });
        btUpgradeDodgeRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Upgrade(btUpgradeDodgeRate.getTag().toString());
            }
        });

        //tvLVL.getText().toString()
    }
    public void showPts(){
        if(SecondActivity.ptsARepartir>0) {
            tvPtsARepartir.setTextColor(Color.parseColor("#1B8601"));

            btUpgradeHP.setVisibility(View.VISIBLE);
            btUpgradeDef.setVisibility(View.VISIBLE);
            btUpgradeDamages.setVisibility(View.VISIBLE);
            if(SecondActivity.ptsARepartir>1){
                btUpgradeCritRate.setVisibility(View.VISIBLE);
                btUpgradeDodgeRate.setVisibility(View.VISIBLE);
            }
            else{
                btUpgradeCritRate.setVisibility(View.INVISIBLE);
                btUpgradeDodgeRate.setVisibility(View.INVISIBLE);
            }

        }
        else {
            tvPtsARepartir.setTextColor(Color.parseColor("#FF0000"));
            btUpgradeHP.setVisibility(View.INVISIBLE);
            btUpgradeDef.setVisibility(View.INVISIBLE);
            btUpgradeDamages.setVisibility(View.INVISIBLE);
            btUpgradeCritRate.setVisibility(View.INVISIBLE);
            btUpgradeDodgeRate.setVisibility(View.INVISIBLE);
        }

    }
    public void Upgrade(String Tag){
        if(SecondActivity.ptsARepartir<=0)
            return;
        if(Tag.compareToIgnoreCase( "upgradeHP")==0)
        {
            SecondActivity.currentCaracter.caracteristic.hp+=5;
            SecondActivity.ptsARepartir-=1;
            CaracterTvMaxHP.setText(String.valueOf(SecondActivity.currentCaracter.caracteristic.hp));
        }
        else if(Tag.compareToIgnoreCase( "upgradeDef")==0)
        {
            SecondActivity.currentCaracter.caracteristic.def+=1;
            SecondActivity.ptsARepartir-=1;
            CaracterTvDef.setText(String.valueOf(SecondActivity.currentCaracter.caracteristic.def));
        }
        else if(Tag.compareToIgnoreCase( "upgradeDamages")==0)
        {
            SecondActivity.currentCaracter.caracteristic.damages+=5;
            SecondActivity.ptsARepartir-=1;
            CaracterTvDamages.setText(String.valueOf(Math.round(SecondActivity.currentCaracter.caracteristic.damages)));
        }
        else if(Tag.compareToIgnoreCase( "upgradeCritRate")==0)
        {

            SecondActivity.currentCaracter.caracteristic.critRate+=1;
            SecondActivity.ptsARepartir-=2;
            CaracterTvCritRate.setText(String.valueOf(SecondActivity.currentCaracter.caracteristic.critRate));
        }
        else if(Tag.compareToIgnoreCase( "upgradeDodgeRate")==0)
        {

            SecondActivity.currentCaracter.caracteristic.dodgeRate+=1;
            SecondActivity.ptsARepartir-=2;
            CaracterTvDodgeRate.setText(String.valueOf(SecondActivity.currentCaracter.caracteristic.dodgeRate));
        }
        tvPtsARepartir.setText(String.valueOf(SecondActivity.ptsARepartir));
        showPts();
    }
}








