package com.example.theworldofzouple;

public class UserCaracter {

    //region member
    String name;
    String CaracterImg;
    String CaracterAttackImg;
    String CaracterDamagesImg;
    Caracteristic caracteristic;
    int gold;
    //int xp;

    //endregion
    //region constructor
    public UserCaracter(String name,String CaracterImg,String CaracterAttackImg,String CaracterDamagesImg,int xp,int gold)
    {
        this.name=name;
        this.CaracterImg=CaracterImg;
        this.CaracterAttackImg=CaracterAttackImg;
        this.CaracterDamagesImg=CaracterDamagesImg;
        this.gold=gold;
        this.caracteristic=new Caracteristic();
        //this.xp=xp;
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
    public void setCaracteristic(int lvl,int hp,int def,int damages, int critRate,int dodgeRate ){
        caracteristic.lvl=lvl;
        caracteristic.hp=hp;
        caracteristic.def=def;
        caracteristic.damages=damages;
        caracteristic.critRate=critRate;
        caracteristic.dodgeRate=dodgeRate;
    }
    //endregion
}
