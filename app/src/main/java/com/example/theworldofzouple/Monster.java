package com.example.theworldofzouple;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Monster {
    //region member
    String name;
    String monsterImg;
    String monsterAttackImg;

    Caracteristic caracteristic;
    int xp;
    int gold;

    List<Loot> listLoots = new ArrayList<Loot>();


    //endregion
    //region constructor
    public Monster(String name,String monsterImg,String monsterAttackImg,int xp,int gold)
    {
        this.name=name;
        this.monsterImg=monsterImg;
        this.monsterAttackImg=monsterAttackImg;
        this.xp=xp;
        this.gold=gold;
        this.caracteristic=new Caracteristic();


    }
    //endregion
    //region getter
    public String getName(){
        return  name;
    }

    public String getMonsterImg() {
        return monsterImg;
    }

    public String getMonsterAttackImg() {
        return monsterAttackImg;
    }


    public int getXp() {
        return xp;
    }

    public int getGold() {
        return gold;
    }



    //endregion
    //region setter
    public void setName(String name) {
        this.name = name;
    }

    public void setMonsterImg(String monsterImg) {
        this.monsterImg = monsterImg;
    }

    public void setMonsterAttackImg(String monsterAttackImg) {
        this.monsterAttackImg = monsterAttackImg;
    }


    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }


    //endregion

    //region Methode
    public void addLoot(Loot oneLoot){
        listLoots.add(oneLoot);
    }

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
