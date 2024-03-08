package com.example.flavorioapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.flavorioapp.IndividualRecipeModel;
import com.example.flavorioapp.RecipeDatabaseHelper;

import java.util.List;

public class AdminDashboard extends AppCompatActivity {

    Button addBtn, viewBtn, updateBtn, deleteBtn, logoutBtn;
    RecipeDatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_dashboard);

        myDb = new RecipeDatabaseHelper(this); // Initialize RecipeDatabaseHelper

        addBtn = findViewById(R.id.addBtn);
        viewBtn = findViewById(R.id.viewBtn);
        updateBtn = findViewById(R.id.updateBtn);
        deleteBtn = findViewById(R.id.deleteBtn);
        logoutBtn = findViewById(R.id.logoutBtn);

        // Set OnClickListener for addBtn
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminDashboard.this, AddRecipeItem.class));
            }
        });

        // Set OnClickListener for updateBtn
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminDashboard.this, UpdateRecipeItem.class));
            }
        });

        //Set OnClickListener for deleteBtn
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminDashboard.this, DeleteRecipeItem.class));
            }
        });

        //Set OnClickListener for logoutBtn
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboard.this, SignIn.class);
                startActivity(intent);
            }
        });

        viewAll();
    }

    public void viewAll() {
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<IndividualRecipeModel> recipeList = myDb.getAllRecipes();
                if(recipeList.isEmpty()) {
                    showMessage("Error", "No recipes found.");
                    return;
                }

                // Create a StringBuffer to store the recipe details
                StringBuffer buffer = new StringBuffer();
                for (IndividualRecipeModel recipe : recipeList) {
                    buffer.append("id: ").append(recipe.getId()).append("\n");
                    buffer.append("name: ").append(recipe.getName()).append("\n");
                    buffer.append("description: ").append(recipe.getDescription()).append("\n");
                    buffer.append("time: ").append(recipe.getTime()).append("\n");
                    buffer.append("recipe_type: ").append(recipe.getRecipe_type()).append("\n");
                    buffer.append("ingredients: ").append(recipe.getIngredients()).append("\n");
                    buffer.append("instructions: ").append(recipe.getInstructions()).append("\n\n");
                }

                // Show all recipe data
                showMessage("Recipes", buffer.toString());
            }
        });
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
