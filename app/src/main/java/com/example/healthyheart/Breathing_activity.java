package com.example.healthyheart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Breathing_activity extends AppCompatActivity {

    private ImageView breathing_act_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.breathing);

        breathing_act_1 = (ImageView) findViewById(R.id.imageView_breath_act1);
        breathing_act_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Video_player.class);
                startActivity(intent);
            }
        });
    }
}
