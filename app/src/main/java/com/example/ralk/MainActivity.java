package com.example.ralk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ralk.cus.activity_customer_login;
import com.example.ralk.cus.activity_customer_signup;

public class MainActivity extends AppCompatActivity {

     Button logindp,logincus,signup,loginp,loginad,logpm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logindp = findViewById(R.id.btn_logdp);
        logincus = findViewById(R.id.btn_logcus);
        signup = findViewById(R.id.btn_signup);
        logpm = findViewById(R.id.btn_logpm);
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

        logpm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, activity_product_manager_main_page.class));
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, activity_customer_signup.class));
            }
        });
    }
}