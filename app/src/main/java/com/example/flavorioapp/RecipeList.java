package com.example.flavorioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RecipeList extends AppCompatActivity {

    private CardView curryId1;
    private CardView curryId2;
    private CardView curryId3;
    private CardView cakeId1;
    private CardView snackId1;
    private CardView drinkId1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_list);

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
            } else if (item.getItemId() == R.id.bottom_search) {
                startActivity(new Intent(getApplicationContext(), Search.class));
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

        curryId1 = findViewById(R.id.curryId1);
        curryId1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipeInfo1();
            }
        });

        curryId2 = findViewById(R.id.curryId2);
        curryId2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipeInfo2();
            }
        });

        curryId3 = findViewById(R.id.curryId3);
        curryId3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipeInfo3();
            }
        });

        cakeId1 = findViewById(R.id.cakeId1);
        cakeId1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCakeRecipe1();
            }
        });

        snackId1 = findViewById(R.id.snackId1);
        snackId1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSnackRecipe1();
            }
        });

        drinkId1 = findViewById(R.id.drinkId1);
        drinkId1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrinkRecipe1();
            }
        });
    }

    public void openRecipeInfo1() {
        Intent intent = new Intent (this, RecipeInfo_1.class);
        startActivity(new Intent(RecipeList.this, RecipeInfo_1.class));
    }

    public void openRecipeInfo2() {
        Intent intent = new Intent (this, RecipeInfo_2.class);
        startActivity(new Intent(RecipeList.this, RecipeInfo_2.class));
    }

    public void openRecipeInfo3() {
        Intent intent = new Intent (this, RecipeInfo_3.class);
        startActivity(new Intent(RecipeList.this, RecipeInfo_3.class));
    }

    public void openCakeRecipe1() {
        Intent intent = new Intent (this, CakeRecipe_1.class);
        startActivity(new Intent(RecipeList.this, CakeRecipe_1.class));
    }

    public void openSnackRecipe1() {
        Intent intent = new Intent (this, SnackRecipe_1.class);
        startActivity(new Intent(RecipeList.this, SnackRecipe_1.class));
    }

    public void openDrinkRecipe1() {
        Intent intent = new Intent (this, DrinkRecipe_1.class);
        startActivity(new Intent(RecipeList.this, DrinkRecipe_1.class));
    }
}