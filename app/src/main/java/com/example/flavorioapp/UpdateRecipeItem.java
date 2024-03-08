package com.example.flavorioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class UpdateRecipeItem extends AppCompatActivity {

    // Declaration of variables
    private EditText updateId;
    private ImageView update_image;
    private EditText update_name;
    private EditText update_des;
    private EditText update_time;
    private EditText update_type;
    private EditText update_ingredients;
    private EditText update_instructions;
    private Button btn_update;
    RecipeDatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_recipe_item);
        myDb = new RecipeDatabaseHelper(this);

        updateId = findViewById(R.id.updateId);
        update_image = findViewById(R.id.update_image);
        update_name = findViewById(R.id.update_name);
        update_des = findViewById(R.id.update_des);
        update_time = findViewById(R.id.update_time);
        update_type = findViewById(R.id.update_type);
        update_ingredients = findViewById(R.id.update_ingredients);
        update_instructions = findViewById(R.id.update_instructions);
        btn_update = findViewById(R.id.btn_update);

        UpdateRecipe();
    }

    public void UpdateRecipe() {
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = Long.parseLong(updateId.getText().toString());
                int image = R.drawable.snack1;
                String name = update_name.getText().toString();
                String description = update_des.getText().toString();
                String time = update_time.getText().toString();
                String type = update_type.getText().toString();
                String ingredients = update_ingredients.getText().toString();
                String instructions = update_instructions.getText().toString();

                IndividualRecipeModel updatedRecipe = new IndividualRecipeModel(id, image, name, description, time, type, ingredients, instructions);

                boolean isUpdate = myDb.updateRecipe(updatedRecipe);

                if (isUpdate) {
                    Toast.makeText(UpdateRecipeItem.this, "Recipe updated successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UpdateRecipeItem.this, "Failed to update recipe", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
