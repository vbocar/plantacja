package com.example.fatusia.plantacja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShroomDetail extends AppCompatActivity {

    Greenhouse shroom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shroom_detail);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final TextView greenhouseView = (TextView) findViewById(R.id.greenhouseView);

        Intent i = getIntent();
        int id = (int)i.getSerializableExtra("index");
        final Greenhouse shroom = User.get().greenhouses.get(id);

        textView.setText(shroom.plant.print());
        greenhouseView.setText(shroom.print());

        Button b1, b2;

        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                shroom.podlej();
                greenhouseView.setText(shroom.print());
                Toast.makeText(getApplicationContext(), "Podlano krzak!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                shroom.zaswiec();
                greenhouseView.setText(shroom.print());
                Toast.makeText(getApplicationContext(), "Zwiększono światło przy krzaku!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
