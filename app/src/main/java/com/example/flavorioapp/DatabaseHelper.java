package com.example.flavorioapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Initialize variables
    private static final String DATABASE_NAME = "user.db";
    private static final String TABLE_NAME = "users";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "username";
    private static final String COL_3 = "password";
    private static final String COL_4 = "email";

    //For Favourite
    private static final String TABLE_FAVORITES = "Favorites";
    private static final String FAV_COL_1 = "image";
    private static final String FAV_COL_2 = "name";
    private static final String FAV_COL_3 = "description";
    private static final String FAV_COL_4 = "rating";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT, email TEXT)");

        //Favourite
        db.execSQL("CREATE TABLE " + TABLE_FAVORITES + " (fav_id INTEGER PRIMARY KEY, image TEXT, name TEXT, description TEXT, rating TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITES);
        onCreate(db);
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

    // For Favourite
    public boolean insertFavData(String image, String name, String description, String rating) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FAV_COL_1, image);
        contentValues.put(FAV_COL_2, name);
        contentValues.put(FAV_COL_3, description);
        contentValues.put(FAV_COL_4, rating);
        int randomId = new Random().nextInt(1000);
        contentValues.put("fav_id", randomId);
        long result = MyDatabase.insert(TABLE_FAVORITES, null, contentValues);
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

    //Fav
    public List<DetailedDailyModel> getAllFavoriteData() {
        List<DetailedDailyModel> favoritesList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_FAVORITES, null);

        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") int image = cursor.getInt(cursor.getColumnIndex(FAV_COL_1));
                    @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(FAV_COL_2));
                    @SuppressLint("Range") String description = cursor.getString(cursor.getColumnIndex(FAV_COL_3));
                    @SuppressLint("Range") String rating = cursor.getString(cursor.getColumnIndex(FAV_COL_4));

                    DetailedDailyModel model = new DetailedDailyModel(image, name, description, rating);
                    favoritesList.add(model);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
        return favoritesList;
    }
}