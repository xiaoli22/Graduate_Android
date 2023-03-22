package com.example.graduate_android.bean;

import com.example.graduate_android.R;

import java.util.ArrayList;

public class DialogBase {
    private String type;
    private int imageId;


    public static String[] typeArrays = {"现金账户", "银行卡", "支付宝", "微信钱包", "银行卡"};
    public static int[] icons = {R.drawable.account_cash, R.drawable.account_card2,
            R.drawable.account_zhifubao, R.drawable.account_weixin, R.drawable.account_card};

    public DialogBase(String name, int imageId) {
        this.type = name;
        this.imageId = imageId;
    }

    public String getType() {
        return type;
    }

    public int getImageId() {
        return imageId;
    }

    public static ArrayList<DialogBase> getDefaultDialogBase() {
        ArrayList<DialogBase> list = new ArrayList<>();
        for (int i = 0; i < typeArrays.length; i++) {
            list.add(new DialogBase(typeArrays[i], icons[i]));
        }
        return list;
    }
}
