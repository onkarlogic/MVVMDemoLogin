package com.example.mvvmdemologin;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.mvvmdemologin.Model.LoginUser;
import com.example.mvvmdemologin.LoginViewModel;
import com.example.mvvmdemologin.databinding.ActivityMainBinding;

import java.util.Objects;

public class LoginMainActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        loginViewModel = new LoginViewModel(getApplication());
        binding = DataBindingUtil.setContentView(LoginMainActivity.this, R.layout.activity_main);

        binding.setLifecycleOwner(this);
        binding.setLoginViewModel(loginViewModel);

        loginViewModel.getUser().observe(this, new Observer<LoginUser>() {
            @Override
            public void onChanged(@Nullable LoginUser loginUser) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrEmailAddress())) {
                        binding.txtEmailAddress.setError("Enter an E-Mail Address");
                        binding.txtEmailAddress.requestFocus();
                    } else if (!loginUser.isEmailValid()) {
                        binding.txtEmailAddress.setError("Enter a Valid E-mail Address");
                        binding.txtEmailAddress.requestFocus();
                    } else if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrPassword())) {
                        binding.txtPassword.setError("Enter a Password");
                        binding.txtPassword.requestFocus();
                    } else if (!loginUser.isPasswordLengthGreaterThan5()) {
                        binding.txtPassword.setError("Enter at least 6 Digit password");
                        binding.txtPassword.requestFocus();
                    } else {

                    }
                }

            }
        });

    }


}
