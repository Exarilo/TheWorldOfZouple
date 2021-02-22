package com.example.theworldofzouple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

public class ShopActivity extends AppCompatActivity {

    private int Golds;
    private TextView tvGolds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Slidr.attach(this);

        Golds = SecondActivity.currentCaracter.gold;


        tvGolds=findViewById(R.id.tvGoldsShop);
        tvGolds.setText(String.valueOf(Golds));
    }
}