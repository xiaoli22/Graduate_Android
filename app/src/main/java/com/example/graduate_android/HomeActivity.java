package com.example.graduate_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.graduate_android.component.CustomImageButton;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

//app主界面
public class HomeActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private CustomImageButton customA;
    private CustomImageButton customB;
    private CustomImageButton customC;
    private CustomImageButton customD;
    private LineChart lineChart;
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        customA = findViewById(R.id.customButtonA);
        customB = findViewById(R.id.customButtonB);
        customC = findViewById(R.id.customButtonC);
        customD = findViewById(R.id.customButtonD);
        lineChart = findViewById(R.id.lineChart);
        bottomNavigation = findViewById(R.id.bottomNavigation);

        bottomNavigation.setOnItemSelectedListener(this);

        ArrayList<Entry> dataList1 = new ArrayList<>();
        ArrayList<Entry> dataList2 = new ArrayList<>();
        Entry entry1 = new Entry(100,200);
        Entry entry2 = new Entry(200,300);
        Entry entry3 = new Entry(300,800);
        Entry entry4 = new Entry(400,200);
        Entry entry5 = new Entry(500,600);
        dataList1.add(entry1);
        dataList1.add(entry2);
        dataList1.add(entry3);
        dataList1.add(entry4);
        dataList1.add(entry5);



        Entry entry10 = new Entry(100,0);
        Entry entry6 = new Entry(200,50);
        Entry entry7 = new Entry(300,150);
        Entry entry8 = new Entry(400,200);
        Entry entry9 = new Entry(500,600);
        dataList2.add(entry10);
        dataList2.add(entry6);
        dataList2.add(entry7);
        dataList2.add(entry8);
        dataList2.add(entry9);

        LineDataSet dataSet1 = new LineDataSet(dataList1, "Label");
        LineDataSet dataSet2 = new LineDataSet(dataList2, "Label");

        dataSet1.setColor(Color.BLUE);
        dataSet1.setLineWidth(3f);
        dataSet1.setCircleColor(Color.RED);

        dataSet2.setColor(Color.GREEN);
        dataSet2.setLineWidth(2f);
        dataSet2.setCircleColor(Color.RED);




        // 将数据集添加到 LineChart
        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet1);
        dataSets.add(dataSet2);
        LineData lineData = new LineData(dataSets);
        lineChart.setData(lineData);
        lineChart.invalidate();


        customA.setOnClickListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SendOtpActivity.class);
                startActivity(intent);

            }
        });

        customB.setOnClickListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SendOtpActivity.class);
                startActivity(intent);

            }
        });

        customC.setOnClickListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SendOtpActivity.class);
                startActivity(intent);

            }
        });

        customD.setOnClickListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SendOtpActivity.class);
                startActivity(intent);

            }
        });

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.water:

                break;
            case R.id.chart:
                Intent intent = new Intent(this,ChartTabLayoutActivity.class);
                startActivity(intent);
                break;

            case R.id.person:

                break;
            case R.id.setting:

                break;
        }
        return false;
    }
}