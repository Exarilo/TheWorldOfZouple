package com.example.theworldofzouple;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


/*String CreateDatabase= "create table user("
        + "lvl INTEGER NOT NULL,"
        + "xp INTEGER NOT NULL);";
db.execSQL(CreateDatabase);*/

public class Database extends SQLiteOpenHelper {


    public static final String ID = "ID";
    public static final String TABLE_NAME = "User";
    public static final String UserLvl = "Lvl ";
    public static final String UserXP = "XP ";
    public static final String UserXPMax = "XPMax ";
    public static final String UserGold = "Gold ";
    public static final String UserCurrentHP = "CurrentHP ";

    //TODOOOOOOOOOOO USER MAX HP !!


    public Database(@Nullable Context context) {
        super(context, TABLE_NAME, null, 32);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable= "CREATE TABLE " + TABLE_NAME + "(ID INTEGER DEFAULT 1 ," + UserLvl + " Integer DEFAULT 1 ," + UserXP +
                " Integer DEFAULT 0," + UserXPMax + " Integer DEFAULT 100 ," + UserGold+ " Integer DEFAULT 0 ," + UserCurrentHP + " Integer DEFAULT 1000);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean addData(String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        if (getData() <1){
            contentValues.put(ID, 1);
            contentValues.put(UserLvl, item);
            contentValues.put(UserXP, 0);
            contentValues.put(UserXPMax, 100);
            contentValues.put(UserGold, 0);
            contentValues.put(UserCurrentHP, 1000);
            long result = db.insert(TABLE_NAME, null, contentValues);
            if (result == -1) {
                return false;
            } else{
                return true;
            }
        }
        else
            return false;

    }
    public long getData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Long numIdUser = DatabaseUtils.queryNumEntries(db,"User",null);

        return numIdUser;
    }


    public void updateLvl(int lvl) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Lvl",lvl);
        db.update("User", cv, "", new String[]{});
    }
    public int getLvl(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor =db.query("User",new String[]{"Lvl"},null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            return cursor.getInt(cursor.getColumnIndex("Lvl"));
        }
        return 1;
    }

    public void updateXP(int xp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("XP",xp);
        db.update("User", cv, "", new String[]{});
    }
    public int getXP(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor =db.query("User",new String[]{"XP"},null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            return cursor.getInt(cursor.getColumnIndex("XP"));
        }
        return 0;
    }

    public void updateMaxXP(int xp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("XPMax",xp);
        db.update("User", cv, "", new String[]{});
    }
    public int getMaxXP(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor =db.query("User",new String[]{"XPMax"},null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            return cursor.getInt(cursor.getColumnIndex("XPMax"));
        }
        return 0;
    }


    public void updateGold(int gold) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Gold",gold);
        db.update("User", cv, "", new String[]{});
    }
    public int getGold(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor =db.query("User",new String[]{"Gold"},null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            return cursor.getInt(cursor.getColumnIndex("Gold"));
        }
        return 0;
    }

    public void updateCurrentHP(int currentHP) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("CurrentHP",currentHP);
        db.update("User", cv, "", new String[]{});
    }
    public int getCurrentHP(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor =db.query("User",new String[]{"CurrentHP"},null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            return cursor.getInt(cursor.getColumnIndex("CurrentHP"));
        }
        return 0;
    }
}
