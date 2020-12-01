package com.example.zutawa_assignment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlantViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView title;
    public PlantViewHolder(@NonNull View itemview) {
        super(itemview);
        image = itemView.findViewById(R.id.img);
        title = itemView.findViewById(R.id.title);
    }
}
