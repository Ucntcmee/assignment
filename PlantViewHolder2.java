package com.example.zutawa_assignment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlantViewHolder2 extends RecyclerView.ViewHolder {
    ImageView image;
    TextView title;
    TextView sub_title;
    public PlantViewHolder2(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.img2);
        title = itemView.findViewById(R.id.title2);
        sub_title = itemView.findViewById(R.id.subTitle);
    }
}
