package com.example.listview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Bean> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 100; i++) {

            Bean bean = new Bean();

            bean.setName("馒头 " + i);

            data.add(bean);

        }

        ListView listView = findViewById(R.id.lv);

        // Adapter  适配器
        // 适配器的作用就是在数据和视图之间建立一种桥梁，类似一个转换器，能够将复杂的数据转换成用户可以接受的方式进行呈现
        listView.setAdapter(new MyAdapter(data, this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Log.e("leo", "onItemClick: " + position);

            }
        });

    }
}