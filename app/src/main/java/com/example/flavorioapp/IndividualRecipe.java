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
                imageView.setImageResource(R.drawable.beef1);
                nameTextView.setText("Mexican Beef Skewer");
                descriptionTextView.setText("Mexican Food");

            } else if (type.equalsIgnoreCase("beef2")) {
                imageView.setImageResource(R.drawable.beef2);
            } else if (type.equalsIgnoreCase("beef3")) {
                imageView.setImageResource(R.drawable.beef3);
            } else if (type.equalsIgnoreCase("beef4")) {
                imageView.setImageResource(R.drawable.beef4);
            } else if (type.equalsIgnoreCase("beef5")) {
                imageView.setImageResource(R.drawable.beef5);
            } else if (type.equalsIgnoreCase("chicken1")) {
                imageView.setImageResource(R.drawable.chicken1);
            }
        }
    }
}
