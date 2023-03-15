package com.example.healthyheart;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Music extends AppCompatActivity {

    private ImageView music_activity_1, music_activity_2, music_activity_3, music_activity_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);

        music_activity_1 = (ImageView) findViewById(R.id.imageView_music_act1);
        music_activity_2 = (ImageView) findViewById(R.id.imageView_music_act2);
        music_activity_3 = (ImageView) findViewById(R.id.imageView_music_act3);
        music_activity_4 = (ImageView) findViewById(R.id.imageView_music_act4);

        music_activity_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Video_player.class);
                Bundle b = new Bundle();
                b.putInt("key",5);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        music_activity_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Video_player.class);
                Bundle b = new Bundle();
                b.putInt("key",5);
                intent.putExtras(b);
                startActivity(intent);
            }
        });music_activity_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Video_player.class);
                Bundle b = new Bundle();
                b.putInt("key",6);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        music_activity_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Video_player.class);
                Bundle b = new Bundle();
                b.putInt("key",7);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        music_activity_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Video_player.class);
                Bundle b = new Bundle();
                b.putInt("key",8);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

    }
}