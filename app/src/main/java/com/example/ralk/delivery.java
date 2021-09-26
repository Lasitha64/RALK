package com.example.ralk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ralk.model.updateDelivery;

public class delivery extends AppCompatActivity {

    Button button37,button14;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery);

        button37 = findViewById(R.id.button37);

        button37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(delivery.this, add_delivery.class));
            }
        });

        button14 = findViewById(R.id.button14);

        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(delivery.this, updateDelivery.class));
            }
        });


    }
}