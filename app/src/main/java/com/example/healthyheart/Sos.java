package com.example.healthyheart;

import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthyheart.ui.home.HomeFragment;

public class Sos extends AppCompatActivity {
    DBManager myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        myDB = new DBManager(this);
        Cursor data = myDB.getListContents();
        //data.getCount();
        //System.out.println(data.getCount());
        if(data.getCount()!=0) {
            while (data.moveToNext()) {
                String no = data.getString(2);
                String msg = "SOS Test Message";
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(no, null, msg, pi, null);
                //System.out.println("Hello");
                Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                        Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "Please Add Someone in Friend List", Toast.LENGTH_SHORT).show();
            //PendingIntent.getActivity(getApplicationContext(), 0,intent, 0).cancel();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            //stopService(intent);
        }
    }

}
