package com.example.theworldofzouple;



public class Spell {
    String name;
    String spellImg;
    double ratioDamagesBonus;
    int cost;
    public Spell(String name,String spellImg,double ratioDamagesBonus,int cost)
    {
            this.name=name;
            this.spellImg=spellImg;
            this.ratioDamagesBonus=ratioDamagesBonus;
            this.cost=cost;
    }

    //region getter
    public String getName() {
        return name;
    }
    public String getSpellImg(){
        return spellImg;
    }

    public double getRatioDamagesBonus() {
        return ratioDamagesBonus;
    }

    public int getCost() {
        return cost;
    }
    //endregion

    //region setter
    public void setName(String name) {
        this.name = name;
    }

    public void setSpellImg(String spellImg) {
        this.spellImg = spellImg;
    }

    public void setRatioDamagesBonus(double ratioDamagesBonus) {
        this.ratioDamagesBonus = ratioDamagesBonus;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    //endregion
}
