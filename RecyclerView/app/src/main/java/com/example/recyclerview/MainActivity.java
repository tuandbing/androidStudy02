package com.example.recyclerview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Bean> data = new ArrayList<>();

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

        RecyclerView recyclerView = findViewById(R.id.rv);

        // 设置布局
        /*
            线性布局:   LinearLayoutManager(Context)
            网格布局:   GridLayoutManager(Context, int)     第二个参数是指一行内有多少格
            瀑布流布局:  StaggeredGridLayoutManager(int spanCount, int orientation)
                spanCount(限定行/列数)     orientation(布局方式)
        */
        /*LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);*/

        /*GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);*/

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        MyAdapter myAdapter = new MyAdapter(data, this);
        recyclerView.setAdapter(myAdapter);

        // 添加监听器(自己创建的)
        myAdapter.setRecyclerItemClickListener(new MyAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onRecyclerItemClick(int position) {
                Log.e("leo", "onRecyclerItemClick: " + position);
            }
        });

    }
}