package com.example.flavorioapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    //User Table
    private static final String DATABASE_NAME = "user.db";
    private static final String USER_TABLE_NAME = "users";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "username";
    private static final String COL_3 = "password";
    private static final String COL_4 = "email";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the user table
        db.execSQL("CREATE TABLE users (ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT, email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String username, String password, String email) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, username);
        contentValues.put(COL_3, password);
        contentValues.put(COL_4, email);
        long result = MyDatabase.insert(USER_TABLE_NAME, null, contentValues);

        return result != -1;
    }

    public Cursor getAllData() {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor res = MyDatabase.rawQuery("SELECT * FROM " + USER_TABLE_NAME, null);
        return res;
    }

    public boolean checkUsername(String username) {
        SQLiteDatabase MyDatabase = this.getReadableDatabase();
        Cursor cursor = MyDatabase.query(USER_TABLE_NAME, null, COL_2 + "=?", new String[]{username}, null, null, null);
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase MyDatabase = this.getReadableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?", new String[]{username, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
}

