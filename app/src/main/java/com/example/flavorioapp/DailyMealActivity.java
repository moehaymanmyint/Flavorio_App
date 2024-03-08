package com.example.flavorioapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

public class DailyMealActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DailyMealModel> dailyMealModels;
    DailyMealAdapter dailyMealAdapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_meal_activity);

        recyclerView = findViewById(R.id.daily_meal_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dailyMealModels = new ArrayList<>();

        dailyMealModels.add(new DailyMealModel(R.drawable.beef1,"Beef","Tasty and Nutritious","beef"));
        dailyMealModels.add(new DailyMealModel(R.drawable.chicken1,"Chicken","Tasty and Nutritious","chicken"));
        dailyMealModels.add(new DailyMealModel(R.drawable.fish1,"Fish","Tasty and Nutritious","fish"));
        dailyMealModels.add(new DailyMealModel(R.drawable.shrimp1,"Shrimp","Tasty and Nutritious","shrimp"));
        dailyMealModels.add(new DailyMealModel(R.drawable.duck1,"Duck","Tasty and Nutritious", "duck"));
        dailyMealModels.add(new DailyMealModel(R.drawable.cake1,"Dessert","Tasty and Nutritious", "dessert"));
        dailyMealModels.add(new DailyMealModel(R.drawable.juice1,"Drink","Tasty Treat","juice"));

        dailyMealAdapter = new DailyMealAdapter(this, dailyMealModels);
        recyclerView.setAdapter(dailyMealAdapter);
        dailyMealAdapter.notifyDataSetChanged();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_daily_meal);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home) {
                startActivity(new Intent(getApplicationContext(), RecipeList.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_daily_meal) {
                return true;
            } else if (item.getItemId() == R.id.bottom_favourite) {
                startActivity(new Intent(getApplicationContext(), Favourite.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_profile) {
                startActivity(new Intent(getApplicationContext(), Profile.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else
                return false;
        });

        //For Search
        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                dailyMealAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }
}