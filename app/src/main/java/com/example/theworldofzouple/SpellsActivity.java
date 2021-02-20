package com.example.theworldofzouple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

public class SpellsActivity extends AppCompatActivity {

    private TextView tvGoldSpell;
    private Button btBuySpell1;
    private TextView costSpell1;
    boolean AlreadyBuySpell1=false;


    private int Golds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spells);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Slidr.attach(this);

        Intent intent = getIntent();
        Golds = intent.getIntExtra("CurrentGolds",0); // get the value



        tvGoldSpell=findViewById(R.id.tvGoldSpell);
        tvGoldSpell.setText(String.valueOf(Golds));


        costSpell1=findViewById(R.id.costSpell1);
        btBuySpell1= findViewById(R.id.btBuySpell1);

        btBuySpell1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = costSpell1;

                AlreadyBuySpell1=setAchat(AlreadyBuySpell1,tv);
            }
        });
    }



    public boolean setAchat(boolean alreadyBuy,TextView tvCost){
        if(alreadyBuy==true)
            return true;
        int cost = Integer.parseInt(tvCost.getText().toString());
        if(Golds>= cost){
            Golds=Golds-cost;
            tvGoldSpell.setText(String.valueOf(Golds));
            alreadyBuy=true;

        }

        return false;
    }
}