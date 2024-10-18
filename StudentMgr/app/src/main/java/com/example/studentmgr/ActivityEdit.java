package com.example.studentmgr;

import android.content.Intent;
import android.os.Bundle;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityEdit extends AppCompatActivity {

    private EditText edtName, edtStudentID;
    private RadioGroup radioGroupGender;
    private RadioButton rbtnMale, rbtnFemale;
    private Spinner spnCollege, spnMajor;
    private CheckBox chkLiterature, chkSports, chkMusic, chkArt;
    private Button btnSubmit, btnReset;
    private DatePicker datePicker;
    private int day, month, year;

    private ArrayAdapter<CharSequence> adapterCollege, adapterMajorComputer, adapterMajorElectric, adapterMajorMechanic, adapterMajorMaterial, adapterMajorChemistry, adapterNoCo;

    private int studentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

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
        datePicker = findViewById(R.id.datePicker);

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

        Intent intent = getIntent();
        studentIndex = intent.getIntExtra("studentIndex", -1);

        String name = intent.getStringExtra("name");
        String studentID = intent.getStringExtra("studentID");
        String gender = intent.getStringExtra("gender");
        String college = intent.getStringExtra("college");
        String major = intent.getStringExtra("major");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthDate = dateFormat.format(intent.getSerializableExtra("birthDate"));
        String hobbies = intent.getStringExtra("hobbies");


        edtName.setText(name);
        edtStudentID.setText(studentID);

        if (gender != null) {
            if (gender.equals("男")) {
                radioGroupGender.check(rbtnMale.getId());
            } else {
                radioGroupGender.check(rbtnFemale.getId());
            }
        }

        if (birthDate != null) {
            String[] date = birthDate.split("-");
            day = Integer.parseInt(date[2]);
            month = Integer.parseInt(date[1]);
            year = Integer.parseInt(date[0]);
            datePicker.updateDate(year, month - 1, day);
        }

        spnCollege.setSelection(adapterCollege.getPosition(college));

        if (hobbies != null) {
            if (hobbies.contains("文学")) chkLiterature.setChecked(true);
            if (hobbies.contains("体育")) chkSports.setChecked(true);
            if (hobbies.contains("音乐")) chkMusic.setChecked(true);
            if (hobbies.contains("美术")) chkArt.setChecked(true);
        }

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
                if (major != null) {
                    spnMajor.setSelection(((ArrayAdapter) spnMajor.getAdapter()).getPosition(major));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnReset.setOnClickListener(view -> {
            edtName.setText("");
            edtStudentID.setText("");
            radioGroupGender.check(R.id.rbtnMale);
            spnCollege.setSelection(0);
            spnMajor.setSelection(0);
            chkLiterature.setChecked(false);
            chkSports.setChecked(false);
            chkMusic.setChecked(false);
            chkArt.setChecked(false);
            Toast.makeText(ActivityEdit.this, "重置成功", Toast.LENGTH_SHORT).show();
        });

        btnSubmit.setOnClickListener(v -> {
            String name1 = edtName.getText().toString();
            String studentID1 = edtStudentID.getText().toString();
            String gender1 = ((RadioButton) findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
            String college1 = spnCollege.getSelectedItem().toString();
            String major1 = spnMajor.getSelectedItem().toString();
            StringBuilder hobbies1 = new StringBuilder();
            day = datePicker.getDayOfMonth();
            month = datePicker.getMonth();
            year = datePicker.getYear();
            String date = year + "-" + month + "-" + day;
            if (chkLiterature.isChecked()) hobbies1.append(chkLiterature.getText().toString()).append(" ");
            if (chkSports.isChecked()) hobbies1.append(chkSports.getText().toString()).append(" ");
            if (chkMusic.isChecked()) hobbies1.append(chkMusic.getText().toString()).append(" ");
            if (chkArt.isChecked()) hobbies1.append(chkArt.getText().toString()).append(" ");

            if (name1.isEmpty() || studentID1.isEmpty() || college1.equals("学院") || major1.equals("专业") || hobbies1.length() == 0) {
                Toast.makeText(ActivityEdit.this, "请将信息补充完整", Toast.LENGTH_SHORT).show();
            } else {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", name1);
                resultIntent.putExtra("studentID", studentID1);
                resultIntent.putExtra("gender", gender1);
                resultIntent.putExtra("college", college1);
                resultIntent.putExtra("major", major1);
                resultIntent.putExtra("birthDate", date);
                resultIntent.putExtra("hobbies", hobbies1.toString());
                resultIntent.putExtra("position", getIntent().getIntExtra("position", -1));
                resultIntent.putExtra("studentIndex", studentIndex);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
