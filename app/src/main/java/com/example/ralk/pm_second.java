package com.example.ralk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class pm_second extends AppCompatActivity {

    EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button login;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pm_second);

        login = findViewById(R.id.button);
//
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(pm_second.this, PmThree.class));
//            }
//        });
    }
    public void check(View v){
        et1 = findViewById(R.id.editTextTextEmailAddress);
        et2 = findViewById(R.id.editTextTextPassword);

        if(et1.getText().toString().equals("PrMan") && et2.getText().toString().equals("prman123")){
            Toast.makeText(this,"Log in Success",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(pm_second.this, PmThree.class));
        }
        else{
            Toast.makeText(this,"Log in failed",Toast.LENGTH_SHORT).show();
        }
    }
}