package com.example.flavorioapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DetailedDailyAdapter extends RecyclerView.Adapter<DetailedDailyAdapter.ViewHolder> {
    private List<DetailedDailyModel> detailedDailyModelList;
    private Context context;

    public DetailedDailyAdapter(List<DetailedDailyModel> list, Context context) {
        this.detailedDailyModelList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.detailed_daily_meal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final DetailedDailyModel model = detailedDailyModelList.get(position);

        // Set data to views in ViewHolder
        holder.imageView.setImageResource(model.getImage());
        holder.name.setText(model.getName());
        holder.description.setText(model.getDescription());
        holder.rating.setText(model.getRating());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context != null) {
                    try {
                        Intent intent = new Intent(context, IndividualRecipe.class);
                        intent.putExtra("type", model.getType());
                        context.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return detailedDailyModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, description, rating;
        Button addFavButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.detailed_img);
            name = itemView.findViewById(R.id.detailed_name);
            description = itemView.findViewById(R.id.detailed_des);
            rating = itemView.findViewById(R.id.detailed_rating);
            addFavButton = itemView.findViewById(R.id.addFav);

            addFavButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        DetailedDailyModel selectedModel = detailedDailyModelList.get(position);

                        DatabaseHelper databaseHelper = new DatabaseHelper(itemView.getContext());
                        boolean isInserted = databaseHelper.insertFavData(
                                String.valueOf(Integer.parseInt(String.valueOf(selectedModel.getImage()))),
                                selectedModel.getName(),
                                selectedModel.getDescription(),
                                selectedModel.getRating()
                        );

                        if (isInserted) {
                            Toast.makeText(itemView.getContext(), "Added to Favorites", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(itemView.getContext(), "Failed to add to Favorites", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }
    }
}
