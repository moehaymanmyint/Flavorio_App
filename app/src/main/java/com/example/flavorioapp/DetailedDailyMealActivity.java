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
    DetailedDailyAdapter dailyAdapter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_daily_meal);

        String type = getIntent().getStringExtra("type");

        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_image);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailedDailyModelList = new ArrayList<>();
        dailyAdapter = new DetailedDailyAdapter(detailedDailyModelList);
        recyclerView.setAdapter(dailyAdapter);

        if (type != null && type.equalsIgnoreCase("breakfast")){

            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.chocolate, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.berrycake, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.crcf, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K"));
            dailyAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("lunch")){

            imageView.setImageResource(R.drawable.snack3);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack1, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K"));
            dailyAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("dinner")){

            imageView.setImageResource(R.drawable.snack3);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack1, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K"));
            dailyAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("snacks")){

            imageView.setImageResource(R.drawable.snack3);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack1, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K"));
            dailyAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("coffee")){

            imageView.setImageResource(R.drawable.snack3);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack1, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack3, "Breakfast", "Description", "1.2K"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.snack2, "Breakfast", "Description", "1.2K"));
            dailyAdapter.notifyDataSetChanged();

        }
    }
}