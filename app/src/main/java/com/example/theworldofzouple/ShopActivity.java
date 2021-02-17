package com.example.theworldofzouple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity {

    private int Golds;
    private TextView tvGolds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Intent intent = getIntent();
        Golds = intent.getIntExtra("CurrentGolds",0); // get the value


        tvGolds=findViewById(R.id.tvGoldsShop);
        tvGolds.setText(String.valueOf(Golds));
    }
}