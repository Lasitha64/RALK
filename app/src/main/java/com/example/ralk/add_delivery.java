package com.example.ralk;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_delivery extends AppCompatActivity {

    private EditText n,e,m,pass;
    private Button button24;

    private FirebaseDatabase db=FirebaseDatabase.getInstance("https://ralk-ef10e-default-rtdb.asia-southeast1.firebasedatabase.app/");
    private DatabaseReference root=db.getReference().child("Delivery Partners");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_delivery);

        n=findViewById(R.id.n);
        e=findViewById(R.id.e);
        m=findViewById(R.id.m);
        pass=findViewById(R.id.pass);
        button24=findViewById(R.id.button24);

        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= n.getText().toString();
                root.child("Name").setValue(name);
            }
        });







    }
    }
