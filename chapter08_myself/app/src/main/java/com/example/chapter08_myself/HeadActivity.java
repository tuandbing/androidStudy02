package com.example.chapter08_myself;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class HeadActivity extends Activity {

    private int[] images= {
            R.mipmap.touxiang1,
            R.mipmap.touxiang2,
            R.mipmap.touxiang3,
            R.mipmap.touxiang4,
            R.mipmap.touxiang5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);

        GridView gv = (GridView) findViewById(R.id.gridView);

        gv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public Object getItem(int position) {
                return images[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView = null;

                if(convertView == null){
                    imageView = new ImageView(HeadActivity.this);
                    imageView.setAdjustViewBounds(true);

                    imageView.setMaxWidth(158);
                    imageView.setMaxHeight(150);

                    imageView.setPadding(5,5,5,5);
                }else{
                    imageView = (ImageView) convertView;
                }

                imageView.setImageResource(images[position]);
                return imageView;
            }
        });


    }
}
