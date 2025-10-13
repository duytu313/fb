package com.example.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity{
    private EditText etEmailOrPhone;
    private Button btnFindAccount, btnBackToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        etEmailOrPhone = findViewById(R.id.etEmailOrPhone);
        btnFindAccount = findViewById(R.id.btnFindAccount);
        btnBackToLogin = findViewById(R.id.btnBackToLogin);

        btnFindAccount.setOnClickListener(v -> {
            String input = etEmailOrPhone.getText().toString().trim();

            if (input.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập email hoặc số điện thoại", Toast.LENGTH_SHORT).show();
                return;
            }
            if (input.equalsIgnoreCase("test@gmail.com") || input.equals("0123456789")) {
                Toast.makeText(this, "Tài khoản đã được tìm thấy!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ForgotPasswordActivity.this, ResetPasswordActivity.class);
                intent.putExtra("userIdentifier", input);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Không tìm thấy tài khoản khớp với thông tin bạn nhập", Toast.LENGTH_SHORT).show();
            }
        });

        btnBackToLogin.setOnClickListener(v -> {
            Intent intent = new Intent(ForgotPasswordActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });


        }
}
