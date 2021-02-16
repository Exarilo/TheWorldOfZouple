package com.example.theworldofzouple;

import android.widget.ImageView;

public class Loot {
    String name;
    ImageView imgLoot;
    int proba;


    //region Constructor
    public Loot(){

    }
    public Loot(String name,ImageView imgLoot, int proba ){
        this.name=name;
        this.imgLoot=imgLoot;
        this.proba=proba;

    }
    //endregion

    //region getter
    public String getName() {
        return name;
    }

    public ImageView getImgLoot() {
        return imgLoot;
    }

    public int getProba() {
        return proba;
    }

    //endregion

    //region setter
    public void setName(String name) {
        this.name = name;
    }

    public void setImgLoot(ImageView imgLoot) {
        this.imgLoot = imgLoot;
    }

    public void setProba(int proba) {
        this.proba = proba;
    }
    //endregion
}
