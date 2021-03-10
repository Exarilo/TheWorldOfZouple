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

public class ConsumableItemAdapter extends BaseAdapter{
    private Context context;
    private List<Consumable> consumablesList;
    private LayoutInflater inflater;

    public ConsumableItemAdapter(Context context, List<Consumable>consumablesList){
        this.context=context;
        this.consumablesList=consumablesList;
        this.inflater=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return consumablesList.size();
    }

    @Override
    public Consumable getItem(int position) {
        return consumablesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.adapter_item,null);
        Consumable currentConsumableItem =getItem(i);
        String itemName = currentConsumableItem.getName();
        String itemImg =currentConsumableItem.getConsumableImg();
        int itemCost=currentConsumableItem.getCost();
        int itemHealthBonus=currentConsumableItem.getHealthBonus();
        int itemCara=currentConsumableItem.getPtsCara();


        TextView itemNameView = view.findViewById(R.id.name);
        itemNameView.setText(itemName);
        TextView itemDescriptionView = view.findViewById(R.id.itemDescription);

        if(itemCara!=0)
            itemDescriptionView.setText("+ "+String.valueOf(itemCara)+" pts de caractéristiques");
        else
            itemDescriptionView.setText("+ "+String.valueOf(itemHealthBonus)+" soin");

        TextView itemCostView = view.findViewById(R.id.cost);
        itemCostView.setText(String.valueOf(itemCost));





        ImageView ConsumableImg = view.findViewById(R.id.itemImg);
        int res = context.getResources().getIdentifier(itemImg, "mipmap", context.getPackageName());
        ConsumableImg.setImageResource(res);



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"salut",Toast.LENGTH_LONG);
            }
        });


        return view;
    }
}
