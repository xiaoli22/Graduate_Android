package com.example.graduate_android.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.graduate_android.testActivity;

public class BaseActivity extends AppCompatActivity {

    private TextView textView;

    public void onClickButton(View view) {

        //创建dialog弹出窗口，edit为输入栏，输入类型为NUMBER
        AlertDialog.Builder builder = new AlertDialog.Builder(BaseActivity.this);
        final EditText edit = new EditText(BaseActivity.this);
        edit.setInputType(InputType.TYPE_CLASS_NUMBER);

        //如果监听的是TextView且其text为数字，取出赋值给输入框edit，
        if (view instanceof TextView) {
            textView = (TextView) view;
            try {
                double num = Double.parseDouble(textView.getText().toString());
//                int num = Integer.parseInt(textView.getText().toString());
                edit.setText(textView.getText().toString());
            } catch (NumberFormatException e) {

            }
        }


        builder.setView(edit);
        builder.setTitle("请输入预算")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String text = edit.getText().toString();
                        textView.setText(text);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // 用户点击取消按钮时执行的代码
                        dialog.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.showSoftInput(edit, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        dialog.show();

    }


}
