package com.example.graduate_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.graduate_android.component.CustomImageButton;

public class HomeActivity extends AppCompatActivity {

    private CustomImageButton customIB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        customIB = findViewById(R.id.customImageButton);
        customIB.setImageButtonResource(R.drawable.ic_launcher_background);

        customIB.setOnClickListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,SendOtpActivity.class);
                startActivity(intent);

            }
        });
//        customIB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(HomeActivity.this,
//                        "Click Button",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}