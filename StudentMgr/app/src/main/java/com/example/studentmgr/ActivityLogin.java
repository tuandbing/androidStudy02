package com.example.studentmgr;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityLogin extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private ProgressBar progressBar;
    private Button loginButton;
    private Button register;
    private Map<String, String> userInfo = new HashMap<>();

//    private static List<String> usernames = new ArrayList<>();
//    private static List<String> passwords = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar);
        loginButton = findViewById(R.id.loginButton);
        /*usernames.add("123");
        passwords.add("123");*/
        userInfo.put("123", "123");
        register = findViewById(R.id.register);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogin.this, ActivityRegister.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    private void handleLogin() {
        progressBar.setVisibility(View.VISIBLE);
        loginButton.setEnabled(false);
        validateCredentials();
/*        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                validateCredentials();
            }
        }, 3000); // 3 seconds delay*/
    }

    private void validateCredentials() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (userInfo.containsKey(username) && userInfo.get(username).equals(password)) {
            Intent intent = new Intent(ActivityLogin.this, ActivityAds.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(ActivityLogin.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            loginButton.setEnabled(true);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String username = data.getStringExtra("username");
            String password = data.getStringExtra("password");
            userInfo.put(username, password);
        }
    }
}
