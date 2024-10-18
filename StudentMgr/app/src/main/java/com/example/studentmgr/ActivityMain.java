package com.example.studentmgr;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ActivityMain extends AppCompatActivity {

    private Button btnAdd, logout, search;
    private ListView lvwStudent;
    private ArrayAdapter<Student> adapter;
    private static ArrayList<Student> studentList;
    private ArrayList<Student> originalStudentList; // 添加一个变量来存储原始学生列表
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        lvwStudent = findViewById(R.id.lvwStudent);
        logout = findViewById(R.id.logout);
        search = findViewById(R.id.search);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loadStudentList();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentList);
        lvwStudent.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this, ActivityStudent.class);
                startActivityForResult(intent, 1);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityMain.this);
                builder.setTitle("查询学生");

                final EditText input = new EditText(ActivityMain.this);
                builder.setView(input);

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String query = input.getText().toString();
                        searchStudents(query);
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });

        lvwStudent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                new AlertDialog.Builder(ActivityMain.this)
                        .setTitle("确认删除")
                        .setMessage("确认删除该学生记录吗？")
                        .setPositiveButton("删除", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                studentList.remove(i);
                                originalStudentList.remove(i); // 同时从原始列表中删除
                                adapter.notifyDataSetChanged();
                                Utils.showCustomToast(ActivityMain.this, "学生记录删除成功");
                                saveStudentList();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
                return true;
            }
        });

        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this, ActivityLogin.class);
                startActivity(intent);
                Toast.makeText(ActivityMain.this, "退出成功", Toast.LENGTH_SHORT).show();
            }
        });

        lvwStudent.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ActivityMain.this, ActivityEdit.class);
                Student student = studentList.get(i);
                intent.putExtra("name", student.getName());
                intent.putExtra("studentID", student.getId());
                intent.putExtra("gender", student.getGender());
                intent.putExtra("college", student.getCollege());
                intent.putExtra("major", student.getMajor());
                intent.putExtra("hobbies", student.getHobbies());
                intent.putExtra("birthDate", student.getBirthDate());
                intent.putExtra("position", i);
                startActivityForResult(intent, 2);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    private void searchStudents(String query) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : originalStudentList) { // 从原始列表中进行搜索
            if (student.getName().contains(query) || student.getCollege().contains(query) || student.getMajor().contains(query)) {
                result.add(student);
            }
        }

        if (result.isEmpty()) {
            Utils.showCustomToast(ActivityMain.this, "没有查询到结果");
        } else {
            adapter.clear();
            adapter.addAll(result);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String name = data.getStringExtra("name");
            String studentID = data.getStringExtra("studentID");
            String gender = data.getStringExtra("gender");
            String college = data.getStringExtra("college");
            String major = data.getStringExtra("major");
            Date date;
            try {
                date = dateFormat.parse(data.getStringExtra("birthDate"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            String hobbies = data.getStringExtra("hobbies");
            Student student = new Student(name, studentID, gender, college, major, date, hobbies);
            studentList.add(student);
            originalStudentList.add(student); // 同时添加到原始列表中
            adapter.notifyDataSetChanged();
            saveStudentList();
        }else if ( requestCode == 2 && resultCode == RESULT_OK && data != null){
            String name = data.getStringExtra("name");
            String studentID = data.getStringExtra("studentID");
            String gender = data.getStringExtra("gender");
            String college = data.getStringExtra("college");
            String major = data.getStringExtra("major");
            Date date;
            try {
                date = dateFormat.parse(data.getStringExtra("birthDate"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            String hobbies = data.getStringExtra("hobbies");
            int position = data.getIntExtra("position", 0);
            Student updatedStudent = new Student(name, studentID, gender, college, major, date, hobbies);
            studentList.set(position, updatedStudent);
            originalStudentList.set(position, updatedStudent); // 更新原始列表
            adapter.notifyDataSetChanged();
            saveStudentList();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_add){
            Intent intent = new Intent(ActivityMain.this, ActivityStudent.class);
            startActivityForResult(intent, 1);
            return true;
        } else if (item.getItemId() == R.id.menu_refresh) {
            // Reset to show all students
            adapter.clear();
            adapter.addAll(originalStudentList); // 从原始列表加载数据
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "列表已刷新", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void saveStudentList() {
        SharedPreferences prefs = getSharedPreferences("StudentPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(studentList);
        editor.putString("studentList", json);
        editor.apply();
    }

    private void loadStudentList() {
        SharedPreferences prefs = getSharedPreferences("StudentPrefs", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("studentList", null);
        Type type = new TypeToken<ArrayList<Student>>() {}.getType();
        studentList = gson.fromJson(json, type);

        if (studentList == null) {
            studentList = new ArrayList<>();
        }

        originalStudentList = new ArrayList<>(studentList); // 复制原始列表
    }
}
