package com.example.graduate_android;

import static java.security.AccessController.getContext;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.graduate_android.adpater.BudgetAdapter;
import com.example.graduate_android.bean.Budget;
import com.example.graduate_android.component.CustomMessageShow;
import com.example.graduate_android.databinding.ActivityTestBinding;
import com.example.graduate_android.utils.BaseActivity;

import java.security.AccessControlContext;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testActivity extends BaseActivity {


    private TextView textView;
    private ListView lv_planet;
    private Map<String, List<Budget>> budgetLists;
    private List<Budget> budgetList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityTestBinding binding = ActivityTestBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        String email = "1879847326@qq.com";
        String password = "12345678";
        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("email", email);
                Log.e("email", email);
                Log.e("email", email);
                RequestQueue mQueue = Volley.newRequestQueue(getApplication());
                String url = "http://localhost:8080/user/login";

                StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("TAG", response);
                                // 处理响应
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // 处理错误
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        params.put("email", email);
                        params.put("password", password);
                        return params;
                    }
                };

                mQueue.add(postRequest);
            }
        });


    }
}
////        1、键盘监听测试
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                onClickButton(v);
//                showDatePickerDialog();
//            }
//        });
//    }

//    private void showDatePickerDialog() {
//        // 获取当前日期
//        Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//
//        // 创建 DatePickerDialog 对象
//        DatePickerDialog datePickerDialog = new DatePickerDialog(getApplicationContext(),
//                new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        // 选择日期后的回调函数
//                        String date = year + "-" + (month + 1) + "-" + dayOfMonth;
//                        Toast.makeText(getApplicationContext(), "你选择的日期是：" + date, Toast.LENGTH_SHORT).show();
//                    }
//                }, year, month, day);
//
//        // 显示 DatePickerDialog
//        datePickerDialog.show();
//    }

////      2、BudgetAdapter测试,确定绑定布局，获取初始化数据，使用setAdapter实现数据和视图的绑定
//        ListView listView = findViewById(R.id.listView);
//        budgetLists = Budget.getDefaultLists();
//        budgetList = budgetLists.get("list3");
//        BudgetAdapter budgetAdapter = new BudgetAdapter(this, budgetList);
//        listView.setAdapter(budgetAdapter);
//        listView.setOnItemClickListener(this);


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
//
//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//        super.onPointerCaptureChanged(hasCapture);
//    }


//        // 创建一个 Dialog 对象
//        Dialog dialog = new Dialog(context);
//        dialog.setContentView(R.layout.dialog_account);
//        dialog.setTitle("选择数据");
//
//        // 在 Dialog 中创建一个 Spinner 对象
//        Spinner spinner = dialog.findViewById(R.id.spinner);
//        alist = getDefaultDialogBase();
//        DialogBaseAdapter dialogBaseAdapter = new DialogBaseAdapter(context, alist);
//        spinner.setAdapter(dialogBaseAdapter);
//        spinner.setSelection(0);
//        spinner.setOnItemSelectedListener(this);
//
//        dialog.show();