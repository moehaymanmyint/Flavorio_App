package com.example.flavorioapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
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

        dailyMealModels.add(new DailyMealModel(R.drawable.chocolate,"Chocolate Cake","Description Description Description"));
        dailyMealModels.add(new DailyMealModel(R.drawable.shrimp,"Shrimp Recipe","Description Description Description"));
        dailyMealModels.add(new DailyMealModel(R.drawable.snack1,"Snacks","Description Description Description"));
        dailyMealModels.add(new DailyMealModel(R.drawable.snack2,"Snacks","Description Description Description"));
        dailyMealModels.add(new DailyMealModel(R.drawable.snack3,"Snacks","Description Description Description"));
        dailyMealModels.add(new DailyMealModel(R.drawable.drink1,"Drink","Description Description Description"));
        dailyMealModels.add(new DailyMealModel(R.drawable.drink2,"Drink","Description Description Description"));

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
