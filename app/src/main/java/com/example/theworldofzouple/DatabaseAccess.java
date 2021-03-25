package com.example.theworldofzouple;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseAccess {
    private String dataBaseName ="dbZouple.sqlite";
    private Integer dataBaseVersion = 1;
    private Database accessToDatabase;
    private SQLiteDatabase db;
    static int autoInc=1;

    public DatabaseAccess(Context context){
        accessToDatabase=new Database(context,dataBaseName,null,dataBaseVersion);
    }
    /*
    public void addUser(UserCaracter userCaracter){
        db = accessToDatabase.getWritableDatabase();
        String query = "insert into user (idUser,lvl,xp) values";
        query+="("+autoInc+","+SecondActivity.currentCaracter.caracteristic.lvl+","+SecondActivity.xp+")";
        db.execSQL(query);
        autoInc++;
    }*/
    public void addUser(){
        db = accessToDatabase.getWritableDatabase();
        String query = "insert into user (lvl,xp) values ";
        query+="("+SecondActivity.currentCaracter.caracteristic.lvl+","+SecondActivity.xp+")";
        db.execSQL(query);
        autoInc++;
    }

}
