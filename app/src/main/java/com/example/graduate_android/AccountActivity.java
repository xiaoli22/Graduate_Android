package com.example.graduate_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.graduate_android.component.CustomDisplayCard;
import com.example.graduate_android.component.CustomReturn;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    private CustomReturn returnA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        returnA = findViewById(R.id.returnA);
        CustomDisplayCard cardA = findViewById(R.id.cardA);
        CustomDisplayCard cardB = findViewById(R.id.cardB);
        CustomDisplayCard cardD = findViewById(R.id.cardC);
        CustomDisplayCard cardE = findViewById(R.id.cardD);
        CustomDisplayCard cardC = findViewById(R.id.cardE);

        cardA.setOnClickListener(this);
        cardB.setOnClickListener(this);
        cardC.setOnClickListener(this);
        cardD.setOnClickListener(this);
        cardE.setOnClickListener(this);
//获得今天的日期
        returnA.setOnClickListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(AccountActivity.this, WaterDetailsActivity.class));

    }
}