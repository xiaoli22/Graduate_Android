package com.example.graduate_android;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.graduate_android.adpater.BudgetAdapter;
import com.example.graduate_android.bean.Budget;
import com.example.graduate_android.component.CustomBudgetShow;
import com.example.graduate_android.component.CustomMessageShow;
import com.example.graduate_android.component.CustomReturn;

import java.util.List;

public class BudgetActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private CustomReturn returnB;
    private Intent intent = new Intent();
    private CustomBudgetShow budgetShowA;
    private List<Budget> budgetList;
    private ListView listViewB;
    private CustomMessageShow messageShowB;
    private static final int REQUEST_CODE_SELECT_IMAGE = 1;
    private static final int PICK_IMAGE_REQUEST = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        returnB = findViewById(R.id.returnB);
        listViewB = findViewById(R.id.listViewB);
        messageShowB = findViewById(R.id.messageShowB);

        messageShowB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                messageShowB.selectImage();
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
            }
        });


        //获取初始数据
        budgetList = Budget.getDefaultList();
        BudgetAdapter budgetAdapter = new BudgetAdapter(this, budgetList);
        //数据与视图绑定
        listViewB.setAdapter(budgetAdapter);
        listViewB.setOnItemClickListener(this);

        returnB.setOnClickListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(BudgetActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "你点击了第" + budgetList.get(position).getType(), Toast.LENGTH_SHORT).show();
        intent = new Intent(BudgetActivity.this, BudgetTwoActivity.class);
        intent.putExtra("position", position + 1);
        startActivity(intent);

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
//            Uri uri = data.getData();
//            // Do something with the Uri
//            System.out.println("=================================="+uri+"=================================");
//            Log.e("STR", String.valueOf(uri));
//            messageShowB.setImageUri(uri);
//        }
//    }
}