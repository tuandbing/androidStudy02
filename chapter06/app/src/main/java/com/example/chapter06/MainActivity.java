package com.example.chapter06;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


// 案例1，逻辑推理题
/*public class MainActivity extends AppCompatActivity {

    Button bt;                                              //定义提交按钮
    RadioGroup rg;                                         //定义单选按钮组
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main01);
        EdgeToEdge.enable(this);
        bt = (Button) findViewById(R.id.bt);                //通过ID获取布局中的提交按钮
        rg = (RadioGroup) findViewById(R.id.rg);            //通过ID获取布局中的单选按钮组
        bt.setOnClickListener(new View.OnClickListener() {  //为提交按钮设置单击事件监听器
            @Override
            public void onClick(View v) {
                for (int i = 0; i < rg.getChildCount(); i++) {
                    //根据索引值获取单选按钮
                    RadioButton radioButton = (RadioButton) rg.getChildAt(i);
                    if (radioButton.isChecked()) {                          //判断单选按钮是否被选中
                        if (radioButton.getText().equals("B:100")) {      //判断答案是否正确
                            Toast.makeText(MainActivity.this,
                                    "回答正确", Toast.LENGTH_LONG).show();
                        } else {
                            //错误消息提示框
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("回答错误，下面请看解析：当张山换完零钱之后，" +
                                    "给了顾客75还有价值25元的商品，自己还剩下了25元。这时，" +
                                    "李石来找张山要钱，张山把自己剩下的相当于是李石的25元给了李石，" +
                                    "另外自己掏了75元。这样张山赔了一个25元的商品和75元的人民币，" +
                                    "总共价值100元。");
                            builder.setPositiveButton("确定", null).show();  //单击确定消失
                        }
                        break;                                           //跳出for循环
                    }
                }
            }
        });
    }

}*/


// 案例2，模拟12306车票预订
/*public class MainActivity extends AppCompatActivity {

    CheckBox checkBox1, checkBox2;    //定义复选框
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main02);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        checkBox1 = (CheckBox) findViewById(R.id.checkbox1);    //通过ID获取布局复选框1
        checkBox2 = (CheckBox) findViewById(R.id.checkbox2);    //通过ID获取布局复选框2
    }

    //查询按钮的单击事件
    public void onClick(View view) {
        String checked = "";                               //保存选中的值
        if (checkBox1.isChecked()) {                       //当第一个复选框被选中
            checked += checkBox1.getText().toString();  //输出第一个复选框内信息
        }
        if (checkBox2.isChecked()) {                      //当第二个复选框被选中
            checked += checkBox2.getText().toString();  //输出第二个复选框内信息
        }
        if (checked.equals("")){
            Toast.makeText(this, "请选择复选框内容！", Toast.LENGTH_SHORT).show();
        }else {
            //显示被选中复选框对应的信息
            Toast.makeText(MainActivity.this, checked, Toast.LENGTH_LONG).show();
        }
    }


}*/

// 案例3，模拟开心消消乐启动界面
/*public class MainActivity extends AppCompatActivity {

    private ProgressBar horizonP;                //水平进度条
    private int mProgressStatus = 0;            //完成进度
    private Handler mHandler;                    //声明一个用于处理消息的Handler类的对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main03);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //设置全屏显示
        horizonP = (ProgressBar) findViewById(R.id.progressBar1);    //获取水平进度条
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x111) {
                    horizonP.setProgress(mProgressStatus);            //更新进度
                } else {
                    Toast.makeText(MainActivity.this,
                            "耗时操作已经完成", Toast.LENGTH_SHORT).show();
                    horizonP.setVisibility(View.GONE);            //设置进度条不显示，并且不占用空间
                }
            }
        };

        new Thread(new Runnable() {
            public void run() {
                while (true) {                      //循环获取耗时操作完成的百分比，直到耗时操作结束
                    mProgressStatus = doWork();        	//获取耗时操作完成的百分比
                    Message m = new Message();    		//创建并实例化一个消息对象
                    if (mProgressStatus < 100) {      	//当完成进度不到100时表示耗时任务未完成
                        m.what = 0x111;                	//设置代表耗时操作未完成的消息代码
                        mHandler.sendMessage(m);      	//发送信息
                    } else {                      			//当完成进度到达100时表示耗时操作完成
                        m.what = 0x110;            		//设置代表耗时操作已经完成的消息代码
                        mHandler.sendMessage(m);       	//发送消息
                        break;            				 //退出循环
                    }
                }
            }
            //模拟一个耗时操作
            private int doWork() {
                mProgressStatus += Math.random() * 10;    //改变完成进度
                try {
                    Thread.sleep(200);               		//线程休眠200毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();               	//输出异常信息
                }
                return mProgressStatus;                 	//返回新的进度
            }
        }).start();                                		//开启一个线程

    }

}*/


// 案例4，可以设置屏幕亮度的拖动条
/*public class MainActivity extends AppCompatActivity {

    private BrightnessUtils utils;       //屏幕亮度工具类
    private SeekBar seekBar;             //拖动条

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main04);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {   //判断系统版本是否大于等于6.0
            if (!Settings.System.canWrite(this)) {             //判断系统权限设置
                //跳转系统权限界面
                Intent intent = new Intent
                        (android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData(Uri.parse("package:" + getPackageName()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }

        utils =new BrightnessUtils();   //初始化工具类
        seekBar = (SeekBar) findViewById(R.id.set_light);   //获取拖动条控件
        seekBar.setProgress(utils.getScreenBrightness(this)); //获取当前屏幕亮度并同步拖动条
        seekBar.setMax(225);  //设置拖动条的最大长值为225
        */
/**
         * 对进度条进行监听
         * *//*


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {  //改变中的监听
                utils.setSystemBrightness(MainActivity.this,i);  //将当前的进度条的值传给系统
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {  //开始改变时监听
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {   //结束改变时监听
            }
        });
    }

}*/

// 案例5，模拟淘宝评价界面
public class MainActivity extends AppCompatActivity {

    private RatingBar ratingbar;   //星级评分条
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main05);
        ratingbar = (RatingBar) findViewById(R.id.ratingBar1);  //获取星级评分条
        Button button=(Button)findViewById(R.id.btn);           //获取“提交”按钮
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = ratingbar.getProgress();            //获取进度
                float rating = ratingbar.getRating();            //获取等级
                float step = ratingbar.getStepSize();            //获取每次最少要改变多少个星级
                Log.i("星级评分条","step="+step+" result="+result+" rating="+rating);
                Toast.makeText(MainActivity.this,
                        "你得到了" + rating + "颗星", Toast.LENGTH_SHORT).show();
            }
        });

    }


}