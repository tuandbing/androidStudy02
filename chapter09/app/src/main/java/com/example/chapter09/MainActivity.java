package com.example.chapter09;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

/*  案例一
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main01);
        //获取电话图片按钮
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton_phone);
        //获取短信图片按钮
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton_sms);

        imageButton.setOnClickListener(listener);   //为电话图片按钮设置单击事件
        imageButton1.setOnClickListener(listener);  //为短信图片按钮设置单击事件

    }
    //创建监听事件对象
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(); 			//创建Intent对象
            if(v.getId() == R.id.imageButton_phone){
                intent.setAction(intent.ACTION_DIAL); 			//调用拨号面板
                intent.setData(Uri.parse("tel:043184978981")); 	//设置要拨打的号码
                startActivity(intent); 							//启动Activity
            }else if (v.getId() == R.id.imageButton_sms){
                intent.setAction(intent.ACTION_SENDTO); 			//调用发送短信息面板
                intent.setData(Uri.parse("smsto:5554")); 			//设置要发送的号码
                intent.putExtra("sms_body", "Welcome to Android!"); //设置要发送的信息内容
                startActivity(intent);
            }
        }
    };
*/

//    案例二

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main02);
        Button button= (Button) findViewById(R.id.btn); //获取按钮组件
        //为按钮创建单击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();             //创建Intent对象
                intent.setAction(intent.ACTION_VIEW);   //为Intent设置动作
                startActivity(intent);                  //启动Activity
            }
        });
    }


}
