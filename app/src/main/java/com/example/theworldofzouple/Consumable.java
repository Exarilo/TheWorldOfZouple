package com.example.theworldofzouple;

public class Consumable {
    String name;
    String consumableImg;
    int ptsCara;
    int healthBonus;
    int cost;

    public Consumable(String name, String consumableImg, int healthBonus, int cost,int ptsCara) {
        this.name = name;
        this.consumableImg = consumableImg;
        this.healthBonus = healthBonus;
        this.cost = cost;
        this.ptsCara=ptsCara;
    }

    //region getter
    public String getName() {
        return name;
    }

    public int getDamagesBonus() {
        return healthBonus;
    }

    public int getCost() {
        return cost;
    }

    public int getPtsCara() {
        return ptsCara;
    }
//endregion

    //region setter
    public void setName(String name) {
        this.name = name;
    }

    public void setPtsCara(int ptsCara) {
        this.ptsCara = ptsCara;
    }

    public void setConsumableImg(String consumableImg) {
        this.consumableImg = consumableImg;
    }


    public void setCost(int cost) {
        this.cost = cost;
    }


    public int getHealthBonus() {
        return healthBonus;
    }

    public String getConsumableImg() {
        return consumableImg;
    }

    public void setHealthBonus(int healthBonus) {
        this.healthBonus = healthBonus;
    }
}
