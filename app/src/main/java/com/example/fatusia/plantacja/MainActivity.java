package com.example.fatusia.plantacja;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import static com.example.fatusia.plantacja.Types.CACTUS;
import static com.example.fatusia.plantacja.Types.SHROOM;
import static com.example.fatusia.plantacja.Types.WEED;
import static com.example.fatusia.plantacja.User.file;
import static com.example.fatusia.plantacja.User.start;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton add = findViewById(R.id.floatingActionButton);
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(getApplicationContext(), AddPlant.class);
                startActivity(newIntent);
            }
        });

        if(start){
            User.file = new File(getApplicationContext().getFilesDir(), "/data.dat");
            //file.delete();
        }



        Toast.makeText(getApplicationContext(), Long.toString(User.file.length()),
                Toast.LENGTH_SHORT).show();

        if(User.greenhouses.isEmpty()){
            try {
                User.load(getApplicationContext());

            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }


        if(!User.greenhouses.isEmpty()){
            TextView text = findViewById(R.id.textEmpty);
            text.setText("");
            RecyclerView rvPlants = (RecyclerView) findViewById(R.id.rvPlants);

            PlantAdapter adapter = new PlantAdapter();
            rvPlants.setAdapter(adapter);
            rvPlants.setLayoutManager(new LinearLayoutManager(this));

        }

    }

}
