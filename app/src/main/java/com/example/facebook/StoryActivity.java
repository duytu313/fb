package com.example.facebook;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class StoryActivity extends AppCompatActivity {

    ProgressBar storyProgress;
    ImageView btnClose;

    private Handler handler = new Handler();
    private int progressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);


        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );

        storyProgress = findViewById(R.id.storyProgress);
        btnClose = findViewById(R.id.btn_close);

        btnClose.setOnClickListener(v -> finish());

        startStoryTimer();
    }

    private void startStoryTimer() {
        progressStatus = 0;
        new Thread(() -> {
            while (progressStatus < 100) {
                progressStatus += 1;
                handler.post(() -> storyProgress.setProgress(progressStatus));

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            finish();
        }).start();
    }
}
