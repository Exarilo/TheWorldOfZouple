package com.example.theworldofzouple;

public class UserCaracter {

    //region member
    String name;
    String CaracterImg;
    String CaracterAttackImg;
    String CaracterDamagesImg;
    int xp;
    double maxXP;
    Caracteristic caracteristic;
    InventoryObject inventory;
    int gold;
    int ptsARepartir;

    //int xp;

    //endregion
    //region constructor
    public UserCaracter(String name,String CaracterImg,String CaracterAttackImg,String CaracterDamagesImg,int gold,int xp,double maxXP,int ptsARepartir)
    {
        this.name=name;
        this.CaracterImg=CaracterImg;
        this.CaracterAttackImg=CaracterAttackImg;
        this.CaracterDamagesImg=CaracterDamagesImg;
        this.gold=gold;
        this.caracteristic=new Caracteristic();
        this.inventory=new InventoryObject();
        this.xp=xp;
        this.maxXP=maxXP;
        this.ptsARepartir=ptsARepartir;
    }

    //region constructor

    //region getter

    public int getPtsARepartir() {
        return ptsARepartir;
    }

    public void setPtsARepartir(int ptsARepartir) {
        this.ptsARepartir = ptsARepartir;
    }

    public String getName(){
        return  name;
    }

    public String getCaracterImg() {
        return CaracterImg;
    }

    public String getCaracterAttackImg() {
        return CaracterAttackImg;
    }

    public String getCaracterDamagesImg(){
        return  CaracterDamagesImg;
    }

    public int getGold() {
        return gold;
    }
    //endregion


    //region setter

    public void setName(String name) {
        this.name = name;
    }

    public void setCaracterImg(String caracterImg) {
        CaracterImg = caracterImg;
    }

    public void setCaracterAttackImg(String caracterAttackImg) {
        CaracterAttackImg = caracterAttackImg;
    }

    public void setCaracterDamagesImg(String caracterDamagesImg) {
        CaracterDamagesImg = caracterDamagesImg;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
    //endregion


    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getXp() {
        return xp;
    }

    public double getMaxXP() {
        return maxXP;
    }

    public void setMaxXP(double maxXP) {
        this.maxXP = maxXP;
    }

    //region Methode
    public void setCaracteristic(int lvl,int currentHP,int hp,int def,double damages, int critRate,int dodgeRate ){
        caracteristic.lvl=lvl;
        caracteristic.currentHP=currentHP;
        caracteristic.hp=hp;
        caracteristic.def=def;
        caracteristic.damages=damages;
        if(critRate<=100)
            caracteristic.critRate=critRate;
        if(dodgeRate<=50)
            caracteristic.dodgeRate=dodgeRate;
    }
    //endregion
}
