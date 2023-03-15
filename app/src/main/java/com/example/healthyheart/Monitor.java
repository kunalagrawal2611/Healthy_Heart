package com.example.healthyheart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Monitor extends AppCompatActivity {

    private ImageView heart_monitor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.monitor_activity);
        heart_monitor = (ImageView) findViewById(R.id.imageView_guage);
        heart_monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HeartRateMonitor.class);
                startActivity(intent);
            }
        });
    }
}
