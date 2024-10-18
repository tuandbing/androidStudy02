package com.example.studentmgr;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityStudent extends AppCompatActivity {

    private static final String TAG = "ActivityStudent";
    private static List<String> sids = new ArrayList<>();

    private EditText edtName, edtStudentID;
    private RadioGroup radioGroupGender;
    private Spinner spnCollege, spnMajor;
    private CheckBox chkLiterature, chkSports, chkMusic, chkArt;
    private Button btnSubmit, btnReset;
    private DatePicker datePicker;
    private int day, month, year;

    private ArrayAdapter<CharSequence> adapterCollege, adapterMajorComputer, adapterMajorElectric, adapterMajorMechanic, adapterMajorMaterial, adapterMajorChemistry, adapterNoCo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        initializeViews();
        setupAdapters();
        setupListeners();
    }

    private void initializeViews() {
        edtName = findViewById(R.id.edtName);
        edtStudentID = findViewById(R.id.edtStudentID);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        spnCollege = findViewById(R.id.spnCollege);
        spnMajor = findViewById(R.id.spnMajor);
        chkLiterature = findViewById(R.id.chkLiterature);
        chkSports = findViewById(R.id.chkSports);
        chkMusic = findViewById(R.id.chkMusic);
        chkArt = findViewById(R.id.chkArt);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnReset = findViewById(R.id.btnReset);
        datePicker = findViewById(R.id.datePicker);
    }

    private void setupAdapters() {
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
    }

    private void setupListeners() {
        spnCollege.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        spnMajor.setAdapter(adapterMajorComputer);
                        break;
                    case 2:
                        spnMajor.setAdapter(adapterMajorElectric);
                        break;
                    case 3:
                        spnMajor.setAdapter(adapterMajorMechanic);
                        break;
                    case 4:
                        spnMajor.setAdapter(adapterMajorMaterial);
                        break;
                    case 5:
                        spnMajor.setAdapter(adapterMajorChemistry);
                        break;
                    default:
                        spnMajor.setAdapter(adapterNoCo);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetFields();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSubmit();
            }
        });
    }

    private void resetFields() {
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

    private void handleSubmit() {
        String name = edtName.getText().toString().trim();
        String studentID = edtStudentID.getText().toString().trim();
        String gender = ((RadioButton) findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
        String college = spnCollege.getSelectedItem().toString();
        String major = spnMajor.getSelectedItem().toString();
        StringBuilder hobbies = new StringBuilder();
        day = datePicker.getDayOfMonth();
        month = datePicker.getMonth();
        year = datePicker.getYear();

        if (chkLiterature.isChecked()) hobbies.append(chkLiterature.getText().toString()).append(" ");
        if (chkSports.isChecked()) hobbies.append(chkSports.getText().toString()).append(" ");
        if (chkMusic.isChecked()) hobbies.append(chkMusic.getText().toString()).append(" ");
        if (chkArt.isChecked()) hobbies.append(chkArt.getText().toString()).append(" ");

        if (name.isEmpty() || studentID.isEmpty() || college.equals("学院") || major.equals("专业") || hobbies.length() == 0) {
            Toast.makeText(ActivityStudent.this, "请将信息补充完整", Toast.LENGTH_SHORT).show();
            Log.w(TAG, "Incomplete information entered");
        } else {
            if (!sids.isEmpty() && sids.contains(studentID)) {
                Toast.makeText(ActivityStudent.this, "学号重复，请重新输入", Toast.LENGTH_SHORT).show();
                Log.w(TAG, "Duplicate student ID entered");
            } else {
                sids.add(studentID);

                // Create a Student object and pass it back
                String date = year + "-" + month + "-" + day;  // Adjust year for Date constructor
                String hobbiesStr = hobbies.toString().trim();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", name);
                resultIntent.putExtra("studentID", studentID);
                resultIntent.putExtra("gender", gender);
                resultIntent.putExtra("college", college);
                resultIntent.putExtra("major", major);
                resultIntent.putExtra("birthDate", date);
                resultIntent.putExtra("hobbies", hobbiesStr);
                Utils.showCustomToast(this, "学生记录添加成功");
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        }
    }
}

