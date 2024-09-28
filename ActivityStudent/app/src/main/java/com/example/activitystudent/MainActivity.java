package com.example.activitystudent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText sid;
    EditText name;
    RadioGroup sex;
    Spinner academy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getMessage();
                sid.setText("");
                name.setText("");
                academy.setSelection(0);
                Toast.makeText(MainActivity.this, "重置成功", Toast.LENGTH_SHORT).show();
            }
        });

        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMessage();
                if (sid.getText().toString().equals("") || name.getText().toString().equals("") || academy.getSelectedItem().toString().equals("") || academy.getSelectedItem().toString().equals("所属学院")) {
                    Toast.makeText(MainActivity.this, "请填写完整", Toast.LENGTH_SHORT).show();
                } else {
                    String msg = "学号: " + sid.getText().toString() + "姓名: " + name.getText().toString() + "性别: " + ((RadioButton) findViewById(sex.getCheckedRadioButtonId())).getText().toString() + "学院: " + academy.getSelectedItem().toString();
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    public void getMessage() {

        sid = findViewById(R.id.sid);
        name = findViewById(R.id.name);
        sex = findViewById(R.id.sex);
        academy = findViewById(R.id.academy);
    }
}