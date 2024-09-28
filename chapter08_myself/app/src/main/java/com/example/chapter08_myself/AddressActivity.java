package com.example.chapter08_myself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AddressActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        ((TextView) findViewById(R.id.name)).setText(bundle.getString("name"));
        ((TextView) findViewById(R.id.phone)).setText(bundle.getString("phone"));
        ((TextView) findViewById(R.id.email)).setText(bundle.getString("email"));
        ((TextView) findViewById(R.id.site)).setText(bundle.getString("address"));


    }


}
