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

public class ArmorItemAdapter extends BaseAdapter{
    private Context context;
    private List<Armor> armorList;
    private LayoutInflater inflater;


    public ArmorItemAdapter(Context context, List<Armor>armorList){
        this.context=context;
        this.armorList=armorList;
        this.inflater=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return armorList.size();
    }

    @Override
    public Armor getItem(int position) {
        return armorList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        view=inflater.inflate(R.layout.adapter_item,null);
        Armor currentArmorItem =getItem(i);
        String itemName = currentArmorItem.getName();
        String itemImg =currentArmorItem.getArmorImg();
        int itemCost=currentArmorItem.getCost();
        int itemArmorBonus=currentArmorItem.getArmorBonus();


        TextView itemNameView = view.findViewById(R.id.name);
        itemNameView.setText(itemName);

        TextView itemCostView = view.findViewById(R.id.cost);
        itemCostView.setText(String.valueOf(itemCost));

        TextView itemDescriptionView = view.findViewById(R.id.itemDescription);

        itemDescriptionView.setText("+ "+String.valueOf(itemArmorBonus)+" défense");
//ici
        ImageView ArmorImg = view.findViewById(R.id.itemImg);
        int res = context.getResources().getIdentifier(itemImg, "mipmap", context.getPackageName());
        ArmorImg.setImageResource(res);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"salut",Toast.LENGTH_LONG);
            }
        });


        return view;
    }
}
