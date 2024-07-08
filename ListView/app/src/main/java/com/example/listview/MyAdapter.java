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
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

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
