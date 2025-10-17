package com.example.facebook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CommentActivity extends AppCompatActivity {

    private EditText commentInput;
    private ImageView sendComment;
    private LinearLayout commentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        commentInput = findViewById(R.id.comment);
        sendComment = findViewById(R.id.send_comment);
        commentList = findViewById(R.id.comment_list);

        sendComment.setOnClickListener(v -> {
            String text = commentInput.getText().toString().trim();

            if (text.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập bình luận!", Toast.LENGTH_SHORT).show();
            } else {

                Toast.makeText(this, "Đã comment: " + text, Toast.LENGTH_SHORT).show();


                addComment("Bạn", text);


                commentInput.setText("");
            }
        });
    }


    private void addComment(String userName, String content) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View commentView = inflater.inflate(R.layout.item_comment, commentList, false);

        TextView userText = commentView.findViewById(R.id.comment_user);
        TextView contentText = commentView.findViewById(R.id.comment_content);

        userText.setText(userName);
        contentText.setText(content);

        commentList.addView(commentView, 0);
    }
}
