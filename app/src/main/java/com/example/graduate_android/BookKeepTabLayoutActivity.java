package com.example.graduate_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.graduate_android.fragments.OrdersPagerAdapter2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class BookKeepTabLayoutActivity extends AppCompatActivity {

    private TabLayout tabLayoutBK;
    private ViewPager2 viewPager2Bk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_keeping);

        tabLayoutBK = findViewById(R.id.tabLayoutBK);
        viewPager2Bk = findViewById(R.id.viewPagerBK);


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