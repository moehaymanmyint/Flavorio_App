package com.example.flavorioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class IndividualRecipe extends AppCompatActivity {

    ImageView imageView;
    // Initialize RecipeDatabaseHelper
    RecipeDatabaseHelper recipeDatabaseHelper = new RecipeDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_recipe);

        imageView = findViewById(R.id.recipe_image);

        String type = getIntent().getStringExtra("type");

        if (type != null) {
            if (type.equalsIgnoreCase("beef1")) {
                // Set image resource for breakfast
                imageView.setImageResource(R.drawable.berrycake);
            } else if (type.equalsIgnoreCase("beef2")) {
                // Set image resource for lunch
                imageView.setImageResource(R.drawable.chocolate);
            } else if (type.equalsIgnoreCase("beef3")) {
                // Set image resource for dinner
                imageView.setImageResource(R.drawable.snack1);
            } else if (type.equalsIgnoreCase("beef4")) {
                // Set image resource for snacks
                imageView.setImageResource(R.drawable.snack2);
            } else if (type.equalsIgnoreCase("beef5")) {
                // Set image resource for coffee
                imageView.setImageResource(R.drawable.snack3);
            }
        }

        if (type != null && type.equalsIgnoreCase("chicken1")){
            // Retrieve recipe details
            int image = R.drawable.snack1; // Example image resource
            String name = "Chicken Curry";
            String description = "Yummy";
            String time = "20mnt";
            String recipeType = "Medium";
            String ingredients = "List of Ingredients";
            String instructions = "Recipe Instructions";

            // Create a new IndividualRecipeModel object
            IndividualRecipeModel recipe = new IndividualRecipeModel(0, R.drawable.snack1, "Chicken Curry", "Yummy", "20mnt", "Medium", "List of Ingredients", "Recipe Instructions");

            // Insert the recipe into the database and get the ID of the inserted row
            long recipeId = recipeDatabaseHelper.addRecipe(recipe);

            Toast.makeText(IndividualRecipe.this, "Recipe added with ID: " + recipeId, Toast.LENGTH_SHORT).show();

        }


        if (type != null && type.equalsIgnoreCase("chicken2")){
            // Update an existing recipe
            IndividualRecipeModel recipeToUpdate = new IndividualRecipeModel(0, R.drawable.chicken, "Chicken Curry", "newDescription", "15mnt", "Easy", "newIngredients", "newInstructions");
            boolean isUpdated = recipeDatabaseHelper.updateRecipe(recipeToUpdate);

            if (isUpdated) {
                // Update successful, perform any necessary actions
                Toast.makeText(IndividualRecipe.this, "Recipe updated successfully", Toast.LENGTH_SHORT).show();
            } else {
                // Update failed, handle accordingly
                Toast.makeText(IndividualRecipe.this, "Failed to update recipe", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
