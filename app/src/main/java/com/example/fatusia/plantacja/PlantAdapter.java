package com.example.fatusia.plantacja;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import static com.example.fatusia.plantacja.User.greenhouses;

public class PlantAdapter extends
        RecyclerView.Adapter<PlantAdapter.ViewHolder> {


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView plantTextView;
        public Button plantDetailButton;


        public ViewHolder(View itemView) {
            super(itemView);

            plantTextView = (TextView) itemView.findViewById(R.id.plant_name);
            plantDetailButton = (Button) itemView.findViewById(R.id.plant_detail_button);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View plantView = inflater.inflate(R.layout.item_plant, parent, false);

        ViewHolder viewHolder = new ViewHolder(plantView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {

        final Greenhouse greenhouse = greenhouses.get(position);

        TextView textView = viewHolder.plantTextView;
        textView.setText(greenhouse.plant.getName());
        Button button = viewHolder.plantDetailButton;
        button.setText("Pokaz");

        viewHolder.plantDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               greenhouse.czasMija();

                switch(greenhouse.plant.getType()){
                    case WEED:
                        Intent weedIntent = new Intent(v.getContext(), WeedDetail.class);
                        weedIntent.putExtra("index", greenhouse.getId());
                        v.getContext().startActivity(weedIntent);
                        break;
                    case SHROOM:
                        Intent shroomIntent = new Intent(v.getContext(), ShroomDetail.class);
                        shroomIntent.putExtra("index", greenhouse.getId());
                        v.getContext().startActivity(shroomIntent);
                        break;
                    case CACTUS:
                        Intent cactusIntent = new Intent(v.getContext(), CactusDetail.class);
                        cactusIntent.putExtra("index", greenhouse.getId());
                        v.getContext().startActivity(cactusIntent);
                        break;
                    case GENERIC:
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return greenhouses.size();
    }

}