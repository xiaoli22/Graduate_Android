package com.example.graduate_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.graduate_android.adpater.BudgetAdapter;
import com.example.graduate_android.bean.Budget;
import com.example.graduate_android.component.CustomReturn;

import java.util.List;
import java.util.Map;

public class BudgetTwoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private Map<String, List<Budget>> budgetLists;
    private List<Budget> budgetList;
    private ListView listView;
    private CustomReturn returnBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_two);

        returnBT = findViewById(R.id.returnBT);
        listView = findViewById(R.id.listViewBT);


        returnBT.setOnClickListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BudgetTwoActivity.this, BudgetActivity.class);
                startActivity(intent);
            }
        });

        //通过传递的position，确定点击的目标，
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1);
        String str = "list";
        if (position == -1) {
            Toast.makeText(this, "出错了", Toast.LENGTH_SHORT).show();
        } else {
            str = str + position;
//            Log.e("STR", str);
//            System.out.println("==================================" + str + "===================================");
        }


        //BudgetAdapter测试,确定绑定布局，获取初始化数据，使用setAdapter实现数据和视图的绑定
        //获取数据集，根据传递来的值决定显示的数据
        budgetLists = Budget.getDefaultLists();
        budgetList = budgetLists.get(str);
        BudgetAdapter budgetAdapter = new BudgetAdapter(this, budgetList);
        listView.setAdapter(budgetAdapter);
        listView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "点击了是二级预算" + budgetList.get(position).getType(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
