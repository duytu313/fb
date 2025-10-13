package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private TextView postUser, postContent;
    private ImageView postImage,profile,search,message;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        message = findViewById(R.id.message);
        profile = findViewById(R.id.profile);
        search = findViewById(R.id.search);
        postUser = findViewById(R.id.post_user);
        postContent = findViewById(R.id.post_content);
        postImage = findViewById(R.id.post_image);
        bottomNavigationView = findViewById(R.id.bottomNavigation);


        postUser.setText("Nguyễn thị C");
        postContent.setText("Buổi chiều vui vẻ!");
        postImage.setImageResource(R.drawable.grandmother);


        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);
                return true;
            } else if (id == R.id.nav_friends) {
                Intent intent = new Intent(HomeActivity.this, FriendsActivity.class);
                startActivity(intent);
                return true;
            } else if (id == R.id.nav_watch) {
                Intent intent = new Intent(HomeActivity.this, VideoActivity.class);
                startActivity(intent);
                return true;
            } else if (id == R.id.nav_notifications) {
                Intent intent = new Intent(HomeActivity.this, NotificationsActivity.class);
                startActivity(intent);
                return true;
            } else if (id == R.id.nav_menu) {
                Intent intent = new Intent(HomeActivity.this, MenuActivity.class);
                startActivity(intent);
                return true;
            }

            return false;
        });

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);
        });



        search.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
            startActivity(intent);
        });


        message.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MessengersActivity.class);
            startActivity(intent);
        });

    }
}
