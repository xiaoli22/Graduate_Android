package com.example.graduate_android.bean;

import static com.example.graduate_android.utils.DateTimeUtils.getCurrentDay;
import static com.example.graduate_android.utils.DateTimeUtils.getCurrentMonth;
import static com.example.graduate_android.utils.DateTimeUtils.getCurrentYear;

import com.example.graduate_android.R;

import java.util.ArrayList;
import java.util.Locale;

public class AddNormal {

    private int image;
    private String type;
    private String data;
    static String date = String.format(Locale.CHINA, "%d-%d-%d", getCurrentYear(), getCurrentMonth(), getCurrentDay());

    public AddNormal(int image, String type, String data) {
        this.image = image;
        this.type = type;
        this.data = data;
    }

    public AddNormal(int image, String type) {
        this.image = image;
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    static int[] imageArray = {R.drawable.book_account, R.drawable.book_time, R.drawable.book_member, R.drawable.book_project, R.drawable.book_note};
    static String[] typeArray = {"账户", "时间", "成员", "项目", "备注"};
    static String[] dataArray = {"现金账户", date, "相关数据", "相关数据", "..."};

    static int[] imageArray1 = {R.drawable.book_account, R.drawable.book_note};
    static String[] typeArray1 = {"账户", "备注"};
    static String[] dataArray1 = {"现金账户", "..."};


    public static ArrayList<AddNormal> getDefaultAN() {
        ArrayList<AddNormal> addNormals = new ArrayList<>();
        for (int i = 0; i < imageArray.length; i++) {
            addNormals.add(new AddNormal(imageArray[i], typeArray[i], dataArray[i]));
        }
        return addNormals;
    }

    public static ArrayList<AddNormal> getDefaultAN1() {
        ArrayList<AddNormal> addNormals = new ArrayList<>();
        for (int i = 0; i < imageArray1.length; i++) {
            addNormals.add(new AddNormal(imageArray1[i], typeArray1[i], dataArray1[i]));
        }
        return addNormals;
    }
}
