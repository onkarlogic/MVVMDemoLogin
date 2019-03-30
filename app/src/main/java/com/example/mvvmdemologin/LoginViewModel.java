package com.example.mvvmdemologin;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;


import com.example.mvvmdemologin.Model.LoginUser;

public class LoginViewModel extends ViewModel {

    LoginMainActivity loginMainActivity;

    public MutableLiveData<String> EmailAddress = new MutableLiveData<>();
    public MutableLiveData<String> Password = new MutableLiveData<>();

    private MutableLiveData<LoginUser> userMutableLiveData;

    public LoginViewModel(LoginMainActivity loginMainActivity) {
        this.loginMainActivity=loginMainActivity;
    }

    /* public LoginViewModel(LoginMainActivity context) {
        this. context=context;
     }
 */
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

     Intent i = new Intent(loginMainActivity, UserDisplayActivity.class);
        loginMainActivity.startActivity(i);

    }
}
