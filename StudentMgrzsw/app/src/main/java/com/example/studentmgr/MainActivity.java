package com.example.studentmgr;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupMenu;

import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ListView lvwStudent;
    private Button btnAdd;
    private ArrayList<Student> studentList;
    private StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lvwStudent = findViewById(R.id.lvwStudent);
        btnAdd = findViewById(R.id.btnAdd);

        studentList = new ArrayList<>();
        adapter = new StudentAdapter(this, studentList);
        lvwStudent.setAdapter(adapter);

        lvwStudent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                showPopupMenu(view, i);
                return true;
            }
        });


        btnAdd.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ActivityStudent.class);
            startActivityForResult(intent, 1);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK){
            if (data != null) {
                Student student = (Student) data.getSerializableExtra("update-student");
                int position = data.getIntExtra("position", -1);

                Log.d("mymes", "onActivityResult: " + position);

                Log.d("mymes", "onActivityResult: " + studentList.get(position));

                studentList.set(position, student);

                Log.d("mymes", "onActivityResult: " + studentList.get(position));

                adapter.notifyDataSetChanged();
            } else {
                Log.e("TAG", "Data intent is null");
            }
        }
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null) {
                Student student =  (Student) data.getSerializableExtra("student");
                studentList.add(student);
                adapter.notifyDataSetChanged();
            } else {
                Log.e("TAG", "Data intent is null");
            }

        }
    }


    private void showPopupMenu(View view, int position) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                int itemId = menuItem.getItemId();
                if (itemId == R.id.edit) {
                    Intent intent = new Intent(MainActivity.this, ActivityStudent.class);
                    intent.putExtra("student1", studentList.get(position));
                    intent.putExtra("position",position);
                    startActivityForResult(intent, 2);
                    return true;
                } else if (itemId == R.id.delete) {
                    confirmDelete(position);
                    return true;
                }
                return false;
            }
        });
        popupMenu.show();
    }
    private void confirmDelete(int position) {
        new AlertDialog.Builder(this)
                .setTitle("Delete")
                .setMessage("确定要删除该学生？")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        studentList.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .show();
    }
}
