package com.example.graduate_android.bean;

import com.example.graduate_android.R;

import java.util.ArrayList;

public class Account {
    private int image;
    private String aname;
    private String create;
    private String createNumber;

    public Account(int image, String aname, String create, String createNumber) {
        this.image = image;
        this.aname = aname;
        this.create = create;
        this.createNumber = createNumber;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public String getCreateNumber() {
        return createNumber;
    }

    public void setCreateNumber(String createNumber) {
        this.createNumber = createNumber;
    }

    static String[] typeArray = {"生意账本",};
    static int[] images = {R.drawable.ic_launcher_background};
    static String[] creaters = {"我",};
    static int[] creatersNm = {1};


    public static ArrayList<Account> getDefaultAccount() {
        ArrayList<Account> list = new ArrayList<>();
        for (int i = 0; i < typeArray.length; i++) {
            list.add(new Account(images[i], typeArray[i], creaters[i], creatersNm[i] + ""));
        }
        return list;
    }
}
