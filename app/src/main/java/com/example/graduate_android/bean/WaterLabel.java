package com.example.graduate_android.bean;

import static com.example.graduate_android.utils.DateTimeUtils.getCurrentMonth;
import static com.example.graduate_android.utils.DateTimeUtils.getCurrentYear;

import java.util.ArrayList;

public class WaterLabel {
    private String time;//年+月
    private double number;//余额
    private double income;//收入
    private double outcome;//支出

    public WaterLabel(String time, double number, double income, double outcome) {
        this.time = time;
        this.number = number;
        this.income = income;
        this.outcome = outcome;
    }

    private static final int[] incomes = {
            100, 900, 300, 400, 500
    };
    private static final int[] outcomes = {
            0, 100, 200, 300, 1000
    };

    public static ArrayList<WaterLabel> getDefaultListWL() {
        ArrayList<WaterLabel> arrayList = new ArrayList<>();
        String str;
        for (int i = 0; i < incomes.length; i++) {
            //测试用
            str = getCurrentYear() + "年" + (getCurrentMonth() + i) + "月";
//            arrayList.add(new WaterLabel(getCurrentYearAndMonth(), (incomes[i] - outcomes[i]), incomes[i], outcomes[i]));
            arrayList.add(new WaterLabel(str, (incomes[i] - outcomes[i]), incomes[i], outcomes[i]));
        }
        return arrayList;
    }

    public String getTime() {
        return time;
    }

    public double getNumber() {
        return number;
    }

    public double getIncome() {
        return income;
    }

    public double getOutcome() {
        return outcome;
    }
}
