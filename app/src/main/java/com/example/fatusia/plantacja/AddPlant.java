package com.example.fatusia.plantacja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.IOException;

public class AddPlant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant);

        final RadioButton weedBtn, shroomBtn, cactusBtn;

        weedBtn = (RadioButton) findViewById(R.id.weedBtn);
        shroomBtn = (RadioButton) findViewById(R.id.shroomBtn);
        cactusBtn = (RadioButton) findViewById(R.id.cactusBtn);

        final EditText textName = findViewById(R.id.textName);

        Button createBtn  = findViewById(R.id.createBtn);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Types type=Types.GENERIC;
                String name = textName.getText().toString();

                if(name.isEmpty()){
                    Toast.makeText(view.getContext(), "Nazwij swoją roślinę!", Toast.LENGTH_SHORT).show();
                }

                if(weedBtn.isChecked()){
                    type = Types.WEED;
                }
                else if(shroomBtn.isChecked()){
                    type = Types.SHROOM;
                }
                else if(cactusBtn.isChecked()){
                    type = Types.CACTUS;
                }
                User.newPlant(type, name);

                Toast.makeText(view.getContext(), type.toString(), Toast.LENGTH_SHORT).show();

                try {
                    User.save(getApplicationContext());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
