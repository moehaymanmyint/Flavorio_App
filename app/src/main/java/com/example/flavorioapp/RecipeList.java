package com.example.flavorioapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class RecipeList extends AppCompatActivity implements NewRecipeAdapter.OnRecipeItemClickListener {

    //Declaration of variables
    private RecyclerView recyclerView;
    private List<IndividualRecipeModel> recipeList = new ArrayList<>();
    private NewRecipeAdapter newRecipeAdapter;
    private RecipeDatabaseHelper dbHelper;
    private CardView curryId1, curryId2, curryId3, cakeId1, cakeId2, cakeId3,
    snackId1, snackId2, snackId3, drinkId1, drinkId2, drinkId3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_list);

        dbHelper = new RecipeDatabaseHelper(this);

        recyclerView = findViewById(R.id.newrecipe_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newRecipeAdapter = new NewRecipeAdapter(recipeList, this); // Pass 'this' as the listener
        recyclerView.setAdapter(newRecipeAdapter);

        //Linking card view variables
        curryId1 = findViewById(R.id.curryId1);
        curryId2 = findViewById(R.id.curryId2);
        curryId3 = findViewById(R.id.curryId3);
        cakeId1 = findViewById(R.id.cakeId1);
        cakeId2 = findViewById(R.id.cakeId2);
        cakeId3 = findViewById(R.id.cakeId3);
        snackId1 = findViewById(R.id.snackId1);
        snackId2 = findViewById(R.id.snackId2);
        snackId3 = findViewById(R.id.snackId3);
        drinkId1 = findViewById(R.id.drinkId1);
        drinkId2 = findViewById(R.id.drinkId2);
        drinkId3 = findViewById(R.id.drinkId3);

        //Calling methods for onClick View
        openRecipeInfo1();
        openRecipeInfo2();
        openRecipeInfo3();
        openCakeRecipe1();
        openCakeRecipe2();
        openCakeRecipe3();
        openSnackRecipe1();
        openSnackRecipe2();
        openSnackRecipe3();
        openDrinkRecipe1();
        openDrinkRecipe2();
        openDrinkRecipe3();

        //Bottom Navigation
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

    // Implement onRecipeItemClick method from the interface
    @Override
    public void onRecipeItemClick(int itemId) {
        // Handle item click event here
        IndividualRecipeModel clickedRecipe = recipeList.get(itemId);
        // Start the details activity and pass necessary data
        Intent intent = new Intent(this, NewRecipeDetails.class);
        intent.putExtra("Name", clickedRecipe.getName());
        intent.putExtra("Description", clickedRecipe.getDescription());
        intent.putExtra("Time", clickedRecipe.getTime());
        intent.putExtra("Type", clickedRecipe.getRecipe_type());
        intent.putExtra("Ingredients", clickedRecipe.getIngredients());
        intent.putExtra("Instructions", clickedRecipe.getInstructions());
        startActivity(intent);
    }

    // Add onClick methods for card views to open recipe details
    public void openRecipeInfo1() {
        curryId1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipeList.this, RecipeInfo_1.class));
            }
        });
    }

    public void openRecipeInfo2() {
        curryId2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipeList.this, RecipeInfo_2.class));
            }
        });
    }

    public void openRecipeInfo3() {
        curryId3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipeList.this, RecipeInfo_3.class));
            }
        });
    }

    public void openCakeRecipe1() {
        cakeId1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipeList.this, CakeRecipe_1.class));
            }
        });
    }

    public void openCakeRecipe2() {
        cakeId2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipeList.this, CakeRecipe_2.class));
            }
        });
    }

    public void openCakeRecipe3() {
        cakeId3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipeList.this, CakeRecipe_3.class));
            }
        });
    }

    public void openSnackRecipe1() {
        snackId1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipeList.this, SnackRecipe_1.class));
            }
        });
    }

    public void openSnackRecipe2() {
        snackId2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipeList.this, SnackRecipe_2.class));
            }
        });
    }

    public void openSnackRecipe3() {
        snackId3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipeList.this, SnackRecipe_3.class));
            }
        });
    }

    public void openDrinkRecipe1() {
        drinkId1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipeList.this, DrinkRecipe_1.class));
            }
        });
    }

    public void openDrinkRecipe2() {
        drinkId2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipeList.this, DrinkRecipe_2.class));
            }
        });
    }

    public void openDrinkRecipe3() {
        drinkId3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipeList.this, DrinkRecipe_3.class));
            }
        });
    }
}
