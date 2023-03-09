package com.example.healthyheart.ui.rewards;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.healthyheart.R;
import com.example.healthyheart.Sos;
import com.example.healthyheart.databinding.FragmentRewardsBinding;
import com.example.healthyheart.ui.rewards.RewardsViewModel;

public class RewardsFragment extends Fragment{

    private FragmentRewardsBinding binding;
    private Button sos;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RewardsViewModel rewardsViewModel =
                new ViewModelProvider(this).get(RewardsViewModel.class);

        binding = FragmentRewardsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        sos = (Button) root.findViewById(R.id.sos_reward_btn);
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.SEND_SMS, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 0);
        }
        sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send_sms();
            }
        });
        //final TextView textView = binding.textRewards;
        //rewardsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
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
}
