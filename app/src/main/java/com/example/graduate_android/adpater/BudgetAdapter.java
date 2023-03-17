package com.example.graduate_android.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.graduate_android.R;
import com.example.graduate_android.bean.Budget;

import java.util.List;
import java.util.Locale;

public class BudgetAdapter extends ArrayAdapter<Budget> {
    private Context context;
    private List<Budget> budgetList;

    public BudgetAdapter(Context context, List<Budget> budgetList) {
        super(context, 0, budgetList);
        this.context = context;
        this.budgetList = budgetList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.custom_budget_show, parent, false);
        }

        ImageView imageView = view.findViewById(R.id.imageBS);
        TextView titleTextView = view.findViewById(R.id.titleBS);
//        ProgressBar progressBar = view.findViewById(R.id.progressBS);
//        TextView budgetTextView = view.findViewById(R.id.budgetBS);
//        TextView balanceTextView = view.findViewById(R.id.balanceBS);

        Budget budget = budgetList.get(position);
        imageView.setImageResource(budget.getImageResId());
        titleTextView.setText(budget.getType());
//        progressBar.setProgress((int) (budget.getBalance() / budget.getBudget() * 100));
//        budgetTextView.setText(String.format(Locale.getDefault(), "支出预算 %.2f", budget.getBudget()));
//        balanceTextView.setText(String.format(Locale.getDefault(), "余额: %.2f", budget.getBalance()));

        return view;
    }
}
