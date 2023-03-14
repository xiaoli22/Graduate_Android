package com.example.graduate_android.component;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.graduate_android.HomeActivity;
import com.example.graduate_android.R;
import com.example.graduate_android.VerifyOtpActivity;
import com.example.graduate_android.utils.DateTimeUtils;

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
    private RelativeLayout customLayoutMB;
    private Context mContext;
    private View viewMB;

    public CustomMessageBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        //获取布局中传来的参数
        mContext = context;
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomMessageBar);
        time = typedArray.getString(R.styleable.CustomMessageBar_time);
        date = typedArray.getString(R.styleable.CustomMessageBar_date);
        income = typedArray.getString(R.styleable.CustomMessageBar_income);
        outcome = typedArray.getString(R.styleable.CustomMessageBar_outcome);
        image = typedArray.getResourceId(R.styleable.CustomMessageBar_image, 0);
        typedArray.recycle();

        init();


    }


    //根据传来的参数 给自定义组件中的属性赋值
    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.custom_message_bar, this);

        viewMB = findViewById(R.id.viewMB);
        imageMB = findViewById(R.id.imageMB);
        timeMB = findViewById(R.id.timeMB);
        //  直接从系统中获取当前时间
        dateMB = findViewById(R.id.dateMB);
        incomeMB = findViewById(R.id.incomeMB);
        outcomeMB = findViewById(R.id.outcomeMB);


        if (time != null) {
            this.timeMB.setText(time);
        }

        if (income != null) {
            this.incomeMB.setText(income);
        }
        if (outcome != null) {
            this.outcomeMB.setText(outcome);
        }
        if (0 != image) {
            this.imageMB.setImageResource(image);
        }
        setBackground(createRippleDrawable());

    }

    public void setOnClickListeners(OnClickListener listener) {
        viewMB.setOnClickListener(listener);
    }

    // 创建RippleDrawable对象
    public Drawable createRippleDrawable() {
        ColorStateList colorStateList = ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.ripple_color));
//        Drawable contentDrawable = getResources().getDrawable(R.drawable.ripple);
        Drawable contentDrawable = getResources().getDrawable(R.drawable.my_select);
        return new RippleDrawable(colorStateList, contentDrawable, null);
    }

    public void setDateMB(String str) {
        this.dateMB.setText(str);
    }
}
