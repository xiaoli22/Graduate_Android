package com.example.graduate_android;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.graduate_android.adpater.BudgetAdapter;
import com.example.graduate_android.bean.Budget;
import com.example.graduate_android.component.CustomMessageShow;
import com.example.graduate_android.utils.BaseActivity;

import java.util.List;
import java.util.Map;

public class testActivity extends BaseActivity  {


    private TextView textView;
    private ListView lv_planet;
    private Map<String, List<Budget>> budgetLists;
    private List<Budget> budgetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textView = findViewById(R.id.test);




//        1、键盘监听测试
//        textView.setOnClickListener(this);
//
////      2、BudgetAdapter测试,确定绑定布局，获取初始化数据，使用setAdapter实现数据和视图的绑定
//        ListView listView = findViewById(R.id.listView);
//        budgetLists = Budget.getDefaultLists();
//        budgetList = budgetLists.get("list3");
//        BudgetAdapter budgetAdapter = new BudgetAdapter(this, budgetList);
//        listView.setAdapter(budgetAdapter);
//        listView.setOnItemClickListener(this);


    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(this, "点击了是" + budgetList.get(position).getType(), Toast.LENGTH_SHORT).show();
//    }
//
//
//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//        super.onPointerCaptureChanged(hasCapture);
//    }
//
//    @Override
//    public void onClick(View v) {
//        onClickButton((TextView) v);
//    }


}


//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(this, "你选择的是" + starArray[position], Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }

//    @Override
//    public void onClick(View v) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(testActivity.this);
//        final EditText edit = new EditText(testActivity.this);
//        edit.setInputType(InputType.TYPE_CLASS_NUMBER);
//        try {
//            int num = Integer.parseInt(textView.getText().toString());
//            edit.setText(textView.getText().toString());
//        } catch (NumberFormatException e) {
//
//        }
//        builder.setView(edit);
//        builder.setTitle("请输入预算")
//                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        String text = edit.getText().toString();
//                        textView.setText(text);
//                    }
//                })
//                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        // 用户点击取消按钮时执行的代码
//                        dialog.cancel();
//                    }
//                });
//        AlertDialog dialog = builder.create();
//        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
//            @Override
//            public void onShow(DialogInterface dialogInterface) {
//                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                inputMethodManager.showSoftInput(edit, InputMethodManager.SHOW_IMPLICIT);
//            }
//        });
//
//        dialog.show();
//    }