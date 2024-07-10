package com.example.viewpage;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.xml.sax.Parser;
import org.xml.sax.SAXException;

import java.util.List;

public class MyAdapter extends PagerAdapter {

    private List<View> myListView;

    public MyAdapter(List<View> myListView) {
        this.myListView = myListView;
    }

    // 1. 将给定位置的view添加到viewGroup(容器)中, 创建并显示出来
    // 2. 返回一个代表新增页面的Object(key), 通常是直接返回view本身即可, 也可以自定义key, 但是key和view要一一对应
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        container.addView(myListView.get(position), 0);

        return myListView.get(position);
    }

    @Override
    public int getCount() {
        return myListView == null ? 0 :myListView.size();
    }

    // 判断instantiateItem返回的key与页面视图是否相等
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    // 移除一个给定位置的页面, 从容器中删除这个视图
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(myListView.get(position));
    }
}
