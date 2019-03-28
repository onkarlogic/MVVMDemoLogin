package com.example.mvvmdemologin.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.mvvmdemologin.Model.LoginUser;

public class LoginViewModel extends AndroidViewModel {

    public MutableLiveData<String> EmailAddress = new MutableLiveData<>();
    public MutableLiveData<String> Password = new MutableLiveData<>();

    private MutableLiveData<LoginUser> userMutableLiveData;

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<LoginUser> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }

    public void onClick(View view) {

        LoginUser loginUser = new LoginUser(EmailAddress.getValue(), Password.getValue());

        userMutableLiveData.setValue(loginUser);

    }
}
