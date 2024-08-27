package com.example.chapter06;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import android.view.WindowManager;


public class BrightnessUtils {

    // 获取当前屏幕的亮度
    public static int getScreenBrightness(Context context) {
        int nowBrightnessValue = 0;
        //创建内容解析对象
        ContentResolver resolver = context.getContentResolver();
        try {
            //获取当前屏幕亮度
            nowBrightnessValue = Settings.System.getInt(resolver,
                    Settings.System.SCREEN_BRIGHTNESS);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return nowBrightnessValue;
    }

    /**设置系统亮度
      *程序退出之后亮度依旧有效
     **/

    public static void setSystemBrightness(Context context, int brightness) {
        // 异常处理
        if (brightness < 1) {
            brightness = 1;
        }
        // 异常处理
        if (brightness > 255) {
            brightness = 255;
        }
        saveBrightness(context, brightness);  //调用保存屏幕亮度的方法
    }

    // 保存亮度设置状态
    public static void saveBrightness(Context context, int brightness) {
        //获取设置系统屏幕亮度的uri
        Uri uri = Settings.System.getUriFor("screen_brightness");
        //保存修改后的屏幕亮度值
        Settings.System.putInt(context.getContentResolver(),
                "screen_brightness", brightness);
        //更新亮度值
        context.getContentResolver().notifyChange(uri, null);
    }
}
