package com.example.chapter08_myself;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main01);

        TextView forget = (TextView) findViewById(R.id.wang_mima);

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ForgetActivity.class);
                startActivity(intent);
            }
        });


    }
}*/
/*

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main02);

        Button btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddressActivity.class);
                Bundle bundle = new Bundle();

                // 省份
                String province = ((EditText)findViewById(R.id.et_site1)).getText().toString();

                // 市区
                String city = ((EditText)findViewById(R.id.et_site2)).getText().toString();

                // 详细住址
                String address = ((EditText)findViewById(R.id.et_site3)).getText().toString();

                // 姓名
                String name = ((EditText)findViewById(R.id.et_name)).getText().toString();

                // 电话
                String phone = ((EditText)findViewById(R.id.et_phone)).getText().toString();

                // 邮箱
                String email = ((EditText)findViewById(R.id.et_email)).getText().toString();

                if (province.isEmpty() || city.isEmpty() || address.isEmpty() || name.isEmpty() || phone.isEmpty() || email.isEmpty()) {

                }else{
                    bundle.putCharSequence("address", province+city+address);
                    bundle.putCharSequence("name", name);
                    bundle.putCharSequence("phone", phone);
                    bundle.putCharSequence("email", email);

                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }
}
*/


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main03);

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HeadActivity.class);
                startActivityForResult(intent, 0x11);
            }
        });

    }
}


