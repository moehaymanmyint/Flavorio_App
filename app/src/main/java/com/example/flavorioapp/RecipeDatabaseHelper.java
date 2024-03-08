package com.example.flavorioapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class RecipeDatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "Recipes";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_TIME = "time";
    public static final String COLUMN_RECIPE_TYPE = "recipe_type";
    public static final String COLUMN_INGREDIENTS = "ingredients";
    public static final String COLUMN_INSTRUCTIONS = "instructions";

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "RecipeDB.db";

    public RecipeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_IMAGE + " INTEGER,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_DESCRIPTION + " TEXT,"
                + COLUMN_TIME + " TEXT,"
                + COLUMN_RECIPE_TYPE + " TEXT,"
                + COLUMN_INGREDIENTS + " TEXT,"
                + COLUMN_INSTRUCTIONS + " TEXT"
                + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long addRecipe(IndividualRecipeModel recipe) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_IMAGE, recipe.getImage());
        values.put(COLUMN_NAME, recipe.getName());
        values.put(COLUMN_DESCRIPTION, recipe.getDescription());
        values.put(COLUMN_TIME, recipe.getTime());
        values.put(COLUMN_RECIPE_TYPE, recipe.getRecipe_type());
        values.put(COLUMN_INGREDIENTS, recipe.getIngredients());
        values.put(COLUMN_INSTRUCTIONS, recipe.getInstructions());
        long id = db.insert(TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public List<IndividualRecipeModel> getAllRecipes() {
        List<IndividualRecipeModel> recipeList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                IndividualRecipeModel recipe = new IndividualRecipeModel(
                        cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_IMAGE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPTION)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TIME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_RECIPE_TYPE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_INGREDIENTS)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_INSTRUCTIONS))
                );
                recipeList.add(recipe);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return recipeList;
    }

    public boolean updateRecipe(IndividualRecipeModel recipe) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_IMAGE, recipe.getImage());
        values.put(COLUMN_NAME, recipe.getName());
        values.put(COLUMN_DESCRIPTION, recipe.getDescription());
        values.put(COLUMN_TIME, recipe.getTime());
        values.put(COLUMN_RECIPE_TYPE, recipe.getRecipe_type());
        values.put(COLUMN_INGREDIENTS, recipe.getIngredients());
        values.put(COLUMN_INSTRUCTIONS, recipe.getInstructions());

        int rowsAffected = db.update(TABLE_NAME, values, COLUMN_ID + " = ?",
                new String[]{String.valueOf(recipe.getId())});
        db.close();

        return rowsAffected > 0;
    }

    public Integer deleteRecipe(long recipeId) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COLUMN_ID + " = ?",
                new String[]{String.valueOf(recipeId)});
    }
}
