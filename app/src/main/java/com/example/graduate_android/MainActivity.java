package com.example.graduate_android;

import static com.example.graduate_android.bean.Account.getDefaultAccount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.graduate_android.adpater.MainAdapter;
import com.example.graduate_android.bean.Account;
import com.example.graduate_android.databinding.ActivityMainBinding;
import com.example.graduate_android.databinding.FragmentBalanceBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = FragmentBalanceBinding.inflate(inflater, container, false);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Account> list = getDefaultAccount();
        MainAdapter adapter = new MainAdapter(this, list);
        binding.listViewMain.setAdapter(adapter);
        Log.e("TAG", "onCreate: " + "MainActivity正常运行");
        binding.listViewMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("TAG", "onCreate: " + "MainActivity正常运行2");
                Toast.makeText(MainActivity.this, "点击了第" + position + "个", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }
        });
    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//    }
}