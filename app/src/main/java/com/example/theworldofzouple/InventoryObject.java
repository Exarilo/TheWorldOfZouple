package com.example.theworldofzouple;

import java.util.ArrayList;
import java.util.List;

public class InventoryObject {
    private List<Spell> spellList =  new ArrayList<Spell>() ;
    private List<Weapon> weaponList =  new ArrayList<Weapon>() ;
    private List<Armor> armorList =  new ArrayList<Armor>() ;
    private List<Consumable> ConsumableList =  new ArrayList<Consumable>() ;

    //List<Material> materialListList =  new ArrayList<Material>() ;

    public InventoryObject()
    {

    }


    public void addSpell(Spell spell){
        if(!spellList.contains(spell))
            spellList.add(spell);
    }
    //region getter

    public List<Spell> getSpellList() {
        return spellList;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public List<Armor> getArmorList() {
        return armorList;
    }

    public List<Consumable> getConsumableList() {
        return ConsumableList;
    }
    //endregion



    //region setter

    public void setSpellList(List<Spell> spellList) {
        this.spellList = spellList;
    }

    public void setWeaponList(List<Weapon> weaponList) {
        this.weaponList = weaponList;
    }

    public void setArmorList(List<Armor> armorList) {
        this.armorList = armorList;
    }

    public void setConsumableList(List<Consumable> consumableList) {
        ConsumableList = consumableList;
    }
    //endregion


}
