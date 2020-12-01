package com.example.zutawa_assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlantAdapter2 extends RecyclerView.Adapter<PlantViewHolder2>{
    ArrayList<Plant> plants;
    public PlantAdapter2() {
        plants = new ArrayList<>();
    }
    public void setData(ArrayList<Plant> plants){
        this.plants = plants;
    }
    @NonNull
    @Override
    public PlantViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View PlantView = inflater.inflate(R.layout.recyle_row2, parent, false);
        return new PlantViewHolder2(PlantView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantViewHolder2 holder, int position) {
        Plant plant = plants.get(position);
        Picasso.get().load(plant.getImg_src()).into(holder.image);
        holder.title.setText(plant.getTitle());
        holder.sub_title.setText(plant.getSubtitile());
    }

    @Override
    public int getItemCount() {
        return plants.size();
    }
}
