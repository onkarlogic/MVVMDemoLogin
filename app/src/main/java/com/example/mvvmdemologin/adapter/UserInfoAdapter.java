package com.example.mvvmdemologin.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.mvvmdemologin.Model.DataModel;
import com.example.mvvmdemologin.R;
import com.example.mvvmdemologin.databinding.ItemDataBinding;
import com.example.mvvmdemologin.viewmodel.DataItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.DataViewHolder> {
    private static final String TAG = "DataAdapter";
    private List<DataModel> data;

    public UserInfoAdapter() {
        this.data = new ArrayList<>();
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data,
                new FrameLayout(parent.getContext()), false);
        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        DataModel dataModel = data.get(position);
        holder.setViewModel(new DataItemViewModel(dataModel));
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    @Override
    public void onViewAttachedToWindow(DataViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(DataViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    public void updateData(@Nullable List<DataModel> data) {
        if (data == null || data.isEmpty()) {
            this.data.clear();
        } else {
            this.data.addAll(data);
        }
        notifyDataSetChanged();
    }

     static class DataViewHolder extends RecyclerView.ViewHolder {
         ItemDataBinding binding;

        DataViewHolder(View itemView) {
            super(itemView);
            bind();
        }

         void bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind(itemView);
            }
        }

         void unbind() {
            if (binding != null) {
                binding.unbind();
            }
        }

       void setViewModel(DataItemViewModel viewModel) {
            if (binding != null) {
                binding.setViewModel(viewModel);
            }
        }
    }

}
