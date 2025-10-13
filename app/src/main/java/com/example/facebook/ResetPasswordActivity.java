package com.example.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText etNewPassword, etConfirmPassword;
    private Button btnResetPassword, btnBackToLogin;

    private String userIdentifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        Intent intent = getIntent();
        userIdentifier = intent.getStringExtra("userIdentifier");

        etNewPassword = findViewById(R.id.etNewPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnResetPassword = findViewById(R.id.btnResetPassword);
        btnBackToLogin = findViewById(R.id.btnBackToLogin);

        btnResetPassword.setOnClickListener(v -> {
            String newPass = etNewPassword.getText().toString().trim();
            String confirmPass = etConfirmPassword.getText().toString().trim();

            if (newPass.isEmpty() || confirmPass.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!newPass.equals(confirmPass)) {
                Toast.makeText(this, "Mật khẩu xác nhận không khớp", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Mật khẩu của " + userIdentifier + " đã được đặt lại thành công!", Toast.LENGTH_LONG).show();

            Intent backIntent = new Intent(ResetPasswordActivity.this, MainActivity.class);
            startActivity(backIntent);
            finish();
        });
    }
}