package com.example.healthyheart.ui.home;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.healthyheart.Breathing_activity;
import com.example.healthyheart.Friend_List;
import com.example.healthyheart.HeartRateMonitor;
import com.example.healthyheart.HeartbeatView;
import com.example.healthyheart.MapsActivity;
import com.example.healthyheart.Monitor;
import com.example.healthyheart.Music;
import com.example.healthyheart.Prediction_activity;
import com.example.healthyheart.R;
import com.example.healthyheart.Sos;
import com.example.healthyheart.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment{

    private Button emerg_btn, sos, map_btn, heart_check, prediction;
    private ImageView img_breath,img_music, heart_monitor;
private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
       // emerg_btn = (Button)findViewById(R.id.emergency_btn);
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

    binding = FragmentHomeBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
    map_btn = (Button) root.findViewById(R.id.button_map);
    emerg_btn = (Button) root.findViewById(R.id.emergency_btn);
    sos = (Button) root.findViewById(R.id.sos_btn);
    img_breath = (ImageView) root.findViewById(R.id.imageView_breath);
    img_music = (ImageView) root.findViewById(R.id.imageView_music);
    heart_monitor = (ImageView) root.findViewById(R.id.imageView_monitor);
    //prediction = (Button) root.findViewById(R.id.prediction);
    //heart_check = (Button) root.findViewById(R.id.button2);
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.SEND_SMS, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.CAMERA}, 0);
        }
//        heart_check.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), HeartRateMonitor.class);
//                startActivity(intent);
//            }
//        });
        map_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
            }
        });
        emerg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //System.out.println("Hello There");
                updateDetail();
            }
        });

        sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send_sms();
            }
        });
        img_breath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Breathing_activity.class);
                startActivity(intent);
            }
        });
        img_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Music.class);
                startActivity(intent);
            }
        });
        heart_monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Functionality yet to be added
                Intent intent = new Intent(getActivity(), HeartRateMonitor.class);
                startActivity(intent);
            }
        });

//        prediction.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), Prediction_activity.class);
//                startActivity(intent);
//            }
//        });
        //final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
    public void updateDetail() {

        Intent intent = new Intent(getActivity(), Friend_List.class);
        startActivity(intent);
        //System.out.println("Inside fucntion");
    }
    public void displatToast(String message){
        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
    }
    public void showActivity(View view){
        displatToast(getString(R.string.btn_update));
    }
    public void send_sms() {
        Intent intent = new Intent(getActivity(), Sos.class);
        startActivity(intent);
    }
@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

//    public void showActivity(View view) {
//        displatToast(getString(R.string.btn_update));
//    }
}
