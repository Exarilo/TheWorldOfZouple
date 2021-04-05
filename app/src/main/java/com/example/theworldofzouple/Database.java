package com.example.theworldofzouple;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class Database extends SQLiteOpenHelper {


    public static final String ID = "ID";
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








    public Database(@Nullable Context context) {
        super(context, "User", null, 63);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable= "CREATE TABLE " + "User" + "(ID INTEGER DEFAULT 1 ," + UserLvl + " Integer DEFAULT 1 ," + UserXP +
                " Integer DEFAULT 0," + UserXPMax + " Integer DEFAULT 100 ," + UserGold+ " Integer DEFAULT 0 ," + UserCurrentHP + " Integer DEFAULT 1000 ," +
                UserMaxHP +"Integer DEFAULT 1000 ," + UserDamages +" Integer DEFAULT 400 ," + UserDef + " Integer DEFAULT 10 ," + UserCritRate +" Integer DEFAULT 1 ," +
                UserDodgeRate + " Integer DEFAULT 1 ," + UserAttackImg + " String DEFAULT 'spelldepart_foreground'  );";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "User");
        onCreate(db);
    }



    public boolean SaveCar(UserCaracter user){
        SQLiteDatabase db = this.getWritableDatabase();
        Long numIdUser = DatabaseUtils.queryNumEntries(db,"User",null);
        if (numIdUser < 1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ID, 1);
            long result = db.insert("User", "ID", contentValues);
        }
        numIdUser = DatabaseUtils.queryNumEntries(db,"User",null);
        if (numIdUser >= 1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ID, 1);
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


        Cursor cursor =db.query("User", allColumns_User, "ID = 1",null,null,null,null);
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
}
