package com.example.progress;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button btn;
    private ProgressBar progressBar02;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.pb);
        progressBar02 = findViewById(R.id.pb02);
        btn = findViewById(R.id.btn);


    }

    public void leoClick(View view){

        // 如果是隐藏的, 则显示出来
        /*GONE: 隐藏
        VISIBLE: 显示*/
        if(progressBar.getVisibility() == View.GONE){
            progressBar.setVisibility(View.VISIBLE);
            btn.setText("隐藏进度条");
        }else{
            progressBar.setVisibility(View.GONE);
            btn.setText("显示进度条");
        }

    }

    public void load(View view){
        int progress = progressBar02.getProgress();
        progress+=10;
        progressBar02.setProgress(progress);
    }

}