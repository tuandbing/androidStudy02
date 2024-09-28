package com.example.studentmgr;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter {
    public StudentAdapter(@NonNull Context context, ArrayList<Student> students) {
        super(context,0,students);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 如果没有现成的视图，则创建一个新视图
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_student, parent, false);
        }

        // 获取当前学生对象
        Student student = (Student) getItem(position);

        // 查找并更新视图中的文本
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvId = convertView.findViewById(R.id.tvId);
        TextView tvGender = convertView.findViewById(R.id.tvGender);
        TextView tvCollege = convertView.findViewById(R.id.tvCollege);
        TextView tvMajor = convertView.findViewById(R.id.tvMajor);
        ImageView ivProfile = convertView.findViewById(R.id.ivProfile);
        TextView tvHobiess = convertView.findViewById(R.id.tvHobiess);

        if (student != null) {
            tvName.setText("姓名："+ (student.getName()));
        }
        if (student != null) {
            tvId.setText("学号: " + (student.getId()));
        }
        if (student != null) {
            tvGender.setText("性别: " + (student.getGender()));
        }
        if (student != null) {
            tvCollege.setText("学院: " + (student.getCollege()));
        }
        if (student != null) {
            tvMajor.setText("专业: " + student.getMajor());
        }
        if (student != null) {
            tvHobiess.setText("爱好："+student.getHobbies());
        }

        // 设置图片资源
        // 默认图片
        if (student != null && student.getProfileImageResId() != 0) {
            ivProfile.setImageResource(R.drawable.man);
        }

        return convertView;
    }
}
