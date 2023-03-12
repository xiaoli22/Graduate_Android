package com.example.graduate_android.component;


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.graduate_android.R;

/**
 * @author: HP
 * @date: 2023/3/4
 * ImageButton+TextView 组成的复合组件
 */
public class CustomImageButton extends LinearLayout {

    private final String hint;
    private final int image;
    private final TypedArray typedArray;
    private ImageButton imageIB;
    private TextView hintIB;

    public CustomImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        //联系attrs的自定义属性
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomImageButton);
        //获取主布局中设置的app:自定义属性的值
        hint = typedArray.getString(R.styleable.CustomImageButton_hintText);
        image = typedArray.getResourceId(R.styleable.CustomImageButton_imageButtonResource, 0);

        typedArray.recycle();


      init();

    }

    //给自定义组件中的属性赋值
    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.custom_image_button, this);

        imageIB = findViewById(R.id.image_button);
        hintIB = findViewById(R.id.hint_text);

        //为自定义组件的属性赋值
        if (hint!=null){
            this.hintIB.setText(hint);
        }
        if (0 != image){
            this.imageIB.setImageResource(image);
        }
    }


    public void setOnClickListeners(OnClickListener listener) {
        imageIB.setOnClickListener(listener);
        hintIB.setOnClickListener(listener);
    }

}
