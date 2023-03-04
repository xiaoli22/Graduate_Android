package com.example.graduate_android.component;


import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.graduate_android.HomeActivity;
import com.example.graduate_android.R;

/**
 * @author: HP
 * @date: 2023/3/4
 */
public class CustomImageButton extends LinearLayout {

    private ImageButton mImageButton;
    private TextView mHintText;

    public CustomImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);

//        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.ImageButtonWithHint);
////        String hit = arr.getString(R.styleable.CustomImageButton, "wkc666");
//        String  hintText= arr.getString(R.styleable.ImageButtonWithHint_hintText);
//        String imageSrc = arr.getString(R.styleable.ImageButtonWithHint_imageButtonResource);
//        View view = findViewById(R.id.customImageButton);
//
//
//        if (hintText!=null){
//
//        }
//
//        arr.recycle();
        init();

    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.custom_image_button, this);

        mImageButton = findViewById(R.id.image_button);
        mHintText = findViewById(R.id.hint_text);



    }

    public void setOnClickListeners(OnClickListener listener) {
//        OnClickListener onClickListener = new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//
//            }
//        };
        mImageButton.setOnClickListener(listener);
        mHintText.setOnClickListener(listener);


    }


    public void setImageButtonResource(int resId) {
        mImageButton.setImageResource(resId);
    }

    public void setHintText(String text) {
        mHintText.setText(text);
    }

    public void setHintText(int resId) {
        mHintText.setText(resId);
    }


}
