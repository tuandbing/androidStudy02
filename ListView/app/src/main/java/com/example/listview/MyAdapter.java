package com.example.listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<Bean> data;

    private Context context;

    public MyAdapter(List<Bean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //  getView的作用:
    //      填充每个item的可视内容并返回
    //      负责给每个item填充内容，并且返回视图对象

    /*
        深入理解:   https://blog.csdn.net/chenyantc02/article/details/103939451
            每当某个item进入到可视区域，就会自动调用getView方法来填充数据并绘制
            1.getView方法是由系统自动回调的方法,每当可视区域内需要刷新一个item时就会被调用
                用来填充item内容、绑定事件等其他操作。
            2.参数position是系统回调getView方法时自动传入的
                代表当前刷新的item的索引号下标从0开始。
            3.界面启动时,自动调用getView方法传入的convertView均为null; 根据代码逻辑
                if(convertView == null){
                    convertView = View.inflate(MainActivity.this,R.layout.item_view,null);
                    findViews(ics,convertView);
                    convertView.setTag(ics);
                }
            当convertView为null时就是调用View.inflate给其赋值.
            4.每当某个item进入到可视区域,就会自动调用getView方法来填充数据并绘制View。
    */
    /*@Override
    public View getView(int position, View view, ViewGroup parent) {

        if(view == null){

            view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);

        }

        // 每次都重新获取, 会复杂
        TextView textView = view.findViewById(R.id.tv);

        textView.setText(data.get(position).getName());

        Log.e("leo", "getView: " + position);

        return view;
    }*/

    // 优化处理
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder viewHolder;

        if(view == null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
            viewHolder.textView = view.findViewById(R.id.tv);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.textView.setText(data.get(position).getName());

        Log.e("leo", "getView: " + position);

        return view;
    }

    private final class ViewHolder{
        TextView textView;
    }

}
