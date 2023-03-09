package com.example.healthyheart.ui.about;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AboutViewModel extends ViewModel{

    private final MutableLiveData<String> mText;

    public AboutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("About Us \n\n Disclaimer: This application doesn't provide 100% accurate results. Our system just provides a prediction based on publicly available data. ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
