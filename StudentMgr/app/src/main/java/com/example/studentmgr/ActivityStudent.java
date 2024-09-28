package com.example.studentmgr;

import android.content.Intent;
import android.os.Bundle;
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
import java.util.List;

public class ActivityStudent extends AppCompatActivity {

    private static List<String> sids = new ArrayList<>();

    private EditText edtName, edtStudentID;
    private RadioGroup radioGroupGender;
    private RadioButton rbtnMale, rbtnFemale;
    private Spinner spnCollege, spnMajor;
    private CheckBox chkLiterature, chkSports, chkMusic, chkArt;
    private Button btnSubmit, btnReset;

    private ArrayAdapter<CharSequence> adapterCollege, adapterMajorComputer, adapterMajorElectric, adapterMajorMechanic, adapterMajorMaterial, adapterMajorChemistry, adapterNoCo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        edtName = findViewById(R.id.edtName);
        edtStudentID = findViewById(R.id.edtStudentID);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        rbtnMale = findViewById(R.id.rbtnMale);
        rbtnFemale = findViewById(R.id.rbtnFemale);
        spnCollege = findViewById(R.id.spnCollege);
        spnMajor = findViewById(R.id.spnMajor);
        chkLiterature = findViewById(R.id.chkLiterature);
        chkSports = findViewById(R.id.chkSports);
        chkMusic = findViewById(R.id.chkMusic);
        chkArt = findViewById(R.id.chkArt);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnReset = findViewById(R.id.btnReset);

        adapterCollege = ArrayAdapter.createFromResource(this, R.array.college_array, android.R.layout.simple_spinner_item);
        adapterCollege.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCollege.setAdapter(adapterCollege);

        adapterMajorComputer = ArrayAdapter.createFromResource(this, R.array.major_computer_array, android.R.layout.simple_spinner_item);
        adapterMajorComputer.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterMajorElectric = ArrayAdapter.createFromResource(this, R.array.major_electric_array, android.R.layout.simple_spinner_item);
        adapterMajorElectric.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterMajorMaterial = ArrayAdapter.createFromResource(this, R.array.major_material_array, android.R.layout.simple_spinner_item);
        adapterMajorMaterial.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterMajorChemistry = ArrayAdapter.createFromResource(this, R.array.major_chemistry_array, android.R.layout.simple_spinner_item);
        adapterMajorChemistry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterMajorMechanic = ArrayAdapter.createFromResource(this, R.array.major_mechanic_array, android.R.layout.simple_spinner_item);
        adapterMajorMechanic.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterNoCo = ArrayAdapter.createFromResource(this, R.array.no_college_array, android.R.layout.simple_spinner_item);
        adapterNoCo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnCollege.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    spnMajor.setAdapter(adapterMajorComputer);
                } else if (position == 2){
                    spnMajor.setAdapter(adapterMajorElectric);
                }else if (position == 3){
                    spnMajor.setAdapter(adapterMajorMechanic);
                }else if (position == 4){
                    spnMajor.setAdapter(adapterMajorMaterial);
                }else if (position == 5){
                    spnMajor.setAdapter(adapterMajorChemistry);
                }else{
                    spnMajor.setAdapter(adapterNoCo);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtName.setText("");
                edtStudentID.setText("");
                radioGroupGender.check(R.id.rbtnMale);
                spnCollege.setSelection(0);
                spnMajor.setSelection(0);
                chkLiterature.setChecked(false);
                chkSports.setChecked(false);
                chkMusic.setChecked(false);
                chkArt.setChecked(false);
                Toast.makeText(ActivityStudent.this, "重置成功", Toast.LENGTH_SHORT).show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String studentID = edtStudentID.getText().toString();
                String gender = ((RadioButton)findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
                String college = spnCollege.getSelectedItem().toString();
                String major = spnMajor.getSelectedItem().toString();
                StringBuilder hobbies = new StringBuilder();
                if (chkLiterature.isChecked()) hobbies.append(chkLiterature.getText().toString()).append(" ");
                if (chkSports.isChecked()) hobbies.append(chkSports.getText().toString()).append(" ");
                if (chkMusic.isChecked()) hobbies.append(chkMusic.getText().toString()).append("").append(" ");
                if (chkArt.isChecked()) hobbies.append(chkArt.getText().toString()).append(" ");

                if(name.isEmpty() || studentID.isEmpty() || college.equals("学院") || major.equals("专业") || hobbies.length() == 0){
                    Toast.makeText(ActivityStudent.this, "请将信息补充完整", Toast.LENGTH_SHORT).show();
                }else{
                    if(!sids.isEmpty() && sids.contains(studentID)){
                        Toast.makeText(ActivityStudent.this, "学号重复，请重新输入", Toast.LENGTH_SHORT).show();
                    }else{
                        sids.add(studentID);
                        String studentInfo = String.format("姓名: %s\n学号: %s\n性别: %s\n学院: %s\n专业: %s\n爱好: %s",
                                name, studentID, gender, college, major, hobbies.toString());

                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("studentInfo", studentInfo);
                        setResult(RESULT_OK, resultIntent);
                        finish();
                    }
                }
            }
        });
    }
}
