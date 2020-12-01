package com.example.zutawa_assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class PlantAdapter extends RecyclerView.Adapter<PlantViewHolder> {
    ArrayList<Plant> plants;
    public PlantAdapter() {
        plants = new ArrayList<>();
    }
    public void setData(ArrayList<Plant> plants){
        this.plants = plants;
    }
    @NonNull
    @Override
    public PlantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View PlantView = inflater.inflate(R.layout.recycle_row, parent, false);
        return new PlantViewHolder(PlantView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantViewHolder holder, int position) {
        Plant plant = plants.get(position);
        Picasso.get().load(plant.getImg_src()).into(holder.image);
        holder.title.setText(plant.getTitle());
    }

    @Override
    public int getItemCount() {
        return plants.size();
    }
}
