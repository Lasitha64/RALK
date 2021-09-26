package com.example.ralk.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ralk.LoginDeliveryManager;
import com.example.ralk.MainActivity;
import com.example.ralk.R;
import com.example.ralk.cus.activity_customer_login;

public class adminMain extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_main);

        Button add, updatedel;

        add = findViewById(R.id.addcat);
        updatedel = findViewById(R.id.updatecat);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(adminMain.this, addcatadmin.class));
            }
        });

        updatedel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(adminMain.this, adminList.class));
            }
        });
    }
}
