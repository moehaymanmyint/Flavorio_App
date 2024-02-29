package com.example.flavorioapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Initialize variables
    private static final String DATABASE_NAME = "user.db";
    private static final String TABLE_NAME = "users";
    private static final String TABLE1 = "recipe";
    private static final String TABLE2 = "description";
    private static final String TABLE3 = "time";
    private static final String TABLE4 = "type";

    private static final String COL_1 = "ID";
    private static final String COL_2 = "username";
    private static final String COL_3 = "password";
    private static final String COL_4 = "email";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT, email TEXT)");

        //Create Tables
        String table1 = "CREATE TABLE "+TABLE1+" (id INTEGER PRIMARY KEY,recipe_name TEXT) ";
        String table2 = "CREATE TABLE "+TABLE2+" (id INTEGER PRIMARY KEY,description TEXT) ";
        String table3 = "CREATE TABLE "+TABLE3+" (id INTEGER PRIMARY KEY,time TEXT) ";
        String table4 = "CREATE TABLE "+TABLE4+" (id INTEGER PRIMARY KEY,type TEXT) ";
        db.execSQL(table1);
        db.execSQL(table2);
        db.execSQL(table3);
        db.execSQL(table4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE2);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE3);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE4);
        onCreate(db);
    }

    //Create Insert Method
    public boolean insert (String recipe_name, String description, String time) {
        //Get WriteAble Database
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        //Create ContentValues
        ContentValues values1 = new ContentValues();
        values1.put("recipe_name",recipe_name);
        //Insert Data into Database
        sqLiteDatabase.insert(TABLE1,null,values1);

        //Create ContentValues
        ContentValues values2 = new ContentValues();
        values2.put("description",description);
        //Insert Data into Database
        sqLiteDatabase.insert(TABLE2,null,values2);

        //Create ContentValues
        ContentValues values3 = new ContentValues();
        values3.put("time",time);
        //Insert Data into Database
        sqLiteDatabase.insert(TABLE3,null,values3);

        return true;
    }

    //Create getRecipe Method
    public ArrayList getRecipe(){
        //Get Readable Database
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<>();
        //Perform RavQuery
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE1
                , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            arrayList.add(cursor.getString(cursor.getColumnIndexOrThrow("recipe_name")));
            cursor.moveToNext();
        }
        return arrayList;
    }

    //Create getDescription Method
    public ArrayList getDescription(){
        //Get Readable Database
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<>();
        //Perform RavQuery
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE2
                , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            arrayList.add(cursor.getString(cursor.getColumnIndexOrThrow("description")));
            cursor.moveToNext();
        }
        return arrayList;
    }

    //Create getTime Method
    public ArrayList getTime(){
        //Get Readable Database
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<>();
        //Perform RavQuery
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE3
                , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            arrayList.add(cursor.getString(cursor.getColumnIndexOrThrow("time")));
            cursor.moveToNext();
        }
        return arrayList;
    }

    //Create getType Method
    public ArrayList getType(){
        //Get Readable Database
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<>();
        //Perform RavQuery
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE4
                , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            arrayList.add(cursor.getString(cursor.getColumnIndexOrThrow("type")));
            cursor.moveToNext();
        }
        return arrayList;
    }


    public boolean insertData(String username, String password, String email) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, username);
        contentValues.put(COL_3, password);
        contentValues.put(COL_4, email);
        long result = MyDatabase.insert(TABLE_NAME, null, contentValues);

        return result != -1;
    }

    public Cursor getAllData() {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor res = MyDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }

    public boolean checkUsername(String username) {
        SQLiteDatabase MyDatabase = this.getReadableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM users WHERE username = ?", new String[]{username});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase MyDatabase = this.getReadableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?", new String[]{username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public String getUsernameById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COL_2};
        String selection = COL_1 + " = ?";
        String[] selectionArgs = {String.valueOf(id)};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            String username = cursor.getString(cursor.getColumnIndexOrThrow(COL_2));
            cursor.close();
            return username;
        } else {
            return null;
        }
    }

}