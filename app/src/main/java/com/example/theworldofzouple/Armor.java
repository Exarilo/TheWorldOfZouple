package com.example.theworldofzouple;

public class Armor {
    String name;
    String armorImg;
    int armorBonus;
    int cost;
    public Armor(String name,String armorImg,int armorBonus,int cost)
    {
        this.name=name;
        this.armorImg=armorImg;
        this.armorBonus=armorBonus;
        this.cost=cost;


    }

    //region getter
    public String getName() {
        return name;
    }

    public String getArmorImg() {
        return armorImg;
    }

    public int getArmorBonus() {
        return armorBonus;
    }
    public int getCost() {
        return cost;
    }



    //region setter
    public void setName(String name) {
        this.name = name;
    }

    public void setArmorImg(String armorImg) {
        this.armorImg = armorImg;
    }

    public void setArmorBonus(int armorBonus) {
        this.armorBonus = armorBonus;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }




}
