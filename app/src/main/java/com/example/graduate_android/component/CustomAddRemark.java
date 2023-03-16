package com.example.graduate_android.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.graduate_android.R;

public class CustomAddRemark extends RelativeLayout {


    private ImageView imageAR;
    private TextView typeAR;
    private EditText dataAR;

    public CustomAddRemark(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.custom_add_remark, this);

        imageAR = findViewById(R.id.imageAR);
        typeAR = findViewById(R.id.typeAR);
        dataAR = findViewById(R.id.dataAR);

        if(attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomAddRemark);
            int imageR = a.getResourceId(R.styleable.CustomAddRemark_imageR,0);
            String typeR = a.getString(R.styleable.CustomAddRemark_typeR);
            String dataR = a.getString(R.styleable.CustomAddRemark_dataR);

            typeAR.setText("备注");
            imageAR.setImageResource(R.drawable.book_note);
            dataAR.setHint("...");


            if (typeR!=null){
                typeAR.setText(typeR);
            }
            if (dataR!=null){
                dataAR.setText(dataR);
            }
            if (imageR!=0){
                imageAR.setImageResource(imageR);
            }



            a.recycle();
        }

    }
}
