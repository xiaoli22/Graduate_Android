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
import com.example.graduate_android.bean.WaterDetails;

import java.util.ArrayList;

public class WaterDatailsAdapter extends ArrayAdapter<WaterDetails> {

    private Context context;
    private ArrayList<WaterDetails> arrayList;

    public WaterDatailsAdapter(Context context, ArrayList<WaterDetails> waterList) {
        super(context, 0, waterList);
        this.context = context;
        this.arrayList = waterList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.custom_water_details, parent, false);
        }

        ImageView icon = view.findViewById(R.id.imageWD);
        TextView type = view.findViewById(R.id.typeWD);
        TextView income = view.findViewById(R.id.incomeWD);
        TextView details = view.findViewById(R.id.detailsWD);

        WaterDetails wL = arrayList.get(position);
        icon.setImageResource(wL.getIcon());
        type.setText(wL.getType());
        income.setText(wL.getIncome());
        details.setText(wL.getDetail());
        return view;

//        ImageView imageView = view.findViewById(R.id.imageBS);
//        TextView titleTextView = view.findViewById(R.id.titleBS);
//
//
//        Budget budget = budgetList.get(position);
//        imageView.setImageResource(budget.getImageResId());
//        titleTextView.setText(budget.getType());
//
//        return view;
    }

}
