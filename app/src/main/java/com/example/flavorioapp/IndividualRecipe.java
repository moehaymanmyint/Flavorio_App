package com.example.flavorioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class IndividualRecipe extends AppCompatActivity {

    private TextView nameTextView;
    private TextView descriptionTextView;
    private ImageView imageView;
    private TextView timeTextView;
    private TextView recipeTypeTextView;
    private TextView ingredientsTextView;
    private TextView instructionsTextView;

    // Initialize RecipeDatabaseHelper
    RecipeDatabaseHelper recipeDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_recipe);

        nameTextView = findViewById(R.id.recipe_name);
        descriptionTextView = findViewById(R.id.recipe_des);
        timeTextView = findViewById(R.id.recipe_time);
        recipeTypeTextView = findViewById(R.id.recipe_type);
        ingredientsTextView = findViewById(R.id.ingredients);
        instructionsTextView = findViewById(R.id.instructions);

        imageView = findViewById(R.id.recipe_image);
        recipeDatabaseHelper = new RecipeDatabaseHelper(this);
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
            } else if (type.equalsIgnoreCase("chicken1")) {
                // Retrieve recipe details
                int image = R.drawable.snack2; // Example image resource
                String recipeName = "Chicken Curry";
                String recipeDescription = "Yummy";
                String recipeTime = "20mnt";
                String recipeType = "Medium";
                String recipeIngredients = getResources().getString(R.string.curry1_ingredients); // Retrieve string resource
                String recipeInstructions = "Recipe Instructions";

                // Create a new IndividualRecipeModel object
                IndividualRecipeModel recipe = new IndividualRecipeModel(1, image, recipeName, recipeDescription, recipeTime, recipeType, recipeIngredients, recipeInstructions);

                // Insert the recipe into the database and get the ID of the inserted row
                long recipeId = recipeDatabaseHelper.addRecipe(recipe);

                Toast.makeText(IndividualRecipe.this, "Recipe added with ID: " + recipeId, Toast.LENGTH_SHORT).show();

                // Retrieve the added recipe from the database and display it on the interface
                List<IndividualRecipeModel> recipeList = recipeDatabaseHelper.getAllRecipes();
                for (IndividualRecipeModel addedRecipe : recipeList) {
                    if (addedRecipe.getName().equals(recipeName) && addedRecipe.getDescription().equals(recipeDescription)) {
                        // This is the recipe you just added
                        // Use its details to populate your interface
                        imageView.setImageResource(addedRecipe.getImage());
                        nameTextView.setText(addedRecipe.getName());
                        descriptionTextView.setText(addedRecipe.getDescription());
                        timeTextView.setText(addedRecipe.getTime());
                        recipeTypeTextView.setText(addedRecipe.getRecipe_type());
                        ingredientsTextView.setText(addedRecipe.getIngredients());
                        instructionsTextView.setText(addedRecipe.getInstructions());
                        break; // Exit the loop once you find the recipe
                    }
                }
            }
        }
    }
}
