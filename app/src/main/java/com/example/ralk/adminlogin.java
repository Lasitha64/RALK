package com.example.ralk;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import  com.example.ralk.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class adminlogin extends AppCompatActivity {

    EditText etusname, etpass;
    Button blogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminlogin);

        etusname = (EditText) findViewById(R.id.logusname);
        etpass = (EditText) findViewById(R.id.logpass);
        blogin = (Button) findViewById(R.id.btnlog);

        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check();

            }
        });
    }

    public void check(){
        if(etusname.getText().toString().equals("admin") && etpass.getText().toString().equals("admin123*")){
            Toast.makeText(this,"Log in Success",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(adminlogin.this, admin.class));
        }
        else{
            Toast.makeText(this,"Log in failed",Toast.LENGTH_SHORT).show();
        }
    }
}