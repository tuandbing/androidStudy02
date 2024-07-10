package com.example.layoutparams;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
        // setContentView(R.layout.activity_main);

        // 新建一个布局
        LinearLayout linearLayout = new LinearLayout(this);

        // 新建宽高的配置
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        // 将宽高设置到布局中
        //linearLayout.setLayoutParams(layoutParams);

        // 新建控件
        TextView textView = new TextView(this);
        textView.setText("我是文本内容");
        textView.setBackgroundColor(0xffff0000);

        // 配置控件, 默认单位为px
        LinearLayout.LayoutParams textLayoutParams = new LinearLayout.LayoutParams(300, 300);

/*        textView.setLayoutParams(textLayoutParams);
        linearLayout.addView(textView);*/

        // 一步到位
        linearLayout.addView(textView, textLayoutParams);

        setContentView(linearLayout, layoutParams);

    }
}