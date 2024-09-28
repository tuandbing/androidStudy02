package com.example.studentmgr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityLogin extends AppCompatActivity {
    private EditText editusername;
    private EditText editpassword;
    private Button button;
    private ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editusername = findViewById(R.id.Username);
        editpassword = findViewById(R.id.Password);
        progressBar = findViewById(R.id.progressBar);
        button = findViewById(R.id.Login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.animate().setDuration(3000).start();

                editusername.postDelayed(() ->{
                    String username = editusername.getText().toString();
                    String password = editpassword.getText().toString();

                    if (username.equals("user") && password.equals("123456")){
                        startActivity(new Intent(ActivityLogin.this,MainActivity.class));
                        finish();
                    }else {
                        Toast.makeText(ActivityLogin.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                    }

                    progressBar.setVisibility(View.GONE);
                },3000);

            }
        });

    }

}
