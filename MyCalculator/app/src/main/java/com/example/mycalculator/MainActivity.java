package com.example.mycalculator;

import android.os.Bundle;

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
        setContentView(R.layout.activity_calculator);

        ClickListener listener = new ClickListener(findViewById(R.id.tv_result), this);

        findViewById(R.id.btn_cancel).setOnClickListener(listener); // “取消”按钮
        findViewById(R.id.btn_divide).setOnClickListener(listener); // “除法”按钮
        findViewById(R.id.btn_multiply).setOnClickListener(listener); // “乘法”按钮
        findViewById(R.id.btn_clear).setOnClickListener(listener); // “清除”按钮
        findViewById(R.id.btn_seven).setOnClickListener(listener); // 数字7
        findViewById(R.id.btn_eight).setOnClickListener(listener); // 数字8
        findViewById(R.id.btn_nine).setOnClickListener(listener); // 数字9
        findViewById(R.id.btn_plus).setOnClickListener(listener); // “加法”按钮
        findViewById(R.id.btn_four).setOnClickListener(listener); // 数字4
        findViewById(R.id.btn_five).setOnClickListener(listener); // 数字5
        findViewById(R.id.btn_six).setOnClickListener(listener); // 数字6
        findViewById(R.id.btn_minus).setOnClickListener(listener); // “减法”按钮
        findViewById(R.id.btn_one).setOnClickListener(listener); // 数字1
        findViewById(R.id.btn_two).setOnClickListener(listener); // 数字2
        findViewById(R.id.btn_three).setOnClickListener(listener); // 数字3
        findViewById(R.id.btn_reciprocal).setOnClickListener(listener); // 求倒数按钮
        findViewById(R.id.btn_zero).setOnClickListener(listener); // 数字0
        findViewById(R.id.btn_dot).setOnClickListener(listener); // “小数点”按钮
        findViewById(R.id.btn_equal).setOnClickListener(listener); // “等号”按钮
        findViewById(R.id.ib_sqrt).setOnClickListener(listener); // “开平方”按钮
    }
}