package com.example.theworldofzouple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.r0adkll.slidr.Slidr;

public class InventoryActivity extends AppCompatActivity {
    private Button btCloseInventory;
    private ImageView currentSpellImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Slidr.attach(this);


        currentSpellImg= findViewById(R.id.currentSpellImg);
        btCloseInventory= findViewById(R.id.btCloseInventory);
        btCloseInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InventoryActivity.this.finish();
            }
        });



        int id= getResources().getIdentifier(SecondActivity.currentCaracter.CaracterAttackImg,"mipmap",getPackageName());
        if(id>0)
            currentSpellImg.setImageResource(id);


    }
}