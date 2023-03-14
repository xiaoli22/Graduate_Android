package com.example.graduate_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.graduate_android.component.CustomReturn;

public class AccountActivity extends AppCompatActivity {

    private CustomReturn returnA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        returnA = findViewById(R.id.returnA);

        returnA.setOnClickListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this,HomeActivity.class);
                startActivity(intent);

            }
        });
    }
}