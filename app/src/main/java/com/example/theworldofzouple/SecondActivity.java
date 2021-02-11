package com.example.theworldofzouple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class SecondActivity extends AppCompatActivity {
    private Button btMenuCaracter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        btMenuCaracter= findViewById(R.id.btCaracter);
        btMenuCaracter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToMenuCaracter();
            }
        });





        btMenuCaracter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToMenuCaracter();
            }
        });


    }

    private void moveToMenuCaracter(){
        Intent intent =new Intent(SecondActivity.this,CaracterActivity.class);
        startActivity(intent);
    }
}