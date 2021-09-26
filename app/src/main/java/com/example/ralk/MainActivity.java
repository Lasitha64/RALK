package com.example.ralk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ralk.admin.adminMain;
import com.example.ralk.cus.activity_customer_login;
import com.example.ralk.cus.activity_customer_signup;

public class MainActivity extends AppCompatActivity {

     Button logindp,logincus,signup,loginp,loginad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logindp = findViewById(R.id.btn_logdp);
        logincus = findViewById(R.id.btn_logcus);
        signup = findViewById(R.id.btn_signup);
        logindp = findViewById(R.id.btn_logdp);
        loginad = findViewById(R.id.btn_logAdmin);

        logindp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, delivery_manager_main.class));
            }
        });

        logincus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, activity_customer_login.class));
            }
        });

        loginad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, adminMain.class));
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, activity_customer_signup.class));
            }
        });

        loginad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, adminlogin.class));
            }
        });
    }
}