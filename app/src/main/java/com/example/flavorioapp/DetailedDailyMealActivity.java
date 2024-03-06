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
        // Initialize DetailedDailyAdapter with context
        detailedDailyAdapter = new DetailedDailyAdapter(detailedDailyModelList, this);
        recyclerView.setAdapter(detailedDailyAdapter);

        if (type != null && type.equalsIgnoreCase("breakfast")){

            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.chocolate, "Breakfast", "Description", "1.2K","Beef1"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.berrycake, "Breakfast", "Description", "1.2K","Beef2"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.crcf, "Breakfast", "Description", "1.2K","Beef3"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K","Beef4"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K","Beef5"));
            detailedDailyAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("lunch")){

            imageView.setImageResource(R.drawable.snack3);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack1, "Breakfast", "Description", "1.2K","Chicken1"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K","Chicken2"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K","Chicken3"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K","Chicken4"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K","Chicken5"));
            detailedDailyAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("dinner")){

            imageView.setImageResource(R.drawable.snack3);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack1, "Breakfast", "Description", "1.2K","Fish1"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K","Fish2"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K","Fish3"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K","Fish4"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K","Fish5"));
            detailedDailyAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("snacks")){

            imageView.setImageResource(R.drawable.snack3);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack1, "Breakfast", "Description", "1.2K","Shrimp1"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K","Shrimp2"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K","Shrimp3"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K","Shrimp4"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K","Shrimp5"));
            detailedDailyAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("coffee")){

            imageView.setImageResource(R.drawable.snack3);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack1, "Breakfast", "Description", "1.2K","Duck1"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K","Duck2"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K","Duck3"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K","Duck4"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K","Duck5"));
            detailedDailyAdapter.notifyDataSetChanged();

        }
    }
}