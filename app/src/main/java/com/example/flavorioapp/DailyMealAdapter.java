package com.example.flavorioapp;

import android.content.ClipData;
import android.content.Context;
import android.media.RouteListingPreference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DailyMealAdapter extends RecyclerView.Adapter<DailyMealAdapter.ViewHolder>{

    Context context;
    private List<DailyMealModel> dailyMealModels;
    private List<DailyMealModel> filteredDailyMealModels;

    public DailyMealAdapter(Context context, List<DailyMealModel> list) {
        this.context = context;
        this.dailyMealModels = new ArrayList<>(list);
        this.filteredDailyMealModels = new ArrayList<>(list);
    }

    //For Search
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString().toLowerCase().trim();
                List<DailyMealModel> filteredList = new ArrayList<>();
                if (charString.isEmpty()) {
                    filteredList.addAll(dailyMealModels);
                } else {
                    for (DailyMealModel item : dailyMealModels) {
                        if (item.getName().toLowerCase().contains(charString)) {
                            filteredList.add(item);
                        }
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredDailyMealModels.clear();
                filteredDailyMealModels.addAll((List<DailyMealModel>) filterResults.values);
                notifyDataSetChanged();
            }
        };
    }
    //For Search
    public void filterList(String text) {
        filteredDailyMealModels = new ArrayList<>(); // Add this line
        for (DailyMealModel item : dailyMealModels) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredDailyMealModels.add(item);
            }
        }
        if (filteredDailyMealModels.isEmpty()) {
            Toast.makeText(context, "No Data Found", Toast.LENGTH_SHORT).show();
        } else {
            dailyMealModels = filteredDailyMealModels;
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_meal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView.setImageResource(filteredDailyMealModels.get(position).getImage());
        holder.name.setText(filteredDailyMealModels.get(position).getName());
        holder.description.setText(filteredDailyMealModels.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return filteredDailyMealModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview);
            name = itemView.findViewById(R.id.textView37);
            description = itemView.findViewById(R.id.textView38);
        }
    }
}