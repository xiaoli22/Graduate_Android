package com.example.graduate_android.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.graduate_android.R;
import com.example.graduate_android.bean.AddNormal;
import com.example.graduate_android.bean.Budget;
import com.example.graduate_android.databinding.CustomAddNormalBinding;
import com.example.graduate_android.fragmentadd.OutcomeFragment;

import java.util.ArrayList;
import java.util.List;

public class AddAdapter extends ArrayAdapter<AddNormal> {


    private final Context context;
    private final ArrayList<AddNormal> list;

    public AddAdapter(Context context, List<AddNormal> List) {
        super(context, 0, List);
        this.context = context;
        this.list = (ArrayList<AddNormal>) List;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.custom_add_normal, parent, false);
        }
        CustomAddNormalBinding binding = CustomAddNormalBinding.bind(view);
        binding.imageAN.setImageResource(list.get(position).getImage());
        binding.typeAN.setText(list.get(position).getType());
        binding.dataAN.setText(list.get(position).getData());
        return view;
    }
}
