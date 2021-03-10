package com.example.theworldofzouple;

public class Caracteristic {

    //region member
    int lvl;
    int hp;
    int def;
    double damages;
    int critRate;
    int dodgeRate;
    //endregion



    //region Constructor
    public Caracteristic(){

    }

    public Caracteristic(int lvl,int hp,int def,int damages, int critRate,int dodgeRate){
        super();
        this.lvl=lvl;
        this.hp=hp;
        this.def=def;
        this.damages=damages;
        this.critRate=critRate;
        this.dodgeRate=dodgeRate;
    }
    //endregion

    //region getter
    public int getLvl() {
        return lvl;
    }

    public int getHp() {
        return hp;
    }

    public int getDef() {
        return def;
    }

    public double getDamages() {
        return damages;
    }

    public int getCritRate() {
        return critRate;
    }

    public int getDodgeRate() {
        return dodgeRate;
    }

    //endregion

    //region setter
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setDamages(int damages) {
        this.damages = damages;
    }

    public void setCritRate(int critRate) {
        this.critRate = critRate;
    }

    public void setDodgeRate(int dodgeRate) {
        this.dodgeRate = dodgeRate;
    }
    //endregion
}
