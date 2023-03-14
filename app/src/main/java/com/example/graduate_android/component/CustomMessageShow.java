package com.example.graduate_android.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.graduate_android.R;

public class CustomMessageShow extends LinearLayout {


    private final String titleM;
    private final int imageM;
    private final String numberM;
    private final String incomeM;
    private final String outcomeM;

    public CustomMessageShow(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomMessageShow);

        titleM = a.getString(R.styleable.CustomMessageShow_titleM);
        imageM = a.getResourceId(R.styleable.CustomMessageShow_imageM, 0);
        numberM = a.getString(R.styleable.CustomMessageShow_numberM);
        incomeM = a.getString(R.styleable.CustomMessageShow_incomeM);
        outcomeM = a.getString(R.styleable.CustomMessageShow_outcomeM);
        a.recycle();

        init();

    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.custom_message_show, this);

        TextView toadyMs = findViewById(R.id.todayMS);
        TextView numberMS = findViewById(R.id.numberMS);
        TextView incomeMS = findViewById(R.id.incomeMS);
        TextView outcomeMS = findViewById(R.id.outcomeMS);
        ImageView imageMS = findViewById(R.id.imageMS);

        if (titleM != null) {
            toadyMs.setText(titleM);
        }
        if (numberM != null) {
            numberMS.setText(numberM);
        }
        if (incomeM != null) {
            incomeMS.setText(incomeM);
        }
        if (outcomeM != null) {
            outcomeMS.setText(outcomeM);
        }
        if (imageM!=0){
            imageMS.setImageResource(imageM);
        }


    }
}
