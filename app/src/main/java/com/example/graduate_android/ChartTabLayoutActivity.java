package com.example.graduate_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.graduate_android.component.CustomReturn;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

//TabLayout滑动界面
public class ChartTabLayoutActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    private CustomReturn returnChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_tab_layout);

        //TabLayout\
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);

        returnChart = findViewById(R.id.returnChart);

        returnChart.setOnClickListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChartTabLayoutActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });


        viewPager2.setAdapter(new OrdersPagerAdapter(this));

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0: {
                        tab.setText("基础统计");
                        break;
                    }
                    case 1: {
                        tab.setText("账户");
                        break;
                    }
                    case 2: {
                        tab.setText("成员");
                        break;
                    }
                    case 3: {
                        tab.setText("项目");
                        break;
                    }

                }
            }
        });


        tabLayoutMediator.attach();


    }
}