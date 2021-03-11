package com.example.theworldofzouple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.r0adkll.slidr.Slidr;

public class ShopActivity extends AppCompatActivity {

    private int Golds;
    private TextView tvGolds;
    private Button btCloseShop;


    TabLayout tableLayout;
    private TabItem tab_Armes;
    private TabItem tab_Armures;
    private TabItem tab_Consommables;
    private TabItem tab_Materiaux;
    private ViewPager ShopViewPager;

    private  ConsumableFragment consumableFragment;
    private  ArmorFragment armorFragment;
    private  WeaponFragment weaponFragment;
    private  MaterialFragment materialFragment;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    //    Slidr.attach(this);



        consumableFragment=new ConsumableFragment();
        armorFragment=new ArmorFragment();
        weaponFragment=new WeaponFragment();
        materialFragment=new MaterialFragment();

        Golds = SecondActivity.currentCaracter.gold;


        tvGolds=findViewById(R.id.tvGoldsShop);
        tvGolds.setText(String.valueOf(Golds));

        tableLayout=  findViewById(R.id.tableLayoutShop); // RETURN NULL
        tab_Armes=findViewById(R.id.tab_Armes);
        tab_Armures=findViewById(R.id.tab_Armures);
        tab_Consommables=findViewById(R.id.tab_Consommables);
        tab_Materiaux=findViewById(R.id.tab_Materiaux);
        ShopViewPager=findViewById(R.id.ShopViewPager);
        PagerAdapter pagerAdapter =new PagerAdapter(getSupportFragmentManager(),tableLayout.getTabCount());
        ShopViewPager.setAdapter(pagerAdapter);

        //ShopViewPager.setCurrentItem(0, true);
        tableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ShopViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        btCloseShop=findViewById(R.id.btCloseShop);

        btCloseShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShopActivity.this.finish();
            }
        });
    }
}