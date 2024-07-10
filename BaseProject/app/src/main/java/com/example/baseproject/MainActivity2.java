package com.example.baseproject;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        // 在java代码中实现视图的宽高设置
        // 获取文本视图
        TextView textView = findViewById(R.id.tv2);

        // 获取textView布局参数
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();

        // 修改宽度
        layoutParams.width = MainActivity2.dip2px(this, 300);

        textView.setBackgroundColor(Color.GREEN);

        textView.setText("hello world");

        textView.setLayoutParams(layoutParams);


    }

    public static int dip2px(Context context, float dpValue){

        // 获取当前手机的像素密度
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);	// 四舍五入取整

    }

}