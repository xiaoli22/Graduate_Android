package com.example.graduate_android.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.graduate_android.R;

public class CustomInput extends LinearLayout {

    private final String text;
    private final int color;

    public CustomInput(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomInput);
        text = typedArray.getString(R.styleable.CustomInput_text);
        color = typedArray.getColor(R.styleable.CustomInput_textColor,0xffe19a01);

        typedArray.recycle();
        init();


    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.custom_add_input,this);
        EditText editTextI = findViewById(R.id.editTextAI);
        View viewI = findViewById(R.id.viewAI);
        if (color!=0xffe19a01){
            editTextI.setHintTextColor(color);
            editTextI.setTextColor(color);
            viewI.setBackgroundColor(color);
        }

        if (text!=null){
            editTextI.setText(text);
        }

    }


}
