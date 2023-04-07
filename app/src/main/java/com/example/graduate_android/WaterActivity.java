package com.example.graduate_android;

import static com.example.graduate_android.bean.WaterLabel.getDefaultListWL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.graduate_android.adpater.WaterAdapter;
import com.example.graduate_android.bean.WaterDetails;
import com.example.graduate_android.bean.WaterLabel;
import com.example.graduate_android.component.CustomReturn;

import java.util.ArrayList;

public class WaterActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);
        ListView listViewW = findViewById(R.id.listViewW);
        CustomReturn returnW = findViewById(R.id.returnW);


        returnW.setOnClickListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WaterActivity.this, HomeActivity.class));
            }
        });


        ArrayList<WaterLabel> arrayList = (ArrayList<WaterLabel>) getDefaultListWL();
        WaterAdapter waterAdapter = new WaterAdapter(this, arrayList);
        listViewW.setAdapter(waterAdapter);
        listViewW.setOnItemClickListener(this);
//        //获取初始数据
//        budgetList = Budget.getDefaultList();
//        BudgetAdapter budgetAdapter = new BudgetAdapter(this, budgetList);
//        //数据与视图绑定
//        listViewB.setAdapter(budgetAdapter);
//        listViewB.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(WaterActivity.this, WaterDetailsActivity.class);
        startActivity(intent);
    }
}