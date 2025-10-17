package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;


public class HomeActivity extends AppCompatActivity {

    private TextView postUser, postContent,create_post;
    private ImageView postImage,profile,search,message,more,create_story;
    private BottomNavigationView bottomNavigationView;
    private FrameLayout maxstory;

    private LinearLayout comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        comments = findViewById(R.id.comments);
        maxstory = findViewById(R.id.maxstory);
        create_story = findViewById(R.id.create_story);
        create_post = findViewById(R.id.create_post);
        message = findViewById(R.id.message);
        more = findViewById(R.id.more);
        profile = findViewById(R.id.profile);
        search = findViewById(R.id.search);
        postUser = findViewById(R.id.post_user);
        postContent = findViewById(R.id.post_content);
        postImage = findViewById(R.id.post_image);
        bottomNavigationView = findViewById(R.id.bottomNavigation);


        postUser.setText("Nguyễn thị C");
        postContent.setText("Buổi chiều vui vẻ!");
        postImage.setImageResource(R.drawable.img4);


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




        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(HomeActivity.this, v);
                popupMenu.getMenuInflater().inflate(R.menu.post_options_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();

                        if (id == R.id.action_post) {
                            Intent intent = new Intent(HomeActivity.this, CreatePostActivity.class);
                            startActivity(intent);
                            return true;
                        } else if (id == R.id.action_news) {
                            Intent intent = new Intent(HomeActivity.this, CreateStoryActivity.class);
                            startActivity(intent);
                            return true;
                        } else if (id == R.id.action_film) {
                            Intent intent = new Intent(HomeActivity.this, CreateFilmActivity.class);
                            startActivity(intent);
                            return true;
                        } else if (id == R.id.action_live) {
                            Intent intent = new Intent(HomeActivity.this, LiveStreamActivity.class);
                            startActivity(intent);
                            return true;
                        } else if (id == R.id.action_note) {
                            Intent intent = new Intent(HomeActivity.this, CreateNoteActivity.class);
                            startActivity(intent);
                            return true;
                        } else if (id == R.id.action_ai) {
                            Intent intent = new Intent(HomeActivity.this, GeminiActivity.class);
                            startActivity(intent);
                            return true;
                        }
                        return false;

                    }
                });

                popupMenu.show();
            }
        });

        create_story.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CreateStoryActivity.class);
            startActivity(intent);
        });
        create_post.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CreatePostActivity.class);
            startActivity(intent);
        });


        maxstory.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, StoryActivity.class);
            startActivity(intent);
        });
        comments.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CommentActivity.class);
            startActivity(intent);
        });

    }
}



