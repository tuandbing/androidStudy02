package com.example.baseproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        getNextPage();
    }

    private Runnable mGoNext = new Runnable() {
        @Override
        public void run() {

            // 活动页面跳转, 从MainActivity跳转到MainActivity2
            // startActivity(new Intent(原页面.this, 目标页面.class))
            // 在不产生歧义的情况下, 可以直接使用this, 但是此处有歧义, 所以要带上MainActivity
            startActivity(new Intent(MainActivity.this, MainActivity2.class));

        }
    };

    // 跳转到下一个页面
    private void getNextPage(){

        TextView textView = findViewById(R.id.tv);
        textView.setText("3秒后跳转到第二个页面");

        // 延迟3秒后启动任务mGoNext
        // postDelayed(@NonNull Runnable r, long delayMillis)
        // Runnable 一个线程对象, 定义了线程的执行体, 此处也可以直接使用函数
        new Handler().postDelayed(mGoNext, 3000);
    }
}