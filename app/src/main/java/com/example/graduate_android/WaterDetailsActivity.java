package com.example.graduate_android;

import static com.example.graduate_android.bean.WaterDetails.getDefaultListWD;
import static com.example.graduate_android.bean.WaterLabel.getDefaultListWL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.graduate_android.adpater.WaterAdapter;
import com.example.graduate_android.adpater.WaterDatailsAdapter;
import com.example.graduate_android.bean.WaterDetails;
import com.example.graduate_android.bean.WaterLabel;
import com.example.graduate_android.component.CustomReturn;

import java.util.ArrayList;

public class WaterDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_details);

        ListView listViewWD = findViewById(R.id.listViewWD);
        CustomReturn returnWD = findViewById(R.id.returnWD);


        returnWD.setOnClickListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WaterDetailsActivity.this, WaterActivity.class));
            }
        });

        ArrayList<WaterDetails> array = getDefaultListWD();
        WaterDatailsAdapter waterDatailsAdapter = new WaterDatailsAdapter(this, array);

        listViewWD.setAdapter(waterDatailsAdapter);

//        ListView listViewW = findViewById(R.id.listViewW);
//
//        ArrayList<WaterLabel> arrayList = (ArrayList<WaterLabel>) getDefaultListWL();
//        WaterAdapter waterAdapter = new WaterAdapter(this, arrayList);
//        listViewW.setAdapter(waterAdapter);
    }
}