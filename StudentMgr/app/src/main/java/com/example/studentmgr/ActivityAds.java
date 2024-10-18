package com.example.studentmgr;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityAds extends AppCompatActivity {
    private int counter = 5;
    private TextView countdownText;
    private Button skipButton;
    private Handler handler = new Handler();
    private static boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);

        countdownText = findViewById(R.id.countdownText);
        skipButton = findViewById(R.id.skipButton);

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityAds.this, ActivityMain.class);
                flag = true;
                startActivity(intent);
                finish();
            }
        });

        startCountdown();
    }

    private void startCountdown() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                counter--;
                countdownText.setText("广告将在 " + counter + " 秒后关闭");
                if (counter > 0) {
                    handler.postDelayed(this, 1000);
                } else {
                    if(!flag){
                        Intent intent = new Intent(ActivityAds.this, ActivityMain.class);
                        startActivity(intent);
                    }
                }
            }
        }, 1000);
    }
}
