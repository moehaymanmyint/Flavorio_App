package com.example.flavorioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRecipeItem extends AppCompatActivity {

    // Declaration of Variables
    private EditText name;
    private EditText description;
    private EditText time;
    private EditText type;
    private EditText ingredients;
    private EditText instructions;
    private Button btnAdd;
    private RecipeDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe_item);

        dbHelper = new RecipeDatabaseHelper(this);

        name = findViewById(R.id.et_recipename);
        description = findViewById(R.id.et_recipedes);
        time = findViewById(R.id.et_recipetime);
        type = findViewById(R.id.et_recipetype);
        ingredients = findViewById(R.id.et_ingredients);
        instructions = findViewById(R.id.et_instructions);
        btnAdd = findViewById(R.id.btn_Add);

        // Adding event to Add Recipe Button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRecipeItem();
            }
        });
    }

    // Add Recipe Item method
    private void addRecipeItem() {
        String nameText = name.getText().toString().trim();
        String descriptionText = description.getText().toString().trim();
        String timeText = time.getText().toString().trim();
        String typeText = type.getText().toString().trim();
        String ingredientsText = ingredients.getText().toString().trim();
        String instructionsText = instructions.getText().toString().trim();

        // Check if any field is empty
        if (nameText.isEmpty() || descriptionText.isEmpty() || timeText.isEmpty() ||
                typeText.isEmpty() || ingredientsText.isEmpty() || instructionsText.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create an IndividualRecipeModel object
        IndividualRecipeModel recipeItem = new IndividualRecipeModel(
                0,
                0,
                nameText,
                descriptionText,
                timeText,
                typeText,
                ingredientsText,
                instructionsText
        );

        // Add the recipe to the database
        long id = dbHelper.addRecipe(recipeItem);

        if (id != -1) {
            Toast.makeText(this, "Recipe added successfully", Toast.LENGTH_SHORT).show();
            name.setText("");
            description.setText("");
            time.setText("");
            type.setText("");
            ingredients.setText("");
            instructions.setText("");
        } else {
            Toast.makeText(this, "Failed to add recipe", Toast.LENGTH_SHORT).show();
        }
    }
}
