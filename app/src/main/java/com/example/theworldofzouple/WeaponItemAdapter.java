package com.example.theworldofzouple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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


        TextView itemNameView = view.findViewById(R.id.name);
        itemNameView.setText(itemName);

        TextView itemCostView = view.findViewById(R.id.cost);
        itemCostView.setText(String.valueOf(itemCost));

        TextView itemDescriptionView = view.findViewById(R.id.itemDescription);
        if(itemCritRateBonus!=0)
            itemDescriptionView.setText("+ "+String.valueOf(itemDamagesBonus)+" degats\n+ "+String.valueOf(itemCritRateBonus)+"% Taux de critique");
        else
            itemDescriptionView.setText("+ "+String.valueOf(itemDamagesBonus)+" degats");

        ImageView WeaponImg = view.findViewById(R.id.itemImg);
        int res = context.getResources().getIdentifier(itemImg, "mipmap", context.getPackageName());
        WeaponImg.setImageResource(res);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"salut",Toast.LENGTH_LONG);
            }
        });


        return view;
    }
}
