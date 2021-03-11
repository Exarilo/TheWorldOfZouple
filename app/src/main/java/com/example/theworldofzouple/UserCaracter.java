package com.example.theworldofzouple;

public class UserCaracter {

    //region member
    String name;
    String CaracterImg;
    String CaracterAttackImg;
    String CaracterDamagesImg;
    Caracteristic caracteristic;
    InventoryObject inventory;
    int gold;
    //int xp;

    //endregion
    //region constructor
    public UserCaracter(String name,String CaracterImg,String CaracterAttackImg,String CaracterDamagesImg,int gold)
    {
        this.name=name;
        this.CaracterImg=CaracterImg;
        this.CaracterAttackImg=CaracterAttackImg;
        this.CaracterDamagesImg=CaracterDamagesImg;
        this.gold=gold;
        this.caracteristic=new Caracteristic();
        this.inventory=new InventoryObject();

    }

    //region constructor

    //region getter
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





    //region Methode
    public void setCaracteristic(int lvl,int hp,int def,double damages, int critRate,int dodgeRate ){
        caracteristic.lvl=lvl;
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
