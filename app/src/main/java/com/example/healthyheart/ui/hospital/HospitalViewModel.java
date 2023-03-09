package com.example.healthyheart.ui.hospital;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HospitalViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public HospitalViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("List of all Nearby Hospital");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
