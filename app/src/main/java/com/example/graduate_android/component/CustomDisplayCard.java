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

public class CustomDisplayCard extends LinearLayout {

    private final String accountD;
    private final String assetD;
    private final String sourceD;
    private final String moneyD;
    private final int imageD;

    public CustomDisplayCard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomDisplayCard);
        accountD = typedArray.getString(R.styleable.CustomDisplayCard_accountD);
        assetD = typedArray.getString(R.styleable.CustomDisplayCard_assetD);
        sourceD = typedArray.getString(R.styleable.CustomDisplayCard_sourceD);
        moneyD = typedArray.getString(R.styleable.CustomDisplayCard_moneyD);
        imageD = typedArray.getResourceId(R.styleable.CustomDisplayCard_imageD, 0);
        typedArray.recycle();

        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.custom_display_card,this);

        TextView accountDC = findViewById(R.id.accountDC);
        TextView assetDC = findViewById(R.id.assetDC);
        TextView sourceDC = findViewById(R.id.sourceDC);
        TextView moneyDC = findViewById(R.id.moneyDC);
        ImageView imageDC = findViewById(R.id.imageDC);
        if (accountD!=null){
            accountDC.setText(accountD);
        }
        if (assetD!=null){
            assetDC.setText(assetD);
        }
        if (sourceD!=null){
            sourceDC.setText(sourceD);
        }
        if (moneyD!=null){
            moneyDC.setText(moneyD);
        }
        if (imageD!=0){
            imageDC.setImageResource(imageD);
        }

    }
}
