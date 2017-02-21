package com.ahmadrosid.belajarokhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.text);

        OkHttpClient client = new OkHttpClient();
        String url = "https://publicobject.com/helloworld.txt";
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                final String textResponse = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override public void run() {
                        textView.setText(textResponse);
                    }
                });
            }
        });
    }
}
