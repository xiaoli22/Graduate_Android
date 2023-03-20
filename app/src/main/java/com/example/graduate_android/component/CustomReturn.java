package com.example.graduate_android.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.graduate_android.R;

//返回组件
public class CustomReturn extends LinearLayout {

    private final String title;
    private final TypedArray typedArray;
    private TextView titleR;
    private ImageButton returnR;

    public CustomReturn(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomReturn);
        title = typedArray.getString(R.styleable.CustomReturn_title);

        typedArray.recycle();
        init();

    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.custom_return, this);

        returnR = findViewById(R.id.returnR);
        titleR = findViewById(R.id.titleR);
        if (title != null) {
            this.titleR.setText(title);
        }

    }

    public void setOnClickListeners(OnClickListener listener) {
        titleR.setOnClickListener(listener);
        returnR.setOnClickListener(listener);
    }

    public String getTitleR() {
        return titleR.getText().toString();
    }

    public void setTitleR(String titleR) {
        this.titleR.setText(titleR);
    }
}
