package com.example.graduate_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.graduate_android.component.CustomBudgetShow;
import com.example.graduate_android.component.CustomReturn;

public class BudgetActivity extends AppCompatActivity {

    private CustomReturn returnS;
    private Intent intent=new Intent();
    private CustomBudgetShow budgetShowA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        returnS = findViewById(R.id.returnB);
        budgetShowA = findViewById(R.id.budgetShowA);

        budgetShowA.setProgressBS(50);


        returnS.setOnClickListeners(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                intent = intent.setClass(BudgetActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}