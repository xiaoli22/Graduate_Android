package com.example.graduate_android.component;

import static android.app.Activity.RESULT_OK;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.graduate_android.R;

import java.io.IOException;

public class CustomMessageShow extends LinearLayout {


    private final String titleM;
    private final int imageM;
    private final String numberM;
    private final String incomeM;
    private final String outcomeM;
    private final Context mContext;
    private TextView toadyMs;
    private ImageView imageMS;
    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageButton photoMS;
    private TextView outcomeMS;



    public CustomMessageShow(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
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

        toadyMs = findViewById(R.id.todayMS);
        TextView numberMS = findViewById(R.id.numberMS);
        TextView incomeMS = findViewById(R.id.incomeMS);
        outcomeMS = findViewById(R.id.outcomeMS);
        imageMS = findViewById(R.id.imageMS);
        photoMS = findViewById(R.id.phtotMS);

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
        if (imageM != 0) {
            imageMS.setImageResource(imageM);
        }
//        photoMS.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                selectImage();
//            }
//        });
    }

    public void selectImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        ((Activity) getContext()).startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    public void setImageMS(int image) {
        this.imageMS.setBackgroundResource(image);
    }

    public void setOutcomeMS(String text) {
        this.outcomeMS.setText(text);
    }

    private OnImageSelectedListener onImageSelectedListener;
    public interface OnImageSelectedListener {
        void onImageSelected(Uri selectedImageUri);
    }
    public void setOnImageSelectedListener(OnImageSelectedListener listener) {
        this.onImageSelectedListener = listener;
    }
    //    public void setImageUri(Uri uri) {
//        try {
//            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), uri);
//            Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, 200, 200, false);
//            BitmapDrawable drawable = new BitmapDrawable(getResources(), scaledBitmap);
//            imageMS.setBackground(drawable);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
