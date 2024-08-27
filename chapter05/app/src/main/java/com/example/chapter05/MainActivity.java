package com.example.chapter05;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}*/

// 下面是示例1(模拟福卡排行榜列表)的代码

/*public class MainActivity extends AppCompatActivity {

    //TextView控件Id
    private int[] text_Id = {
            R.id.text1, R.id.text2, R.id.text3,
            R.id.text4, R.id.text5, R.id.text6,
    };
    //控件需要显示的文字
    private String[] text_String = {
            "巴拉巴拉一大堆", "小科",
            "鞋盒宝宝", "赵颖", "2047", "流浪的风"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main01);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
        initView();      //初始化控件并显示排名人物
    }

    private void initView() {
        for (int i=0;i<text_Id.length;i++){
            TextView textView=findViewById(text_Id[i]);    //获取所有显示排名人物名称的控件
            textView.setText(text_String[i]);              //设置人物名称
        }
    }

}*/

// 下面是示例2(QQ空间写说说)的代码
/*public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main02);
    }
}*/

// 下面是示例3(微信登录按钮)的代码
/*public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main03);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    //登录按钮的单击事件
    public void onLogin(View view) {
        Toast.makeText(this,
                "您单击了登录按钮！", Toast.LENGTH_SHORT).show();
    }

}*/

// 下面是示例4(开心消消乐的"开始游戏"和"切换账号"按钮)的代码
/*public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main04);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);        //设置全屏显示
        ImageButton st = (ImageButton) findViewById(R.id.start); //通过ID获取布局开始游戏图片按钮
        //为开始游戏图片按钮添加单击事件监听器
        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "您单击了开始游戏按钮", Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton sw = (ImageButton) findViewById(R.id.switch1);   //通过ID获取布局切换账号图片按钮
        //为切换账号图片按钮添加单击事件监听器
        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"您单击了切换账号按钮",Toast.LENGTH_SHORT).show();
            }
        });

    }


}*/


// 下面是示例5(单击ImageView后更换显示图像)的代码
/*public class MainActivity extends AppCompatActivity {


    private ImageView imageView;      //图像视图控件
    private int i = 2;                   //设置图像标记

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main05);
        imageView = findViewById(R.id.imageView);         //获取图像视图控件
    }
    //图像视图控件的单击事件
    public void onImageView(View view) {
        if (i == 2) {
            imageView.setBackgroundResource(R.drawable.bg1);  //更换图片
            i=1;                                               //更改图像标记
        } else {
            imageView.setBackgroundResource(R.drawable.bg2);
            i=2;                                               //更改图像标记
        }

    }

}*/

// 下面是示例6(手机QQ相册界面)的代码
/*public class MainActivity extends AppCompatActivity {


    //显示的图片资源ID的数组
    private Integer[] picture = {R.mipmap.img01, R.mipmap.img02, R.mipmap.img03,
            R.mipmap.img04, R.mipmap.img05, R.mipmap.img06, R.mipmap.img07,
            R.mipmap.img08, R.mipmap.img09, R.mipmap.img10, R.mipmap.img11,
            R.mipmap.img12,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main06);
        GridView gridView= (GridView) findViewById(R.id.gridView);  //获取布局文件中的GridView组件
        gridView.setAdapter(new ImageAdapter(this));                //调用ImageAdapter

    }
    //创建ImageAdapter
    public class ImageAdapter extends BaseAdapter {
        private Context mContext;  //获取上下文
        public ImageAdapter(Context c){
            mContext=c;
        }
        @Override
        public int getCount() {
            return picture.length;//图片数组的长度
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if(convertView==null){        //判断传过来的值是否为空
                imageView=new ImageView(mContext);  //创建ImageView组件
                imageView.setLayoutParams(new GridView.LayoutParams(100, 90));//为组件设置宽高
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP); //选择图片铺设方式
            }else{
                imageView= (ImageView) convertView;
            }
            imageView.setImageResource(picture[position]);    //将获取图片放到ImageView组件中
            return imageView;                    //返回ImageView
        }
    }

}*/


// 下面是实战1(相机拍照按钮)的代码
/*public class MainActivity extends AppCompatActivity {

    private ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main07);
        button = (ImageButton) findViewById(R.id.camera_btn);  //绑定id
        button.setOnClickListener(new View.OnClickListener() {  //设置点击监听事件
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "开始拍照", Toast.LENGTH_SHORT).show();   //弹出提示
            }
        });
    }
}*/

// 下面是实战2(淘宝首页分类栏)的代码
public class MainActivity extends AppCompatActivity {

    private Integer[] ims = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
            R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j};
    private String[] name = {"天猫", "聚划算", "天猫国际", "外卖", "天猫超市"
            , "充值中心", "飞猪旅行", "领金币", "拍卖", "分类"};
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main08);
        List<Map<String, Object>> listems = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> listem = new HashMap<>();
            listem.put("image", ims[i]);
            listem.put("name", name[i]);
            listems.add(listem);
        }
        gridView = (GridView) findViewById(R.id.grid_view);
        /*SimpleAdapter的参数说明
         * 第一个参数 表示访问整个android应用程序接口，基本上所有的组件都需要
         * 第二个参数表示生成一个Map(String ,Object)列表选项
         * 第三个参数表示界面布局的id  表示该文件作为列表项的组件
         * 第四个参数表示该Map对象的哪些key对应value来生成列表项
         * 第五个参数表示来填充的组件 Map对象key对应的资源一依次填充组件 顺序有对应关系
         * 注意的是map对象可以key可以找不到 但组件的必须要有资源填充  因为 找不到key也会返回null 其实就相当于给了一个null资源
         * 下面的程序中如果 new String[] { "name", "head", "desc","name" } new int[] {R.id.name,R.id.head,R.id.desc,R.id.head}
         * 这个head的组件会被name资源覆盖
         * */
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listems,
                R.layout.grid_item, new String[]{ "name", "image"},new int[] {R.id.tv,R.id.iv});
        gridView.setAdapter(simpleAdapter);
    }

}
