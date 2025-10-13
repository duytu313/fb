package com.example.facebook;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail,etPassword;
    private Button btnLogin,btnCreateAccount;
    private TextView tvForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);
        tvForgot = findViewById(R.id.tvForgot);

       btnLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String email = etEmail.getText().toString().trim();
               String passwword = etPassword.getText().toString().trim();

               if(TextUtils.isEmpty(email) || TextUtils.isEmpty(passwword)){
                   Toast.makeText(MainActivity.this,"Vui long nhap day du thong tin!",Toast.LENGTH_SHORT).show();
               }else if(email.equals("admin@gmail.com") && passwword.equals("123456")) {
                   Toast.makeText(MainActivity.this,"Dang nhap thanh cong!",Toast.LENGTH_SHORT).show();

                   Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                   startActivity(intent);
                   finish();
               }else{
                   Toast.makeText(MainActivity.this,"Email hoac mat khau khong dung",Toast.LENGTH_SHORT).show();
               }

           }
       });

       tvForgot.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
               startActivity(intent);
           }
       });
       btnCreateAccount.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
               startActivity(intent);
           }
       });
    }
}