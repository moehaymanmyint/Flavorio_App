package com.example.flavorioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class DetailedDailyMealActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DetailedDailyModel> detailedDailyModelList;
    DetailedDailyAdapter detailedDailyAdapter;
    ImageView imageView;

    // Initialize RecipeDatabaseHelper
    RecipeDatabaseHelper recipeDatabaseHelper = new RecipeDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_daily_meal);

        String type = getIntent().getStringExtra("type");

        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_image);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailedDailyModelList = new ArrayList<>();
        detailedDailyAdapter = new DetailedDailyAdapter(detailedDailyModelList, this);
        recyclerView.setAdapter(detailedDailyAdapter);

        if (type != null && type.equalsIgnoreCase("beef")){

            imageView.setImageResource(R.drawable.beef1);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.beef1, "Sesame Beef Skewer", "Description", "1.2K","Beef1"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.beef2, "Mexi-Mac Skillet", "Description", "1.5K","Beef2"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.beef3, "Chili Hash", "Description", "1.1K","Beef3"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.beef4, "Pressure Cooker Mexican\nBeef Soup", "Description", "1.6K","Beef4"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.beef5, "Family Favourite\nCheese Burger Pasta", "Description", "1.2K","Beef5"));
            detailedDailyAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("chicken")){

            imageView.setImageResource(R.drawable.chicken1);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.chicken1, "Buffalo Chicken Meatballs", "Description", "1.2K","Chicken1"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.chicken, "Orange Chicken", "Description", "1.2K","Chicken2"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.chicken1, "Air Fryer Chicken Permesan", "Description", "1.2K","Chicken3"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.chicken, "Chicken Curry", "Description", "1.2K","Chicken4"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.chicken1, "Roasted Chicken", "Description", "1.2K","Chicken5"));
            detailedDailyAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("fish")){

            imageView.setImageResource(R.drawable.fish1);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.fish1, "Fish and Chips", "Description", "1.2K","Fish1"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Fish and Chips", "Description", "1.2K","Fish2"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Fish and Chips", "Description", "1.2K","Fish3"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Fish and Chips", "Description", "1.2K","Fish4"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Fish and Chips", "Description", "1.2K","Fish5"));
            detailedDailyAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("shrimp")){

            imageView.setImageResource(R.drawable.shrimp1);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.shrimp1, "Shrimp Salad", "Description", "1.2K","Shrimp1"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Shrimp Salad", "Description", "1.2K","Shrimp2"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Shrimp Salad", "Description", "1.2K","Shrimp3"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Shrimp Salad", "Description", "1.2K","Shrimp4"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Shrimp Salad", "Description", "1.2K","Shrimp5"));
            detailedDailyAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("duck")){

            imageView.setImageResource(R.drawable.duck1);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.duck1, "Roasted Duck", "Description", "1.2K","Duck1"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Roasted Duck", "Description", "1.2K","Duck2"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Roasted Duck", "Description", "1.2K","Duck3"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Roasted Duck", "Description", "1.2K","Duck4"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Roasted Duck", "Description", "1.2K","Duck5"));
            detailedDailyAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("dessert")){

            imageView.setImageResource(R.drawable.cake1);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.cake1, "Red Velvet Cake", "Description", "1.2K","Dessert1"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K","Dessert2"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K","Dessert3"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K","Dessert4"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K","Dessert5"));
            detailedDailyAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("juice")){

            imageView.setImageResource(R.drawable.juice1);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.juice1, "Kiwi Juice", "Description", "1.2K","Juice1"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K","Juice2"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K","Juice3"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K","Juice4"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K","Juice5"));
            detailedDailyAdapter.notifyDataSetChanged();

        }
    }
}