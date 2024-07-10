package com.example.anim;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    // 判断当前动画是启动还是停止的标志
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 获取整个视图(布局)
        RelativeLayout relativeLayout = findViewById(R.id.rv);

        // 获取背景
        AnimationDrawable background = (AnimationDrawable) relativeLayout.getBackground();

        // 设置点击事件
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag){

                    // 动画停止
                    background.stop();
                    flag = false;
                }else{

                    // 动画启动
                    background.start();
                    flag = true;
                }
            }
        });

    }
}