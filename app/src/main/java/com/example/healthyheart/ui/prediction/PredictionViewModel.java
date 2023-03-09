package com.example.healthyheart.ui.prediction;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PredictionViewModel extends ViewModel{

    private final MutableLiveData<String> mText;

    public PredictionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is prediciton fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
