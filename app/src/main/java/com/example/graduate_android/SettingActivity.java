package com.example.graduate_android;

import static com.example.graduate_android.LoginActivity.firebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.graduate_android.databinding.ActivitySettingBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySettingBinding binding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonSet.setOnClickListener(this);

//        FirebaseDynamicLinks.getInstance().getDynamicLink(getIntent()).addOnSuccessListener(this, new OnSuccessListener<PendingDynamicLinkData>() {
//            @Override
//            public void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
//                Log.i("SettingActivity", "we have a dynamic link");
//
//                Uri deepLink = null;
//                if (pendingDynamicLinkData != null) {
//                    deepLink = pendingDynamicLinkData.getLink();
//                }
//
//                if (deepLink != null) {
//                    Log.i("Setting", "Here's the deep Link URL:\n" + deepLink.toString());
//
//                    String curPage = deepLink.getQueryParameter("curPage");
//                    int i = Integer.parseInt(curPage);
//
//                }
//            }
//        }).addOnFailureListener(this, new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Log.w("SettingActivity", "getDynamicLink:onFailure", e);
//            }
//        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSet:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(this, LoginActivity.class));
                SharedPreferences preferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();
                break;
        }
    }
}