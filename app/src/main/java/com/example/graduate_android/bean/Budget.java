package com.example.graduate_android.bean;

import com.example.graduate_android.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Budget {
    private String type;//支出类型
    private float budget;//支出预算
    private float balance;//余额
    private int imageResId;//图标


    public Budget(String type, int imageResId) {
        this.type = type;
        this.imageResId = imageResId;
    }


    private static final int[] ImageArray = {
            R.drawable.budget_enterprises, R.drawable.budget_finance, R.drawable.budget_goods, R.drawable.budget_operation,
            R.drawable.budget_shareholder, R.drawable.budget_finance
    };

    private static final String[] TypeArray = {
            "货物材料", "人工支出", "运营费用", "固定资产", "财务费用", "其他杂项"
    };


    private static final int[][] imageArrays = {
            {R.drawable.budget_enterprises, R.drawable.budget_finance,},
            {R.drawable.budget_enterprises, R.drawable.budget_finance, R.drawable.budget_operation, R.drawable.budget_shareholder,},

            {R.drawable.budget_enterprises, R.drawable.budget_finance, R.drawable.budget_goods,
                    R.drawable.budget_operation, R.drawable.budget_shareholder, R.drawable.budget_finance,
                    R.drawable.budget_enterprises,},

            {R.drawable.budget_operation, R.drawable.budget_shareholder, R.drawable.budget_finance},
            {R.drawable.budget_enterprises, R.drawable.budget_finance, R.drawable.budget_goods},
            {R.drawable.budget_enterprises, R.drawable.budget_finance, R.drawable.budget_goods},

    };


    private static final String[][] typeArrays = {
            {"进货支出", "包装耗材"},
            {"员工工资", "员工提成", "员工福利", "员工社会",},
            {"房租", "水电", "物业管理费", "办公用品", "招待费", "油费", "运营杂费"},
            {"办公设备", "房产", "公用车辆"},
            {"做账报税", "税费", "发票"},
            {"烂账损失", "赔偿罚款", "其他支出"},
    };

    public static List<Budget> getDefaultList() {
        ArrayList<Budget> budgetList = new ArrayList<>();
        for (int i = 0; i < ImageArray.length; i++) {
            budgetList.add(new Budget(TypeArray[i], ImageArray[i]));
        }
        return budgetList;
    }

    public static Map<String, List<Budget>> getDefaultLists() {

        //先创建Budget、二维数组每行代表一个页面的数据，两个二维数组的一行数据结合，生成以Budget为单位的，List<Budget>
        //把List<Budget>一共有7个，Map<String, List<Budget>> budgetMap = new HashMap<>();存放到List<>根据点击的组件id选择需要用到的
        Map<String, List<Budget>> budgetMap = new HashMap<>();

        for (int i = 0; i < typeArrays.length; i++) {
            ArrayList<Budget> budgetList = new ArrayList<>();

            for (int j = 0; j < typeArrays[i].length; j++) {
                if ((typeArrays[i][j] != null) && (imageArrays[i][j] != 0)) {
                    budgetList.add(new Budget(typeArrays[i][j], imageArrays[i][j]));
                }
            }
            budgetMap.put("list" + (i + 1), budgetList);
        }
        return budgetMap;

    }


    public Budget(String type, float budget, float balance, int imageResId) {
        this.type = type;
        this.budget = budget;
        this.balance = balance;
        this.imageResId = imageResId;
    }

    public String getType() {
        return type;
    }

    public float getBudget() {
        return budget;
    }

    public float getBalance() {
        return balance;
    }

    public int getImageResId() {
        return imageResId;
    }
}