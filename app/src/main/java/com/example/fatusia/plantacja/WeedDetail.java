package com.example.fatusia.plantacja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class WeedDetail extends AppCompatActivity {

    int id = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weed_detail);

        final TextView textView = (TextView) findViewById(R.id.textView);
        final TextView greenhouseView = (TextView) findViewById(R.id.greenhouseView);
        Button b1, b2;

        Intent i = getIntent();
        id = (int)i.getSerializableExtra("index");
        final Greenhouse weed = User.greenhouses.get(id-1
        );

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

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.appbar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_delete:
                User.greenhouses.remove(id-1);
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                try {
                    User.save(getApplicationContext());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finish();
                startActivity(i);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
