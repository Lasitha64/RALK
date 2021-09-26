package com.example.ralk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class pm_second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button login;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pm_second);

        login = findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pm_second.this, PmThree.class));
            }
        });
    }
}