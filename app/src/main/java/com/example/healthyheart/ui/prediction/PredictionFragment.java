package com.example.healthyheart.ui.prediction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.healthyheart.databinding.FragmentHospitalBinding;
import com.example.healthyheart.databinding.FragmentPredictionBinding;
import com.example.healthyheart.ui.hospital.HospitalViewModel;
import com.example.healthyheart.ui.prediction.PredictionViewModel;

public class PredictionFragment extends Fragment{

    private FragmentPredictionBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PredictionViewModel predictionViewModel =
                new ViewModelProvider(this).get(PredictionViewModel.class);

        binding = FragmentPredictionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textPrediction;
        //predictionViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
