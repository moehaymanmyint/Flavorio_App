package com.example.flavorioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RecipeList extends AppCompatActivity {

    private CardView curryId1;
    private CardView curryId2;
    private CardView curryId3;
    private CardView cakeId1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_list);

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
}