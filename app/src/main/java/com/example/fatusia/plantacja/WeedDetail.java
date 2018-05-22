package com.example.fatusia.plantacja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.fatusia.plantacja.User.*;

public class WeedDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weed_detail);

        final TextView textView = (TextView) findViewById(R.id.textView);
        final TextView greenhouseView = (TextView) findViewById(R.id.greenhouseView);
        Button b1, b2;

        Intent i = getIntent();
        int id = (int)i.getSerializableExtra("index");
        get();
        final Greenhouse weed = greenhouses.get(id);

        textView.setText(weed.plant.print());
        greenhouseView.setText(weed.print());

        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                weed.podlej();
                greenhouseView.setText(weed.print());
                Toast.makeText(getApplicationContext(), "Podlano krzak!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                weed.zaswiec();
                greenhouseView.setText(weed.print());
                Toast.makeText(getApplicationContext(), "Zwiększono światło przy krzaku!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
