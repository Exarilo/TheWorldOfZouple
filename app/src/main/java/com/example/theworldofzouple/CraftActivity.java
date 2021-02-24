package com.example.theworldofzouple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.r0adkll.slidr.Slidr;

public class CraftActivity extends AppCompatActivity {
    private Button btCloseCraft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_craft);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Slidr.attach(this);


        btCloseCraft=findViewById(R.id.btCloseCraft);

        btCloseCraft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CraftActivity.this.finish();
            }
        });

    }
}