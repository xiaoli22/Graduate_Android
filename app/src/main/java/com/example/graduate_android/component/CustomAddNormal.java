package com.example.graduate_android.component;

import static com.example.graduate_android.utils.DateTimeUtils.getCurrentMonth;
import static com.example.graduate_android.utils.DateTimeUtils.getCurrentYear;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.graduate_android.R;

import java.util.Locale;

public class CustomAddNormal extends LinearLayout {

    private final int imageA;
    private final String typeA;
    private final String dataA;
    private final String type;
    private ImageView imageAN;
    private TextView typeAN;
    private TextView dataAN;

    public CustomAddNormal(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomAddNormal);
        imageA = typedArray.getResourceId(R.styleable.CustomAddNormal_imageN, 0);
        typeA = typedArray.getString(R.styleable.CustomAddNormal_typeN);
        dataA = typedArray.getString(R.styleable.CustomAddNormal_dataN);
        type = typedArray.getString(R.styleable.CustomAddNormal_types);

        init();
        typedArray.recycle();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.custom_add_normal, this, true);
        imageAN = findViewById(R.id.imageAN);
        typeAN = findViewById(R.id.typeAN);
        dataAN = findViewById(R.id.dataAN);


        if (dataA != null) {
            dataAN.setText(dataA);
        }


    }

    public void setImageAN(ImageView imageAN) {
        this.imageAN = imageAN;
    }

    public void setTypeAN(TextView typeAN) {
        this.typeAN = typeAN;
    }

    public void setDataAN(TextView dataAN) {
        this.dataAN = dataAN;
    }
}
