package com.example.healthyheart.ui.emergency;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.healthyheart.Friend_List;
import com.example.healthyheart.databinding.FragmentEmergencyBinding;
import com.example.healthyheart.ui.emergency.EmergencyViewModel;

public class EmergencyFragment extends Fragment {

private FragmentEmergencyBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        EmergencyViewModel emergencyViewModel =
                new ViewModelProvider(this).get(EmergencyViewModel.class);

    binding = FragmentEmergencyBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        Intent intent = new Intent(getActivity(), Friend_List.class);
        startActivity(intent);
        //final TextView textView = binding.id;
        //emergencyViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}