package com.example.theworldofzouple;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.List;

public class WeaponItemAdapter extends BaseAdapter{
    private Context context;
    private List<Weapon> weaponList;
    private LayoutInflater inflater;

    public WeaponItemAdapter(Context context, List<Weapon>weaponList){
        this.context=context;
        this.weaponList=weaponList;
        this.inflater=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return weaponList.size();
    }

    @Override
    public Weapon getItem(int position) {
        return weaponList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.adapter_item,null);
        Weapon currentItem =getItem(i);
        String itemName = currentItem.getName();
        String itemImg =currentItem.getWeaponImg();
        int itemCost=currentItem.getCost();
        int itemCritRateBonus = currentItem.getCritRateBonus();
        int itemDamagesBonus= currentItem.getDamagesBonus();
        ImageView armeImg = view.findViewById(R.id.armeImg);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return view;
    }
}
