package com.example.graduate_android.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;

public class RippleUtils {
    public static Drawable createRippleDrawable(Context context, @ColorRes int color, @DrawableRes int contentDrawable) {
        // 创建Ripple Drawable对象
        ColorStateList colorStateList = ColorStateList.valueOf(ContextCompat.getColor(context, color));
        Drawable content = ContextCompat.getDrawable(context, contentDrawable);
        return new RippleDrawable(colorStateList, content, null);
    }
}
