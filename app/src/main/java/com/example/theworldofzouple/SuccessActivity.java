package com.example.theworldofzouple;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class SuccessActivity extends AppCompatActivity {
    private Button btCloseSucces;
    Activity SuccessActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        btCloseSucces=findViewById(R.id.btCloseSucces);


        btCloseSucces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SuccessActivity.this.finish();
            }
        });
    }
}