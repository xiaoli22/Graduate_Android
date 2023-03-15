package com.example.graduate_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.example.graduate_android.component.CustomReturn;

public class ServiceActivity extends AppCompatActivity {

    private TextView userBook;
    private CustomReturn returnS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        userBook = findViewById(R.id.userBook);
        returnS = findViewById(R.id.returnS);

        String myHtmlString = getString(R.string.userBook);
        userBook.setText(Html.fromHtml(myHtmlString));

        returnS.setOnClickListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}