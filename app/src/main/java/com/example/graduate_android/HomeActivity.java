package com.example.graduate_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.graduate_android.component.CustomImageButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

//app主界面
public class HomeActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private CustomImageButton customA;
    private CustomImageButton customB;
    private CustomImageButton customC;
    private CustomImageButton customD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        customA = findViewById(R.id.customButtonA);
        customB = findViewById(R.id.customButtonB);
        customC = findViewById(R.id.customButtonC);
        customD = findViewById(R.id.customButtonD);
        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnItemSelectedListener(this);

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