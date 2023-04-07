package com.example.graduate_android.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.graduate_android.R;
import com.example.graduate_android.bean.Account;
import com.example.graduate_android.bean.AddNormal;
import com.example.graduate_android.databinding.CustomAccountBookBinding;
import com.example.graduate_android.databinding.CustomAddNormalBinding;

import java.util.ArrayList;
import java.util.List;


public class MainAdapter extends ArrayAdapter<Account> {

    private final Context context;
    private final ArrayList<Account> list;

    public MainAdapter(Context context, ArrayList<Account> List) {
        super(context, R.layout.custom_account_book, List);
        this.context = context;
        this.list = List;
    }

    @Override
    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.custom_account_book, parent, false);
        }
        CustomAccountBookBinding binding = CustomAccountBookBinding.bind(view);
        binding.imageAB.setImageResource(list.get(position).getImage());
        binding.createrNumber.setText(list.get(position).getCreateNumber());
        binding.creater.setText(list.get(position).getCreate());
        binding.accountName.setText(list.get(position).getAname());

        return view;
    }


}
