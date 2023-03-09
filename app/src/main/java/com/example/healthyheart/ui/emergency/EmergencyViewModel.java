package com.example.healthyheart.ui.emergency;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EmergencyViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public EmergencyViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("This is emergency fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}