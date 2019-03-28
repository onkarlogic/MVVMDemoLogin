package com.example.mvvmdemologin;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;


import com.example.mvvmdemologin.Model.LoginUser;

public class LoginViewModel extends AndroidViewModel {

    Activity c;

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
        Log.e("show","clicked");
        userMutableLiveData.setValue(loginUser);

        Intent i = new Intent(c,DisplyDataItem.class);
        c.startActivity(i);

    }
}
