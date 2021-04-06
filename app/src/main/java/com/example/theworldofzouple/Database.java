package com.example.theworldofzouple;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class Database extends SQLiteOpenHelper {


    public static final String UserID = "ID";
    public static final String UserLvl = "Lvl ";
    public static final String UserXP = "XP ";
    public static final String UserXPMax = "XPMax ";
    public static final String UserGold = "Gold ";
    public static final String UserCurrentHP = "CurrentHP ";
    public static final String UserMaxHP = "MaxHP ";
    public static final String UserDamages = "Damages ";
    public static final String UserDef = "Def ";
    public static final String UserCritRate = "CritRate ";
    public static final String UserDodgeRate = "DodgeRate ";
    public static final String UserAttackImg = "AttackImg ";


    public static final String MonsterID = "ID";
    public static final String MonsterLvl = "Lvl ";
    public static final String MonsterCurrentHP = "CurrentHP ";
    public static final String MonsterMaxHP = "MaxHP ";
    public static final String MonsterDamages = "Damages ";
    public static final String MonsterDef = "Def ";
    public static final String MonsterCritRate = "CritRate ";
    public static final String MonsterDodgeRate = "DodgeRate ";
    public static final String MonsterAttackImg = "AttackImg ";
    public static final String MonsterImg = "Img ";
    public static final String MonsterImgDamage = "ImgDamage ";
    public static final String MonsterXP = "XP ";
    public static final String MonsterGold = "Gold ";


    public static final String InventoryID = "ID";
    public static final String InventoryName = "Name ";
    public static final String InventoryType = "Type ";
    public static final String InventoryUserID = "UserID ";

    public Database(@Nullable Context context) {
        super(context, "ZoupleDatabase", null, 92);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableUser= "CREATE TABLE " + "User" + "(ID INTEGER DEFAULT 1 ," + UserLvl + " Integer DEFAULT 1 ," + UserXP +
                " Integer DEFAULT 0," + UserXPMax + " Integer DEFAULT 100 ," + UserGold+ " Integer DEFAULT 0 ," + UserCurrentHP + " Integer DEFAULT 1000 ," +
                UserMaxHP +"Integer DEFAULT 1000 ," + UserDamages +" Integer DEFAULT 400 ," + UserDef + " Integer DEFAULT 10 ," + UserCritRate +" Integer DEFAULT 1 ," +
                UserDodgeRate + " Integer DEFAULT 1 ," + UserAttackImg + " String DEFAULT 'spelldepart_foreground'  );";


        String createTableMonster= "CREATE TABLE " + "Monster" + "(ID INTEGER DEFAULT 1 ," + MonsterLvl + " Integer DEFAULT 1 ," +  MonsterCurrentHP + " Integer DEFAULT 1000 ," +
                MonsterMaxHP +"Integer DEFAULT 1000 ," + MonsterDamages +" Integer DEFAULT 30 ," + MonsterDef + " Integer DEFAULT 0 ," + MonsterCritRate +" Integer DEFAULT 0 ," +
                MonsterDodgeRate + " Integer DEFAULT 0 ," + MonsterAttackImg + " String DEFAULT 'larveattack_foreground' ," + MonsterImg + " String DEFAULT 'larve_foreground' ,"
                + MonsterImgDamage + " String DEFAULT 'larvedegats_foreground' ," + MonsterXP + " Integer DEFAULT 49 ," + MonsterGold + " Integer DEFAULT 50);";



        String createTableInventory= "CREATE TABLE " + "Inventory" + "(ID INTEGER PRIMARY KEY AUTOINCREMENT ," + InventoryType +" Integer DEFAULT 1 ," + InventoryName + " String DEFAULT 'Item_Name',"
                + InventoryUserID +" Integer DEFAULT 1 );";


        db.execSQL(createTableUser);
        db.execSQL(createTableMonster);
        db.execSQL(createTableInventory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "User");
        db.execSQL("DROP TABLE IF EXISTS " + "Monster");
        db.execSQL("DROP TABLE IF EXISTS " + "Inventory");
        onCreate(db);
    }



    public boolean SaveCar(UserCaracter user){
        SQLiteDatabase db = this.getWritableDatabase();
        Long numIdUser = DatabaseUtils.queryNumEntries(db,"User",null);
        if (numIdUser < 1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(UserID, 1);
            long result = db.insert("User", "ID", contentValues);
        }
        numIdUser = DatabaseUtils.queryNumEntries(db,"User",null);
        if (numIdUser >= 1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(UserID, 1);
            contentValues.put(UserLvl, user.caracteristic.lvl);
            contentValues.put(UserXP, user.xp);
            contentValues.put(UserXPMax, user.maxXP);
            contentValues.put(UserGold, user.gold);
            contentValues.put(UserCurrentHP, user.caracteristic.currentHP);
            contentValues.put(UserMaxHP, user.caracteristic.hp);
            contentValues.put(UserDamages, user.caracteristic.damages);
            contentValues.put(UserDef, user.caracteristic.def);
            contentValues.put(UserCritRate, user.caracteristic.critRate);
            contentValues.put(UserDodgeRate, user.caracteristic.dodgeRate);
            contentValues.put(UserAttackImg, user.CaracterAttackImg);


            db.update("User", contentValues, "ID= ? ", new String[]{"1"});
            return true;
        }
        return false;
    }

    public boolean LoadCar(UserCaracter user){

        SQLiteDatabase db = this.getReadableDatabase();

        String[] allColumns_User = { "ID", "Lvl", "XP", "XPMax", "Gold","CurrentHP","MaxHP","Damages","Def","CritRate","DodgeRate","AttackImg"};


        Cursor cursor =db.query("User", allColumns_User, "ID = ?",new String[]{"1"},null,null,null);
        if( cursor != null && cursor.moveToFirst() ){
            user.caracteristic.lvl=cursor.getInt(cursor.getColumnIndex("Lvl"));
            user.xp=cursor.getInt(cursor.getColumnIndex("XP"));
            user.maxXP=cursor.getInt(cursor.getColumnIndex("XPMax"));
            user.gold=cursor.getInt(cursor.getColumnIndex("Gold"));
            user.caracteristic.currentHP=cursor.getInt(cursor.getColumnIndex("CurrentHP"));
            user.caracteristic.hp=cursor.getInt(cursor.getColumnIndex("MaxHP"));
            user.caracteristic.damages=cursor.getInt(cursor.getColumnIndex("Damages"));
            user.caracteristic.def=cursor.getInt(cursor.getColumnIndex("Def"));
            user.caracteristic.critRate=cursor.getInt(cursor.getColumnIndex("CritRate"));
            user.caracteristic.dodgeRate=cursor.getInt(cursor.getColumnIndex("DodgeRate"));
            user.CaracterAttackImg=cursor.getString(cursor.getColumnIndex("AttackImg"));



            cursor.close();
            return true;

        }

        return false;
    }


    public boolean SaveMonster(Monster monster){
        SQLiteDatabase db = this.getWritableDatabase();
        Long numIdMonster = DatabaseUtils.queryNumEntries(db,"Monster",null);
        if (numIdMonster < 1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(MonsterID, 1);
            long result = db.insert("Monster", "ID", contentValues);
        }
        numIdMonster = DatabaseUtils.queryNumEntries(db,"Monster",null);
        if (numIdMonster >= 1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(MonsterID, 1);
            contentValues.put(MonsterLvl, monster.caracteristic.lvl);
            contentValues.put(MonsterCurrentHP, monster.caracteristic.currentHP);
            contentValues.put(MonsterMaxHP, monster.caracteristic.hp);
            contentValues.put(MonsterDamages, monster.caracteristic.damages);
            contentValues.put(MonsterDef, monster.caracteristic.def);
            contentValues.put(MonsterCritRate, monster.caracteristic.critRate);
            contentValues.put(MonsterDodgeRate, monster.caracteristic.dodgeRate);
            contentValues.put(MonsterAttackImg, monster.monsterAttackImg);
            contentValues.put(MonsterImg, monster.monsterImg);
            contentValues.put(MonsterImgDamage, monster.monsterDamagesImg);
            contentValues.put(MonsterXP, monster.xp);
            contentValues.put(MonsterGold, monster.gold);
            db.update("Monster", contentValues, "ID= ? ", new String[]{"1"});
            return true;
        }
        return false;
    }

    public boolean LoadMonster(Monster monster){

        SQLiteDatabase db = this.getReadableDatabase();

        String[] allColumns_numIdMonster = { "ID", "Lvl","CurrentHP","MaxHP","Damages","Def","CritRate","DodgeRate","AttackImg","Img","ImgDamage","XP","Gold"};


        Cursor cursor =db.query("Monster", allColumns_numIdMonster, "ID = ?",new String[]{"1"},null,null,null);
        if( cursor != null && cursor.moveToFirst() ){
            monster.caracteristic.lvl=cursor.getInt(cursor.getColumnIndex("Lvl"));
            monster.caracteristic.currentHP=cursor.getInt(cursor.getColumnIndex("CurrentHP"));
            monster.caracteristic.hp=cursor.getInt(cursor.getColumnIndex("MaxHP"));
            monster.caracteristic.damages=cursor.getInt(cursor.getColumnIndex("Damages"));
            monster.caracteristic.def=cursor.getInt(cursor.getColumnIndex("Def"));
            monster.caracteristic.critRate=cursor.getInt(cursor.getColumnIndex("CritRate"));
            monster.caracteristic.dodgeRate=cursor.getInt(cursor.getColumnIndex("DodgeRate"));
            monster.monsterAttackImg=cursor.getString(cursor.getColumnIndex("AttackImg"));
            monster.monsterImg=cursor.getString(cursor.getColumnIndex("Img"));
            monster.monsterDamagesImg=cursor.getString(cursor.getColumnIndex("ImgDamage"));
            monster.xp=cursor.getInt(cursor.getColumnIndex("XP"));
            monster.gold=cursor.getInt(cursor.getColumnIndex("Gold"));
            cursor.close();
            return true;

        }

        return false;
    }


    public boolean SaveInventory(InventoryObject inventory){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ "Inventory");


        for (Spell sp:inventory.getSpellList()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(InventoryType, 1);
            contentValues.put(InventoryName, sp.name);
            contentValues.put(InventoryUserID,1);
            long insertId = db.insert("Inventory",null,contentValues);

        }


        return true;
    }


    public List<String> LoadSpells(){
        List<String> listSpells = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] allColumns_numIdInventory = { "ID","Type", "Name","UserID"};


        Cursor cursor =db.query("Inventory", allColumns_numIdInventory, "Type =?",new String[]{"1"},null,null,null);

        if( cursor != null && cursor.moveToFirst() ){
            while (!cursor.isAfterLast()) {
                InventoryObject inventoryObject = new InventoryObject();
                String Name = cursor.getString(cursor.getColumnIndex("Name"));
                listSpells.add(Name);
                cursor.moveToNext();
            }
                        //inventory.getSpellList();
            cursor.close();

        }

        return listSpells;
    }


}
