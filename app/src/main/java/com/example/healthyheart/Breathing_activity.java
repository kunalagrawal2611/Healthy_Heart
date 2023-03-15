package com.example.healthyheart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Breathing_activity extends AppCompatActivity {

    private ImageView breathing_act_1, breathing_act_2, breathing_act_3, breathing_act_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.breathing);

        breathing_act_1 = (ImageView) findViewById(R.id.imageView_breath_act1);
        breathing_act_2 = (ImageView) findViewById(R.id.imageView_breath_act2);
        breathing_act_3 = (ImageView) findViewById(R.id.imageView_breath_act3);
        breathing_act_4 = (ImageView) findViewById(R.id.imageView_breath_act4);
        //Video_player video_number = new Video_player();
        //video_number.play_video(1);
        breathing_act_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Video_player.class);
                Bundle b = new Bundle();
                b.putInt("key",1);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        breathing_act_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Video_player.class);
                Bundle b = new Bundle();
                b.putInt("key",2);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        breathing_act_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Video_player.class);
                Bundle b = new Bundle();
                b.putInt("key",3);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        breathing_act_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Video_player.class);
                Bundle b = new Bundle();
                b.putInt("key",4);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}
