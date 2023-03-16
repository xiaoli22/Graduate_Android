package com.example.graduate_android.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.graduate_android.R;

public class CustomBudgetShow extends RelativeLayout {

    private ImageView imageBudget;
    private TextView titleBudget, budgetBudget, balanceBudget;
    private ProgressBar progressBS;
    private int progress;

    public CustomBudgetShow(Context context) {
        super(context);
        init(context, null);
    }

    public CustomBudgetShow(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }


    public CustomBudgetShow(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_budget_show, this);

        imageBudget = (ImageView) findViewById(R.id.imageBS);
        titleBudget = (TextView) findViewById(R.id.titleBS);
        budgetBudget = (TextView) findViewById(R.id.budgetBS);
        balanceBudget = (TextView) findViewById(R.id.balanceBS);
        progressBS = findViewById(R.id.progressBS);

        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomBudgetShow, 0, 0);

            try {
                Drawable image = typedArray.getDrawable(R.styleable.CustomBudgetShow_imageS);
                String title = typedArray.getString(R.styleable.CustomBudgetShow_titleS);
                String budget = typedArray.getString(R.styleable.CustomBudgetShow_budgetS);
                String balance = typedArray.getString(R.styleable.CustomBudgetShow_balanceS);
                progress = (int) typedArray.getInt(R.styleable.CustomBudgetShow_progressS, 0);

                if (progress != 0) {
                    progressBS.setProgress(progress);
                }

                if (image != null) {
                    imageBudget.setImageDrawable(image);
                }
                if (title != null) {
                    titleBudget.setText(title);
                }
                if (budget != null) {
                    budgetBudget.setText(budget);
                }
                if (balance != null) {
                    balanceBudget.setText(balance);
                }
            } finally {
                typedArray.recycle();
            }
        }
    }

    public void setImageBudget(ImageView imageBudget) {
        this.imageBudget = imageBudget;
    }

    public void setTitleBudget(TextView titleBudget) {
        this.titleBudget = titleBudget;
    }

    public void setBudgetBudget(TextView budgetBudget) {
        this.budgetBudget = budgetBudget;
    }

    public void setBalanceBudget(TextView balanceBudget) {
        this.balanceBudget = balanceBudget;
    }

    public void setProgressBS(int progress) {
        this.progressBS.setProgress(progress);
    }
}

