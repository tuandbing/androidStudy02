package com.example.chapter08;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

/* 案例1
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main01);

        TextView password = (TextView) findViewById(R.id.wang_mima);//获取布局文件中的忘记密码
        password.setOnClickListener(new View.OnClickListener() {  //为忘记密码添加单击监听事件
            @Override
            public void onClick(View v) {
                //创建Intent对象
                Intent intent = new Intent(MainActivity.this, PasswordActivity.class);
                startActivity(intent); //启动Activity
            }
        });
    }
}*/
/* 案例2保存收货地址
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main02);
        Button btn = (Button) findViewById(R.id.btn);        //获取保存按钮
        btn.setOnClickListener(new View.OnClickListener() {  //为按钮添加单击监听事件
            @Override
            public void onClick(View v) {
                //获取输入的所在地区
                String site1 = ((EditText) findViewById(R.id.et_site1)).getText().toString();
                //获取输入的所在街道
                String site2 = ((EditText) findViewById(R.id.et_site2)).getText().toString();
                //获取输入的详细地址
                String site3 = ((EditText) findViewById(R.id.et_site3)).getText().toString();
                //获取输入的用户信息
                String name = ((EditText) findViewById(R.id.et_name)).getText().toString();
                //获取输入的手机号码
                String phone = ((EditText) findViewById(R.id.et_phone)).getText().toString();
                //获取输入的邮箱
                String email= ((EditText) findViewById(R.id.et_email)).getText().toString();
                if (!"".equals(site1) && !"".equals(site2) && !"".equals(site3)&&
                        !"".equals(name) && !"".equals(phone) &&!"".equals(email) ) {
                    //将输入的信息保存到Bundle中，通过Intent传递到另一个Activity中显示出来
                    Intent intent = new Intent(MainActivity.this, AddressActivity.class);
                    //创建并实例化一个Bundle对象
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("name", name);    //保存姓名
                    bundle.putCharSequence("phone", phone);  //保存手机号码
                    bundle.putCharSequence("site1", site1);  //保存所在地区信息
                    bundle.putCharSequence("site2", site2);  //保存所在街道信息
                    bundle.putCharSequence("site3", site3);  //保存详细地址信息
                    intent.putExtras(bundle);	         //将Bundle对象添加到Intent对象中
                    startActivity(intent);                    //启动Activity
                }else {
                    Toast.makeText(MainActivity.this,
                            "请将收货地址填写完整！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}*/

/*案例3选择头像功能
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main03);
        Button button= (Button) findViewById(R.id.btn);	        //获取选择头像按钮
        button.setOnClickListener(new View.OnClickListener() {  //为按钮添加单击事件
            @Override
            public void onClick(View v) {
                //创建Intent对象
                Intent intent=new Intent(MainActivity.this,HeadActivity.class);
                startActivityForResult(intent, 0x11);            //启动intent对应的Activity
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0x11 && resultCode==0x11){  //判断是否为待处理的结果
            Bundle bundle=data.getExtras();          //获取传递的数据包
            int imageId=bundle.getInt("imageId");   //获取选择的头像ID
            //获取布局文件中添加的ImageView组件
            ImageView iv=(ImageView)findViewById(R.id.imageView);
            iv.setImageResource(imageId);           //显示选择的头像
        }
    }


}*/


/*案例4微信切换界面
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main04);
        //获取布局文件的第一个导航图片
        ImageView imageView1 = (ImageView) findViewById(R.id.image1);
        //获取布局文件的第二个导航图片
        ImageView imageView2 = (ImageView) findViewById(R.id.image2);
        //获取布局文件的第三个导航图片
        ImageView imageView3 = (ImageView) findViewById(R.id.image3);
        //获取布局文件的第四个导航图片
        ImageView imageView4 = (ImageView) findViewById(R.id.image4);
        imageView1.setOnClickListener(l);         //为第一个导航图片添加单击事件监听器
        imageView2.setOnClickListener(l);         //为第二个导航图片添加单击事件监听器
        imageView3.setOnClickListener(l);         //为第三个导航图片添加单击事件监听器
        imageView4.setOnClickListener(l);         //为第四个导航图片添加单击事件监听器
    }


    //创建单击事件监听器
    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();       // 获取Fragment
            FragmentTransaction ft = fm.beginTransaction();  // 开启一个事务
            Fragment f = null;                               //为Fragment初始化

            if(v.getId() == R.id.image1){
                f = new WeChat_Fragment();
            }else if(v.getId() == R.id.image2){
                f = new Message_Fragment();
            }else if ((v.getId() == R.id.image3)){
                f = new Find_Fragment();
            }else if (v.getId() == R.id.image4){
                f = new Me_Fragment();
            }

            ft.replace(R.id.fragment, f);         //替换Fragment
            ft.commit();                          //提交事务
        }
    };
}*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main03);
        Button button= (Button) findViewById(R.id.btn);	        //获取选择头像按钮
        button.setOnClickListener(new View.OnClickListener() {  //为按钮添加单击事件
            @Override
            public void onClick(View v) {
                //创建Intent对象
                Intent intent=new Intent(MainActivity.this,HeadActivity.class);
                startActivityForResult(intent, 0x11);            //启动intent对应的Activity
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0x11 && resultCode==0x11){  //判断是否为待处理的结果
            Bundle bundle=data.getExtras();          //获取传递的数据包
            int imageId=bundle.getInt("imageId");   //获取选择的头像ID
            //获取布局文件中添加的ImageView组件
            ImageView iv=(ImageView)findViewById(R.id.imageView);
            iv.setImageResource(imageId);           //显示选择的头像
        }
    }
}
