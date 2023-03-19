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
import com.example.graduate_android.bean.Budget;
import com.example.graduate_android.bean.WaterLabel;

import java.util.ArrayList;
import java.util.List;

public class WaterAdapter extends ArrayAdapter<WaterLabel> {

    private Context context;
    private ArrayList<WaterLabel> arrayList;

    public WaterAdapter(Context context, ArrayList<WaterLabel> waterList) {
        super(context, 0, waterList);
        this.context = context;
        this.arrayList = waterList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.custom_water_label, parent, false);
        }

        TextView timeWL = view.findViewById(R.id.timeWL);
        TextView numberWL = view.findViewById(R.id.numberWL);
        TextView incomeWL = view.findViewById(R.id.incomeWL);
        TextView outcomeWL = view.findViewById(R.id.outcomeWL);

        WaterLabel wL = arrayList.get(position);
        timeWL.setText(wL.getTime());
        numberWL.setText(wL.getNumber() + "");
        incomeWL.setText("收入 " + wL.getIncome());
        outcomeWL.setText("支出" + wL.getOutcome());
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
