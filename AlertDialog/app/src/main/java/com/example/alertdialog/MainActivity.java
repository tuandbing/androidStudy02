package com.example.alertdialog;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "leo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }

    public void leoClick(View view){

        @SuppressLint("InflateParams") View dialogView = getLayoutInflater().inflate(R.layout.dialog_view, null);

        // 构建dialog的各种参数
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // create和show方法的位置不能变, 其它的都可以换顺序
        builder.setIcon(R.mipmap.ic_launcher)  // 添加icon
                .setTitle("对话框")   // 添加标题
                .setMessage("hello world")   // 添加信息
                .setView(dialogView)    // 设置自定义布局
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.e(TAG, "点击确认");
                    }
                })  // 确定按钮
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.e(TAG, "点击取消");
                    }
                })  // 取消按钮
                .setNeutralButton("中间", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.e(TAG, "点击中间");
                    }
                })  // 中间按钮
                .create()   // 创建dialog
                .show();    // 显示对话框

    }

}