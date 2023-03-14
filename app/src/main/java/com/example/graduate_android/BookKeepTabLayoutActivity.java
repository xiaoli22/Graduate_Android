package com.example.graduate_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.graduate_android.component.CustomReturn;
import com.example.graduate_android.fragmentadd.OrdersPagerAdapter2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class BookKeepTabLayoutActivity extends AppCompatActivity {

    private TabLayout tabLayoutBK;
    private ViewPager2 viewPager2Bk;
    private CustomReturn returnBK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_keeping);

        tabLayoutBK = findViewById(R.id.tabLayoutBK);
        viewPager2Bk = findViewById(R.id.viewPagerBK);
        returnBK = findViewById(R.id.returnBK);

        //返回按钮监听
        returnBK.setOnClickListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookKeepTabLayoutActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });


        viewPager2Bk.setAdapter(new OrdersPagerAdapter2(this));


        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayoutBK, viewPager2Bk, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0: {
                        tab.setText("支出");
                        break;
                    }
                    case 1: {
                        tab.setText("收入");
                        break;
                    }
                    case 2: {
                        tab.setText("转账");
                        break;
                    }
                    case 3: {
                        tab.setText("余额");
                        break;
                    }
                    case 4:
                        tab.setText("借贷");
                        break;
                    case 5:
                        tab.setText("报销");
                        break;
                }
            }
        });
        tabLayoutMediator.attach();
    }
}