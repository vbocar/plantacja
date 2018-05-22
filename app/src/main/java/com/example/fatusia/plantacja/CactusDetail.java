package com.example.fatusia.plantacja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CactusDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cactus_detail);

        final TextView textView = (TextView) findViewById(R.id.textView);
        final TextView greenhouseView = (TextView) findViewById(R.id.greenhouseView);

        Intent i = getIntent();
        int id = (int)i.getSerializableExtra("index");
        final Greenhouse cactus = User.get().greenhouses.get(id);

        textView.setText(cactus.plant.print());
        greenhouseView.setText(cactus.print());

        Button b1, b2;

        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cactus.podlej();
                greenhouseView.setText(cactus.print());
                Toast.makeText(getApplicationContext(), "Podlano krzak!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cactus.zaswiec();
                greenhouseView.setText(cactus.print());
                Toast.makeText(getApplicationContext(), "Zwiększono światło przy krzaku!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}

