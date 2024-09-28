package com.example.studentmgr;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class ActivityStudent extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextId;
    private RadioGroup radioGroupGender;
    private Spinner spinnerCollege,input_major_spinner;
    private Button button1;
    private CheckBox checkLiterature, checkSports, checkMusic, checkArt;
    private Student student1;
    private ArrayAdapter<String> majorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        // 初始化视图组件
        editTextName = findViewById(R.id.editTextName);
        editTextId = findViewById(R.id.editTextId);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        spinnerCollege = findViewById(R.id.spinnerCollege);
        button1 =  findViewById(R.id.button1);
        input_major_spinner = findViewById(R.id.input_major_spinner);
        checkLiterature = findViewById(R.id.checkLiterature);
        checkSports = findViewById(R.id.checkSports);
        checkMusic = findViewById(R.id.checkMusic);
        checkArt = findViewById(R.id.checkArt);

        // 配置学院下拉框
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.college_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCollege.setAdapter(adapter);
        //回显数据
        student1 = (Student) getIntent().getSerializableExtra("student1");
        int position = getIntent().getIntExtra("position", -1);
        ArrayAdapter<String> collegeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{"计算机学院", "电气学院"});

        collegeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCollege.setAdapter(collegeAdapter);
        updateCollegeSelection(collegeAdapter);

        spinnerCollege.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    majorAdapter = new ArrayAdapter<>(ActivityStudent.this,android.R.layout.simple_spinner_item,new String[]{"软件工程","信息安全","物联网"});
                }else {
                    majorAdapter = new ArrayAdapter<>(ActivityStudent.this, android.R.layout.simple_spinner_item,
                            new String[]{"电气工程", "电机工程"});
                }
                majorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                input_major_spinner.setAdapter(majorAdapter);

                if(student1 != null){
                    String major = student1.getMajor();
                    if (major != null) {
                        int position2 = majorAdapter.getPosition(major);
                        if (position2 >= 0) {
                            input_major_spinner.setSelection(position2);
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        if (student1 != null){
            editTextName.setText(student1.getName());
            editTextId.setText(student1.getId());
            String gender = student1.getGender();

            if (gender != null){
                switch (gender){
                    case "男":
                        radioGroupGender.check(R.id.radioButtonMale);
                        break;
                    case "女":
                        radioGroupGender.check(R.id.radioButtonFemale);
                        break;
                    default:
                        break;
                }
            }
            String hobbies = student1.getHobbies();
            String[] split = hobbies.split(" ");
            for (String s : split) {
                if (s.equals("体育")){
                    checkSports.setChecked(true);
                }
                if (s.equals("美术")){
                    checkArt.setChecked(true);
                }
                if (s.equals("音乐")){
                    checkMusic.setChecked(true);
                }
                if (s.equals("文学")){
                    checkLiterature.setChecked(true);
                }
            }
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 获取选择的性别
                int selectedId = radioGroupGender.getCheckedRadioButtonId();
                String gender = null;

                if (selectedId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    gender = selectedRadioButton.getText().toString();
                    Toast.makeText(ActivityStudent.this, "提交成功,性别: " + gender, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ActivityStudent.this, "你没有选择性别", Toast.LENGTH_SHORT).show();
                    return; // 没有选择性别时，结束方法
                }

                // 获取其他信息
                String name = editTextName.getText().toString();
                String studentId = editTextId.getText().toString();
                String college = spinnerCollege.getSelectedItem().toString();
                String major = input_major_spinner.getSelectedItem().toString();
                String hobbies = getsHobbies();

                // 性别转换
                Integer sex = gender.equals("女") ? 0 : 1;

                // 创建学生对象
                Student student = new Student(name, studentId, gender, college, major, sex, hobbies);
                Intent resultIntent = new Intent();
                // 准备返回结果
                if(position != -1){
                    resultIntent.putExtra("update-student", student);
                }else {
                    resultIntent.putExtra("student", student);
                }
                resultIntent.putExtra("position", position); // 确保正确传递 position
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
    private String getsHobbies() {
        StringBuilder hobbies = new StringBuilder();
        if (checkLiterature.isChecked()) hobbies.append("文学 ");
        if (checkSports.isChecked()) hobbies.append("体育 ");
        if (checkMusic.isChecked()) hobbies.append("音乐 ");
        if (checkArt.isChecked()) hobbies.append("美术 ");
        return hobbies.toString().trim();
    }
    private void updateCollegeSelection(ArrayAdapter<String> collegeAdapter) {
        if (student1 != null) {
            String college = student1.getCollege();
            if (college != null) {
                int position1 = collegeAdapter.getPosition(college);
                if (position1 >= 0) {
                    spinnerCollege.setSelection(position1);
                }
            }
        }
    }
}
