package com.example.flavorioapp;

import android.provider.BaseColumns;

public class RecipeContract {

    private RecipeContract() {

    }

    public static final class RecipeEntry implements BaseColumns {
        public static final String TABLE_NAME = "recipe";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_RECIPE_TYPE = "recipe_type";
        public static final String COLUMN_INGREDIENTS = "ingredients";
        public static final String COLUMN_INSTRUCTIONS = "instructions";
    }
}
