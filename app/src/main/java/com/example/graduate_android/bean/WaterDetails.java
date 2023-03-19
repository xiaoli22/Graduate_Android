package com.example.graduate_android.bean;

import static com.example.graduate_android.utils.DateTimeUtils.getCurrentDay;
import static com.example.graduate_android.utils.DateTimeUtils.getDayOfWeek;

import com.example.graduate_android.R;

import java.util.ArrayList;

public class WaterDetails {
    private String type;//收支类型
    private int icon;//图标,由type类型决定
    private String detail;//当天的时间+付款方式+用户名
    private String income;//收入（红色）和或支出（绿色）

    public String getType() {
        return type;
    }

    public int getIcon() {
        return icon;
    }

    public String getDetail() {
        return detail;
    }

    public String getIncome() {
        return income;
    }

    public WaterDetails(String type, int icon, String detail, String cost) {
        this.type = type;
        this.icon = icon;
        this.detail = detail;
        this.income = cost;
    }

    private static final String[] costs = {
            "100", "900", "300", "400", "500"
    };
    private static final String[] types = {
            "进货支出", "进货支出", "进货支出", "进货支出", "进货支出"
    };
    //details有时间+支付类型+用户生成，
    private static final String[] details = {
            "20:00 现金账号 133wkc", "16:00 现金账号 133wkc", "10:00 银行卡 133wkc", "12:00 支付宝 133wkc", "14:00 微信钱包 133wkc"
    };

    //测试用的案例
    public static ArrayList<WaterDetails> getDefaultListWD() {
        ArrayList<WaterDetails> arrayList = new ArrayList<>();
        String str;
        for (int i = 0; i < costs.length; i++) {
            //测试用
            str = getCurrentDay() + "\n" + getDayOfWeek();
//            arrayList.add(new WaterLabel(getCurrentYearAndMonth(), (incomes[i] - outcomes[i]), incomes[i], outcomes[i]));
            arrayList.add(new WaterDetails(types[i], R.drawable.account_card, details[i], costs[i]));
        }
        return arrayList;
    }

}
