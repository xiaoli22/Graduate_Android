package com.example.graduate_android.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.graduate_android.bean.DialogBase;
import com.example.graduate_android.databinding.DialogAccountItemBinding;

import java.util.ArrayList;
import java.util.List;

public class DialogBaseAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<DialogBase> alist;

    public DialogBaseAdapter(Context context, ArrayList<DialogBase> alist) {
        this.context = context;
        this.alist = alist;
    }

    @Override
    public int getCount() {
        return alist.size();
    }

    @Override
    public Object getItem(int position) {
        return alist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DialogAccountItemBinding binding = DialogAccountItemBinding.inflate(LayoutInflater.from(context), parent, false);
        View view = binding.getRoot();
        binding.dialogImage.setImageResource(alist.get(position).getImageId());
        binding.dialogText.setText(alist.get(position).getType());
        return view;
    }
}
