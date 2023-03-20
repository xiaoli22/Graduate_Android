package com.example.graduate_android;

import static com.example.graduate_android.bean.WaterDetails.getDefaultListWD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.graduate_android.adpater.WaterDatailsAdapter;
import com.example.graduate_android.bean.WaterDetails;
import com.example.graduate_android.component.CustomReturn;

import java.util.ArrayList;

public class WaterDetailsActivity extends AppCompatActivity {

    private ComponentName componentName;
    private String className;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_details);
        Intent intent = getIntent();

//
//        Log.d("STR", "className: " + className);
//        Log.d("STR", "className: " + className);
//        Log.d("STR", "title: " + (intent.getStringExtra("title")));
//        Log.d("STR", "title: " + (intent.getStringExtra("title")));
        className = intent.getStringExtra("class");
        ListView listViewWD = findViewById(R.id.listViewWD);
        CustomReturn returnWD = findViewById(R.id.returnWD);

        //由于Water和Account界面都是用了return，所以需要判断才可以为返回键设置标题
        //judge className is not null

        if ("AccountActivity".equals(className)) {
            String title = intent.getStringExtra("title");
            returnWD.setTitleR(title);
        } else {
            returnWD.setTitleR("流水详情");
        }

        returnWD.setOnClickListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("AccountActivity".equals(className)) {
                    //go to AccountActivity
                    Intent intent = new Intent(WaterDetailsActivity.this, AccountActivity.class);
                    startActivity(intent);
                } else {
                    //go to WaterActivity
                    Intent intent = new Intent(WaterDetailsActivity.this, WaterActivity.class);
                    startActivity(intent);
                }


            }
        });

        ArrayList<WaterDetails> array = getDefaultListWD();
        WaterDatailsAdapter waterDatailsAdapter = new WaterDatailsAdapter(this, array);

        listViewWD.setAdapter(waterDatailsAdapter);

    }
}