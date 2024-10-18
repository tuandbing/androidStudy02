package com.example.studentmgr;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

public class Utils {
    public static void showCustomToast(Context context, String message) {
        Toast toast = new Toast(context);
        View customView = LayoutInflater.from(context).inflate(R.layout.custom_toast, null);
        TextView textView = customView.findViewById(R.id.toastText);
        ImageView imageView = customView.findViewById(R.id.toastIcon);

        textView.setText(message);
        imageView.setImageResource(R.drawable.baseline_search_24); // 设置你的图标

        toast.setView(customView);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
}

