package com.example.flavorioapp;

import android.widget.ImageView;

public class IndividualRecipeModel {

    private long id; // Add a field to hold the ID
    int image;
    String name;
    String description;
    String time;
    String recipe_type;
    String ingredients;
    String instructions;

    public IndividualRecipeModel(long id, int image, String name, String description, String time, String recipe_type, String ingredients, String instructions) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.description = description;
        this.time = time;
        this.recipe_type = recipe_type;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRecipe_type() {
        return recipe_type;
    }

    public void setRecipe_type(String recipe_type) {
        this.recipe_type = recipe_type;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
