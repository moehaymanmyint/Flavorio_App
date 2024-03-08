package com.example.flavorioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NewRecipeDetails extends AppCompatActivity {

    //Declaration of variables
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
        setContentView(R.layout.new_recipe_details);

        nameTextView = findViewById(R.id.new_name);
        descriptionTextView = findViewById(R.id.new_des);
        timeTextView = findViewById(R.id.new_time);
        recipeTypeTextView = findViewById(R.id.new_type);
        ingredientsTextView = findViewById(R.id.new_ingredients);
        instructionsTextView = findViewById(R.id.new_instructions);
        imageView = findViewById(R.id.new_image);

        recipeDatabaseHelper = new RecipeDatabaseHelper(this);

        String Name = getIntent().getStringExtra("Name");
        String Description = getIntent().getStringExtra("Description");
        String Time = getIntent().getStringExtra("Time");
        String Type = getIntent().getStringExtra("Type");
        String Ingredients = getIntent().getStringExtra("Ingredients");
        String Instructions = getIntent().getStringExtra("Instructions");

        nameTextView.setText(Name);
        descriptionTextView.setText(Description);
        timeTextView.setText(Time);
        recipeTypeTextView.setText(Type);
        ingredientsTextView.setText(Ingredients);
        instructionsTextView.setText(Instructions);
    }
}