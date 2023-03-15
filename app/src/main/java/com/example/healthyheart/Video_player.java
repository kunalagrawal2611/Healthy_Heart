package com.example.healthyheart;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.healthyheart.R;

public class Video_player extends Activity {

    private VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_player);

        video = (VideoView) findViewById(R.id.videoView_activity);

        Bundle b = getIntent().getExtras();
        int val = -1;
        val = b.getInt("key");
        System.out.println("Value: "+val);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(video);
        Uri uri;
        if(val == 1){
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.five_minute_breathing_exercise);
        }
        else if(val == 2){
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.panic_attack);
        }
        else if(val == 3){
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.fifteen_minute_guided_meditation);
        }
        else if(val == 4){
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.guided_mindfulness);
        }
        else if(val == 5){
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ten_minute_calm_music_for_relaxing);
        }
        else if(val == 6){
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.tibetan_healing_relaxation_music);
        }
        else if(val == 7){
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.calm_background_music);
        }
        else if(val == 8){
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.twenty_calm_music);
        }
        else {
            //default video
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videoplayback);
        }
        //Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videoplayback);
        video.setMediaController(mediaController);
        video.setVideoURI(uri);
        video.requestFocus();
        video.start();

    }
}
