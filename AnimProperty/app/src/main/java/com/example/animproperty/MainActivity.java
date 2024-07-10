package com.example.animproperty;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 创建一个属性动画
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);

        // 设置周期
        valueAnimator.setDuration(2000);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {

                // 在此处可以对动画进行处理
                // 获取当前值
                float value = (float) valueAnimator.getAnimatedValue();

                Log.e("leo", "onAnimationUpdate: " + value);

            }
        });

        // 启动动画
        valueAnimator.start();


        // 对象动画
        // 获取控件
        TextView textView = findViewById(R.id.tv);

        // 创建对象动画
        // 参数: 动画给定的对象-要修改的属性(名称)-起始值-最终值
        ObjectAnimator alpha = ObjectAnimator.ofFloat(textView, "alpha", 0f, 1f);
        alpha.setDuration(3000);
        alpha.start();

        // 添加监听器
        alpha.addListener(new Animator.AnimatorListener() {

            // 动画开始的时候调用
            @Override
            public void onAnimationStart(@NonNull Animator animator) {

            }

            // 动画结束的时候调用
            @Override
            public void onAnimationEnd(@NonNull Animator animator) {

            }

            // 动画被取消的时候调用
            @Override
            public void onAnimationCancel(@NonNull Animator animator) {

            }

            // 动画重复执行的时候调用
            @Override
            public void onAnimationRepeat(@NonNull Animator animator) {

            }
        });

        // 用这个(AnimatorListenerAdapter)适配的方法可以只需要实现其中的部分监听方法
        alpha.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });

    }
}