package com.example.chapter07;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

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


// 案例1(豆瓣网搜索下拉列表框)
/*public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main01);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);               //获取下拉列表
        //为下拉列表创建监听事件
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                String result = parent.getItemAtPosition(position).toString(); //获取选择项的值
                //显示被选中的值
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
}*/

// 案例2(模拟支付宝朋友列表)
/*public class MainActivity extends AppCompatActivity {
    //图标数组
    private int[] icons = {
            R.drawable.icon_1, R.drawable.icon_2, R.drawable.icon_3,
            R.drawable.icon_4, R.drawable.icon_5, R.drawable.icon_6,
            R.drawable.icon_7, R.drawable.icon_8, R.drawable.icon_9,
            R.drawable.icon_10, R.drawable.icon_11

    };
    //名字数组
    private String[] names = {
            "赵...","孙...","李...","周...",
            "吴...","郑...","王...","冯...",
            "陈...","卫...","沈..."
    };
    //信息数组
    private String[] infos = {
            "人之所以能，是相信能。","世上没有绝望的处境，只有对处境绝望的人。",
            "大多数人想要改造这个世界，但却罕有人想改造自己。", "莫找借口失败，只找理由成功",
            "每一发奋努力的背后，必有加倍的赏赐。","人生伟业的建立 ，不在能知，乃在能行。",
            "理想犹如太阳，吸引地上所有的泥水。","沉思的人有一个目标，幻想的人却没有。",
            "心有多大，世界就有多大！", "微笑向阳，无畏悲伤。",
            "有多大的思想，才有多大的能量。",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main02);

        ListView listview = (ListView) findViewById(R.id.listview); // 获取列表视图
        // 创建一个list集合
        List<Map<String, Object>> listItems = new ArrayList<>();
        // 通过for循环将图片id和列表项文字放到Map中，并添加到List集合中
        for (int i = 0; i < icons.length; i++) {
            Map<String, Object> map = new HashMap<>(); // 实例化Map对象
            map.put("图标", icons[i]);
            map.put("名字", names[i]);
            map.put("信息",infos[i]);
            listItems.add(map);                                     // 将map对象添加到List集合中
        }

        SimpleAdapter adapter = new SimpleAdapter(this, listItems,
                R.layout.item, new String[]{"名字", "图标","信息"}, new int[]{
                R.id.name, R.id.img,R.id.info});          // 创建SimpleAdapter
        listview.setAdapter(adapter);              // 将适配器与ListView关联
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取选择项的值
                Map<String, Object> map = (Map<String, Object>) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, map.get("名字").
                        toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

}*/

// 案例3(模拟App引导界面)
/*
public class MainActivity extends AppCompatActivity {

    private View view1,view2,view3,view4;   //4个页面视图
    private List<View> viewList;             //保存页面的数组列表
    private ViewPager viewPager;             //ViewPager组件

    PagerAdapter adapter = new PagerAdapter() {             //创建适配器
        @Override
        public int getCount() {         //获取页面个数
            return viewList.size();     //返回页面数量
        }
        //确定页面视图是否与返回的对象相关联
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
        //从视图容器中移除指定位置的页面
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }
        //返回当前所显示的视图
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main03);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);      //设置全屏显示

        //获取布局填充器
        LayoutInflater lf = getLayoutInflater().from(this);

        //获取ViewPager组件
        viewPager= findViewById(R.id.viewPager);
        view1 = lf.inflate(R.layout.layout1, null);      //加载页面1的布局文件
        view2 = lf.inflate(R.layout.layout2, null);      //加载页面2的布局文件
        view3 = lf.inflate(R.layout.layout3, null);      //加载页面3的布局文件
        view4 = lf.inflate(R.layout.layout4, null);      //加载页面4的布局文件
        viewList = new ArrayList<>();                 //创建保存4个页面的数组列表
        viewList.add(view1);                              //向数组列表中添加第1个页面
        viewList.add(view2);                              //向数组列表中添加第2个页面
        viewList.add(view3);                              //向数组列表中添加第3个页面
        viewList.add(view4);                              //向数组列表中添加第4个页面
        viewPager.setAdapter(adapter);                    //设置适配器

    }

    public void onEnter(View view){         //第4个页面中按钮单击事件方法
        //创建Intent跳转主界面2中
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);      //启动Intent
    }

}
*/

// 案例4(可以翻页的标题栏)
/*
public class MainActivity extends AppCompatActivity {

    private List<View> pageList = new ArrayList<View>();   //存放页面
    private List<String> tabList = new ArrayList<String>();   //存放标题文字
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main04);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);      //设置全屏显示
        //获取ViewPager组件
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        //加载4个页面的布局文件
        View view_1 = LayoutInflater.from(getApplicationContext()).
                inflate(R.layout.layout1,null);
        View view_2 = LayoutInflater.from(getApplicationContext()).
                inflate(R.layout.layout2,null);
        View view_3 = LayoutInflater.from(getApplicationContext()).
                inflate(R.layout.layout3,null);
        View view_4 = LayoutInflater.from(getApplicationContext()).
                inflate(R.layout.layout4,null);
        //添加ViewPage的4个页面
        pageList.add(view_1);
        pageList.add(view_2);
        pageList.add(view_3);
        pageList.add(view_4);
        //添加标题文字
        tabList.add("Android 精彩编程200例");
        tabList.add("Java 精彩编程200例");
        tabList.add("ASP.NET 精彩编程200例");
        tabList.add("C# 精彩编程200例");
        //设置适配器
        viewPager.setAdapter(adapter);
    }
    PagerAdapter adapter=new PagerAdapter() {
        @Override
        public int getCount() {         //获取页面个数
            return pageList.size();    //返回页面数量
        }
        //确定页面视图是否与返回的对象相关联
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
        //从视图容器中移除指定位置的页面
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(pageList.get(position));
        }
        //返回当前所显示的视图
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(pageList.get(position));
            return pageList.get(position);
        }
        //设置标题文字
        @Override
        public CharSequence getPageTitle(int position) {
            return tabList.get(position);
        }
    };


}*/

// 案例5(为编程词典目录添加垂直滚动条)
/*
public class MainActivity extends AppCompatActivity {
    //定义linearLayout为默认布局管理器，linearLayout2为新建布局管理器
    LinearLayout linearLayout, linearLayout2;
    ScrollView scrollView;                                    //定义滚动视图组件
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main05);
        linearLayout = (LinearLayout) findViewById(R.id.ll);     //获取布局管理器
        linearLayout2 = new LinearLayout(MainActivity.this);     //创建一个新的布局管理器
        linearLayout2.setOrientation(LinearLayout.VERTICAL);     //设置为纵向排列
        scrollView = new ScrollView(MainActivity.this);           //创建滚动视图组件
        linearLayout.addView(scrollView);                     //默认布局中添加滚动视图组件
        scrollView.addView(linearLayout2);                    //滚动视图组件中添加新建布局
        ImageView imageView = new ImageView(MainActivity.this);       //创建ImageView组件
        imageView.setImageResource(R.mipmap.cidian);      //ImagView添加图片
        TextView textView = new TextView(MainActivity.this);   //创建TextView组件
        textView.setText(R.string.cidian);             //为TextView添加文字
        linearLayout2.addView(imageView);              //新建布局中添加ImageView组件
        linearLayout2.addView(textView);               //新建布局中添加TextView组件

    }

}
*/

// 案例6(模拟微信表情商店选项卡)
/*
public class MainActivity extends AppCompatActivity {
    private TabHost tabHost;                                       //声明TabHost组件的对象
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main06);
        tabHost=(TabHost)findViewById(android.R.id.tabhost);    //获取TabHost对象
        tabHost.setup();                                            //初始化TabHost组件
        // 声明并实例化一个LayoutInflater对象
        LayoutInflater inflater = LayoutInflater.from(this);
        inflater.inflate(R.layout.tab1, tabHost.getTabContentView());
        inflater.inflate(R.layout.tab2,tabHost.getTabContentView());
        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("精选表情")
                .setContent(R.id.linearlayout1));             //添加第一个标签页
        tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator("投稿表情")
                .setContent(R.id.framelayout)) ;              //添加第二个标签页
    }

}
*/

public class MainActivity extends AppCompatActivity {


    private List<String> tabList;

    private List<View> pageList;

    private View view1, view2, view3, view4;

    private PagerAdapter adapter = new PagerAdapter() {

        @Override
        public int getCount() {
            return pageList != null ? pageList.size() : 0;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(pageList.get(position));
            return pageList.get(position);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(pageList.get(position));
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabList.get(position);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main04);
        ViewPager viewPager = findViewById(R.id.viewPager);
        tabList = new ArrayList<>();
        pageList = new ArrayList<>();
        /*view1 = LayoutInflater.from(getApplication()).inflate(R.layout.layout1, null);
        view2 = LayoutInflater.from(getApplication()).inflate(R.layout.layout2, null);
        view3 = LayoutInflater.from(getApplication()).inflate(R.layout.layout3, null);
        view4 = LayoutInflater.from(getApplication()).inflate(R.layout.layout4, null);*/

        // 两种方法都可以获取LayoutInflater对象
        view1 = getLayoutInflater().inflate(R.layout.layout1, null);
        view2 = getLayoutInflater().inflate(R.layout.layout2, null);
        view3 = getLayoutInflater().inflate(R.layout.layout3, null);
        view4 = getLayoutInflater().inflate(R.layout.layout4, null);

        pageList.add(view1);
        pageList.add(view2);
        pageList.add(view3);
        pageList.add(view4);

        tabList.add("毕业格言1");
        tabList.add("毕业格言2");
        tabList.add("毕业格言3");
        tabList.add("毕业格言4");

        viewPager.setAdapter(adapter);


    }
}

