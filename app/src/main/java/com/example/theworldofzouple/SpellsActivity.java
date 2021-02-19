package com.example.theworldofzouple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpellsActivity extends AppCompatActivity {

    private TextView tvGoldSpell;
    private Button btBuySpell1;
    private TextView costSpell1;
    boolean achatSpell1=false;


    private int Golds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spells);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent intent = getIntent();
        Golds = intent.getIntExtra("CurrentGolds",0); // get the value


        tvGoldSpell=findViewById(R.id.tvGoldSpell);
        tvGoldSpell.setText(String.valueOf(Golds));


        costSpell1=findViewById(R.id.costSpell1);
        btBuySpell1= findViewById(R.id.btBuySpell1);







        btBuySpell1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buySpell1();
            }
        });
    }

    public void buySpell1(){
        if(achatSpell1==true)
            return;
        int cost = Integer.parseInt(costSpell1.getText().toString());
        if(Golds>= cost){
            Golds=Golds-cost;
            tvGoldSpell.setText(String.valueOf(Golds));
            achatSpell1=true;

        }
    }
}