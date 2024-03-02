package com.example.flavorioapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class DailyMealFragment extends Fragment {

    RecyclerView recyclerView;
    List<DailyMealModel> dailyMealModels;
    DailyMealAdapter dailyMealAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.daily_meal_fragment, container, false);

        recyclerView = root.findViewById(R.id.daily_meal_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dailyMealModels = new ArrayList<>();

        dailyMealModels.add(new DailyMealModel(R.drawable.chocolate,"Chocolate Cake","Dessert","Description Description Description"));
        dailyMealModels.add(new DailyMealModel(R.drawable.shrimp,"Shrimp Recipe","Dessert","Description Description Description"));
        dailyMealModels.add(new DailyMealModel(R.drawable.snack1,"Snacks","Dessert","Description Description Description"));
        dailyMealModels.add(new DailyMealModel(R.drawable.snack2,"Snacks","Dessert","Description Description Description"));
        dailyMealModels.add(new DailyMealModel(R.drawable.snack3,"Snacks","Dessert","Description Description Description"));
        dailyMealModels.add(new DailyMealModel(R.drawable.drink1,"Drink","Dessert","Description Description Description"));
        dailyMealModels.add(new DailyMealModel(R.drawable.drink2,"Drink","Dessert","Description Description Description"));

        dailyMealAdapter = new DailyMealAdapter(getContext(), dailyMealModels);
        recyclerView.setAdapter(dailyMealAdapter);
        dailyMealAdapter.notifyDataSetChanged();
        return root;
    }
}