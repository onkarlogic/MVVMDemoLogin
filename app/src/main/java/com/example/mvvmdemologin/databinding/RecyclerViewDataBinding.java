package com.example.mvvmdemologin.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.example.mvvmdemologin.Model.DataModel;
import com.example.mvvmdemologin.adapter.UserInfoAdapter;

import java.util.List;

public class RecyclerViewDataBinding {

    @BindingAdapter({"app:adapter", "app:data"})
    public void bind(RecyclerView recyclerView, UserInfoAdapter adapter, List<DataModel> data) {
        recyclerView.setAdapter(adapter);
        adapter.updateData(data);
    }
}
