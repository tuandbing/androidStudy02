package com.example.chapter07;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
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

public class MainActivity extends AppCompatActivity {
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

        ListView listView = (ListView) findViewById(R.id.listview);

        List<Map<String, Object>> mapList = new ArrayList<>();

        // 将名称、照片、信息循环放入
        for (int i = 0; i < icons.length; i++) {

            Map<String, Object> map = new HashMap<>();
            map.put("名字", names[i]);
            map.put("照片", icons[i]);
            map.put("信息", infos[i]);
            mapList.add(map);

        }

        // 新建适配器
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, mapList, R.layout.item,
                new String[]{"名字", "照片", "信息"},
                new int[]{R.id.name, R.id.img, R.id.info});

        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {

                Map<String, Object> item = (Map<String, Object>) parent.getItemAtPosition(position);

                Toast.makeText(MainActivity.this, item.get("名字").toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}