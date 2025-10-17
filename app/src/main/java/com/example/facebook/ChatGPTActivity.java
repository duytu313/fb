package com.example.facebook;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChatGPTActivity extends AppCompatActivity {

    private static final String API_URL = "http://10.0.2.2:3000/chat";

    EditText inputText;
    Button btnSend;
    TextView outputText;

    OkHttpClient client = new OkHttpClient();
    MediaType JSON = MediaType.get("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatgpt);

        inputText = findViewById(R.id.inputText);
        btnSend = findViewById(R.id.btnSend);
        outputText = findViewById(R.id.outputText);

        btnSend.setOnClickListener(v -> {
            String prompt = inputText.getText().toString().trim();
            if (!prompt.isEmpty()) {
                new Thread(() -> callChatGPTAPI(prompt)).start();
            }
        });
    }

    private void callChatGPTAPI(String prompt) {
        try {

            JSONObject bodyJson = new JSONObject()
                    .put("prompt", prompt);

            RequestBody body = RequestBody.create(bodyJson.toString(), JSON);

            Request request = new Request.Builder()
                    .url(API_URL)
                    .post(body)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful() && response.body() != null) {
                    String jsonResponse = response.body().string();

                    JSONObject obj = new JSONObject(jsonResponse);
                    String reply = obj.optString("reply", "Không có phản hồi từ server");

                    runOnUiThread(() -> outputText.setText(reply.trim()));
                } else {
                    runOnUiThread(() -> outputText.setText("Lỗi API: " + response.message()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            runOnUiThread(() -> outputText.setText("Lỗi kết nối: " + e.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
            runOnUiThread(() -> outputText.setText("Lỗi xử lý: " + e.getMessage()));
        }
    }
}
