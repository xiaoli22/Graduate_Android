//package com.example.graduate_android.component;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.widget.LinearLayout;
//
//import androidx.annotation.Nullable;
//
//import com.example.graduate_android.R;
//import com.example.graduate_android.databinding.CustomAccountBookBinding;
//
//public class CustomAccountBook extends LinearLayout {
//
//    public CustomAccountBook(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//        init(context, attrs);
//    }
//
//    private void init(Context context, AttributeSet attrs) {
//        //获取传入的数据
//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomAccountBook);
//        int image = typedArray.getResourceId(R.styleable.CustomAccountBook_imageAB, 0);
//        String aname = typedArray.getString(R.styleable.CustomAccountBook_aname);
//        String create = typedArray.getString(R.styleable.CustomAccountBook_create);
//        String createNumber = typedArray.getString(R.styleable.CustomAccountBook_createNumber);
//        typedArray.recycle();
//
//        //把传入的数据设置到自定义控件上
//        CustomAccountBookBinding binding = CustomAccountBookBinding.inflate(LayoutInflater.from(context), this, true);
//        if (image != 0) {
////            binding.imageAB.setImageResource(image);
//        }
//        if (aname != null) {
//            binding.accountName.setText(aname);
//        }
//        if (create != null) {
//            binding.creater.setText(create);
//        }
//        if (createNumber != null) {
//            binding.createrNumber.setText(createNumber);
//        }
//
//    }
//
//    public void setImageAB(int image) {
//        CustomAccountBookBinding binding = CustomAccountBookBinding.inflate(LayoutInflater.from(getContext()), this, true);
//        binding.imageAB.setImageResource(image);
//    }
//
//    public void setAccountName(String aname) {
//        CustomAccountBookBinding binding = CustomAccountBookBinding.inflate(LayoutInflater.from(getContext()), this, true);
//        binding.accountName.setText(aname);
//    }
//
//    public void setCreater(String create) {
//        CustomAccountBookBinding binding = CustomAccountBookBinding.inflate(LayoutInflater.from(getContext()), this, true);
//        binding.creater.setText(create);
//    }
//
//    public void setCreaterNumber(String createNumber) {
//        CustomAccountBookBinding binding = CustomAccountBookBinding.inflate(LayoutInflater.from(getContext()), this, true);
//        binding.createrNumber.setText(createNumber);
//    }
//
//}
