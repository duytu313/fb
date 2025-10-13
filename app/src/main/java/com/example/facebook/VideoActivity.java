package com.example.facebook;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {
    private ImageView imgSearch, imgUserProfile;
    private ImageView btnLike, btnComment, btnShare;
    private ImageView imgPostUser;
    private TextView tvPostUsername, tvFollow, tvPostContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reels);


        imgSearch = findViewById(R.id.imgSearch);
        imgUserProfile = findViewById(R.id.imgUser);


        btnLike = findViewById(R.id.btnLike);
        btnComment = findViewById(R.id.btnComment);
        btnShare = findViewById(R.id.btnShare);


        imgPostUser = findViewById(R.id.imgPostUser);
        tvPostUsername = findViewById(R.id.tvPostUsername);
        tvFollow = findViewById(R.id.tvFollow);
        tvPostContent = findViewById(R.id.tvPostContent);


        tvPostUsername.setText("Nguyen Van A");
        tvPostContent.setText("Đây là nội dung video...");

        btnLike.setOnClickListener(v -> Toast.makeText(VideoActivity.this, "Liked!", Toast.LENGTH_SHORT).show());
        btnComment.setOnClickListener(v -> Toast.makeText(VideoActivity.this, "Comment clicked!", Toast.LENGTH_SHORT).show());
        btnShare.setOnClickListener(v -> Toast.makeText(VideoActivity.this, "Share clicked!", Toast.LENGTH_SHORT).show());
    }
}
