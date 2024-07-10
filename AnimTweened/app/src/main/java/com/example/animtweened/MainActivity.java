package com.example.animtweened;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

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

        // 获取控件
        ImageView imageView = findViewById(R.id.iv);

        // 设置点击事件
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 通过加载xml动画设置文件来创建一个Animation对象
                // Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha);

                //Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);

                //Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale);

                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate);

                // 启动
                imageView.startAnimation(animation);
            }
        });

    }
}