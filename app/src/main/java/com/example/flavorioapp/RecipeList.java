package com.example.flavorioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class RecipeList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<IndividualRecipeModel> recipeList = new ArrayList<>();
    private NewRecipeAdapter newRecipeAdapter;
    private RecipeDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_list);

        dbHelper = new RecipeDatabaseHelper(this);

        recyclerView = findViewById(R.id.newrecipe_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newRecipeAdapter = new NewRecipeAdapter(recipeList);
        recyclerView.setAdapter(newRecipeAdapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home) {
                return true;
            } else if (item.getItemId() == R.id.bottom_daily_meal) {
                startActivity(new Intent(getApplicationContext(), DailyMealActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_favourite) {
                startActivity(new Intent(getApplicationContext(), Favourite.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_profile) {
                startActivity(new Intent(getApplicationContext(), Profile.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else
                return false;
        });

        // Load recipes when the activity is created
        loadRecipes();
    }

    // Method to load recipes from the database
    private void loadRecipes() {
        recipeList.clear();
        recipeList.addAll(dbHelper.getAllRecipes());
        newRecipeAdapter.notifyDataSetChanged(); // Notify adapter about dataset change
    }

    // Add onClick methods for card views to open recipe details
    public void openRecipeInfo1(View view) {
        // Implement your logic here
    }

    public void openRecipeInfo2(View view) {
        // Implement your logic here
    }

    public void openRecipeInfo3(View view) {
        // Implement your logic here
    }

    public void openCakeRecipe1(View view) {
        // Implement your logic here
    }

    public void openSnackRecipe1(View view) {
        // Implement your logic here
    }

    public void openDrinkRecipe1(View view) {
        // Implement your logic here
    }
}
