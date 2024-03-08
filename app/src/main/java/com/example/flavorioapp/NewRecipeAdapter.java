package com.example.flavorioapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewRecipeAdapter extends RecyclerView.Adapter<NewRecipeAdapter.RecipeViewHolder> {

    private List<IndividualRecipeModel> recipeList;
    private OnRecipeItemClickListener listener;

    public interface OnRecipeItemClickListener {
        void onRecipeItemClick(int itemId);
    }

    // Constructor
    public NewRecipeAdapter(List<IndividualRecipeModel> recipeList, OnRecipeItemClickListener listener) {
        this.recipeList = recipeList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detailed_daily_meal_item, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, @SuppressLint("RecyclerView") int position) {
        IndividualRecipeModel recipe = recipeList.get(position);
        holder.bind(recipe);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onRecipeItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder {

        private TextView recipeNameTextView;
        private TextView recipeDescriptionTextView;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeNameTextView = itemView.findViewById(R.id.detailed_name);
            recipeDescriptionTextView = itemView.findViewById(R.id.detailed_des);
        }

        public void bind(IndividualRecipeModel recipe) {
            recipeNameTextView.setText(recipe.getName());
            recipeDescriptionTextView.setText(recipe.getDescription());
        }
    }
}