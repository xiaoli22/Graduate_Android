package com.example.graduate_android.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.graduate_android.R;

public class CustomMessageBar extends LinearLayout {


    private final TypedArray typedArray;
    private final String time;
    private final String date;
    private final String income;
    private final String outcome;
    private final int image;
    private TextView dateMB;
    private TextView timeMB;
    private TextView incomeMB;
    private TextView outcomeMB;
    private ImageView imageMB;

    public CustomMessageBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        typedArray = context.obtainStyledAttributes(attrs,R.styleable.CustomMessageBar);
        time = typedArray.getString(R.styleable.CustomMessageBar_time);
        date = typedArray.getString(R.styleable.CustomMessageBar_date);
        income = typedArray.getString(R.styleable.CustomMessageBar_income);
        outcome = typedArray.getString(R.styleable.CustomMessageBar_outcome);
        image = typedArray.getResourceId(R.styleable.CustomMessageBar_image,0);
        typedArray.recycle();

        init();


    }

    //给自定义组件中的属性赋值
    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.custom_message_bar,this);

        imageMB = findViewById(R.id.imageMB);
        timeMB = findViewById(R.id.timeMB);
        dateMB = findViewById(R.id.dateMB);
        incomeMB = findViewById(R.id.incomeMB);
        outcomeMB = findViewById(R.id.outcomeMB);

        if (time!=null){
            this.timeMB.setText(time);
        }
        if (date!=null){
            this.dateMB.setText(date);
        }
        if (income!=null){
            this.incomeMB.setText(income);
        }
        if (outcome!=null){
            this.outcomeMB.setText(outcome);
        }
        if (0!=image){
            this.imageMB.setImageResource(image);
        }
    }
}
