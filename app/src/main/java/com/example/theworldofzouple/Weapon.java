package com.example.theworldofzouple;

public class Weapon {
    String name;
    String weaponImg;
    int damagesBonus;
    int critRateBonus;
    int cost;
    public Weapon(String name,String weaponImg,int damagesBonus,int cost,int critRateBonus )
    {
        this.name=name;
        this.weaponImg=weaponImg;
        this.damagesBonus=damagesBonus;
        this.cost=cost;
        this.critRateBonus=critRateBonus;
    }

    //region getter
    public String getName() {
        return name;
    }
    public String getWeaponImg(){
        return weaponImg;
    }

    public int getDamagesBonus() {
        return damagesBonus;
    }

    public int getCost() {
        return cost;
    }

    public int getCritRateBonus() {
        return critRateBonus;
    }
    //endregion

    //region setter
    public void setName(String name) {
        this.name = name;
    }

    public void setWeaponImg(String spellImg) {
        this.weaponImg = spellImg;
    }

    public void setRatioDamagesBonus(int ratioDamagesBonus) {
        this.damagesBonus = ratioDamagesBonus;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setCritRateBonus(int critRateBonus) {
        this.critRateBonus = critRateBonus;
    }
}
