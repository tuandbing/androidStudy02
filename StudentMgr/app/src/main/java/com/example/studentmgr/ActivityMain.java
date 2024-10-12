package com.example.studentmgr;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class ActivityMain extends AppCompatActivity {

    private Button btnAdd, logout;
    private ListView lvwStudent;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        lvwStudent = findViewById(R.id.lvwStudent);
        logout = findViewById(R.id.logout);
        studentList = new ArrayList<>();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentList);
        lvwStudent.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this, ActivityStudent.class);
                startActivityForResult(intent, 1);
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
                                adapter.notifyDataSetChanged();
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
                intent.putExtra("studentInfo", studentList.get(i));
                String data = studentList.get(i);
                String[] strings = data.split(" ");

                intent.putExtra("name", strings[1].substring(0, strings[1].indexOf("\n")).replaceAll(" ", "").replace("\n", ""));
                intent.putExtra("studentID", strings[2].substring(0, strings[2].indexOf("性别")).replaceAll(" ", "").replace("\n", ""));
                intent.putExtra("gender", strings[3].substring(0, strings[3].indexOf("学院")).replaceAll(" ", "").replace("\n", ""));
                intent.putExtra("college", strings[4].substring(0, strings[4].indexOf("专业")).replaceAll(" ", "").replace("\n", ""));
                intent.putExtra("major", strings[5].substring(0, strings[5].indexOf("爱好")).replaceAll(" ", "").replace("\n", ""));
                StringBuilder hobbies = new StringBuilder();
                for (int j = 6; j < strings.length; j++) {
                    hobbies.append(strings[j]);
                }
                intent.putExtra("hobbies", hobbies.toString());
                startActivityForResult(intent, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String studentInfo = data.getStringExtra("studentInfo");
            studentList.add(studentInfo);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_add){
            Intent intent = new Intent(ActivityMain.this, ActivityStudent.class);
            startActivityForResult(intent, 1);
            return true;
        }else if ( item.getItemId() == R.id.menu_refresh) {
            Toast.makeText(this, "列表已刷新", Toast.LENGTH_SHORT).show();
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }
    }


}
