package com.example.graduate_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.graduate_android.databinding.ActivityLoginBinding;
import com.example.graduate_android.databinding.ActivityMainBinding;
import com.example.graduate_android.databinding.DialogResetBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    static FirebaseAuth firebaseAuth;
    String email, password;
    private com.example.graduate_android.databinding.ActivityLoginBinding binding;
    Intent intent = new Intent();
    ProgressDialog progressDialog;
    private LoginDialogFragment dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        binding.buttonRegister.setOnClickListener(this);
        binding.buttonReset.setOnClickListener(this);
        setContentView(binding.getRoot());

        dialog = new LoginDialogFragment();


        progressDialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();
        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String email = binding.email.getText().toString();
                String password = binding.password.getText().toString();
//                progressDialog.show();


                if (!email.isEmpty() && !password.isEmpty()) {
                    progressDialog.show();
                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, task -> {
                        if (task.isSuccessful()) {
                            progressDialog.cancel();
                            intent.setClass(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                        } else {
                            progressDialog.cancel();
                            Toast.makeText(LoginActivity.this, "Authentication Failed.", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(LoginActivity.this, "Empty error", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null) {
            intent.setClass(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonRegister:
                intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonReset:
//                progressDialog.setTitle("Sending Mail");
                dialog.show(getSupportFragmentManager(), "LoginDialogFragment");
                break;
        }
    }

    public static class LoginDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = requireActivity().getLayoutInflater();

            //绑定自定义布局
            View dialogView = inflater.inflate(R.layout.dialog_reset, null);
            EditText edit = dialogView.findViewById(R.id.emailReset);

            //设置dialog按钮：confirm和cancel
            builder.setView(dialogView)
                    // Add action buttons
                    .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            //当用户点击confirm时，获取dialog中填写的邮箱
                            String email = edit.getText().toString();

                            if (email.isEmpty() || !isEmailValid(email)) {
                                Toast.makeText(getActivity(), "email is error", Toast.LENGTH_SHORT).show();
                            } else {
                                // sign in the user ...
                                sendEmail(getActivity(), email);

                            }

                        }

                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            LoginDialogFragment.this.getDialog().cancel();
                        }
                    });
            return builder.create();
        }
    }

    public static boolean isEmailValid(String email) {
        // 邮箱地址正则表达式
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailPattern);
    }

    public static void sendEmail(Context context, String email) {
        firebaseAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(context.getApplicationContext(), "Reset email sent", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                try {
                    Toast.makeText(context, "Error! Reset email is not sent" + e.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (Exception f) {
                    if (f == null) {
                        Toast.makeText(context, "登录失败" + f.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    Log.e("STR", "tai nan le");
                }
            }
        });
    }
}






