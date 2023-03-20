package com.example.graduate_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.graduate_android.component.CustomImageButton;
import com.example.graduate_android.component.CustomMessageBar;
import com.example.graduate_android.utils.DateTimeUtils;
import com.example.graduate_android.utils.RippleUtils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

//app主界面
public class HomeActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private CustomImageButton customA;
    private CustomImageButton customB;
    //    private CustomImageButton customC;
    private CustomImageButton customD;
    private LineChart lineChart;
    private BottomNavigationView bottomNavigation;
    private FloatingActionButton add;
    private CustomMessageBar customBarA;
    private CustomMessageBar customBarB;
    private CustomMessageBar customBarC;
    private Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        setContentView(R.layout.activity_home);

        //顶部的4个自定义ImageView+TextView组成的按钮
        customA = findViewById(R.id.customButtonA);
        customB = findViewById(R.id.customButtonB);
//        customC = findViewById(R.id.customButtonC);
        customD = findViewById(R.id.customButtonD);
        add = findViewById(R.id.add);
        customBarA = findViewById(R.id.customBarA);
        customBarB = findViewById(R.id.customBarB);
        customBarC = findViewById(R.id.customBarC);

        customBarA.setDateMB(DateTimeUtils.getDateOfCurrentWeek());
        customBarB.setDateMB(DateTimeUtils.getMonthFirstAndLastDay());
        customBarC.setDateMB(DateTimeUtils.getCurrentYear() + "年");



        bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnItemSelectedListener(this);



        /*
         * 监听顶部的四个按钮
         *
         * */
        customA.setOnClickListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AccountActivity.class);
                startActivity(intent);

            }
        });


        customB.setOnClickListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, BudgetActivity.class);
                startActivity(intent);

            }
        });

//        customC.setOnClickListeners(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this, SendOtpActivity.class);
//                startActivity(intent);
//
//            }
//        });

        customD.setOnClickListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ServiceActivity.class);
                startActivity(intent);

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, BookKeepTabLayoutActivity.class);
                startActivity(intent);
            }
        });

    }


    //底部导航栏按钮监听
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Intent intent = new Intent();
        switch (item.getItemId()) {
            case R.id.water:
                intent.setClass(this, WaterActivity.class);
                startActivity(intent);
                break;
            case R.id.chart:
                intent.setClass(this, ChartTabLayoutActivity.class);
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