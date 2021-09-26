package com.example.ralk.model;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ralk.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class updateDelivery extends AppCompatActivity {

    Button button41;
    private EditText n, e, m, pass;
    private FirebaseDatabase db = FirebaseDatabase.getInstance("https://ralk-ef10e-default-rtdb.asia-southeast1.firebasedatabase.app/");
    private DatabaseReference dbr;
    private Object OnCompleteListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        n = findViewById(R.id.n);
        e = findViewById(R.id.e);
        m = findViewById(R.id.m);
        button41 = findViewById(R.id.button41);
        button41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = n.getText().toString();
                String email = e.getText().toString();
                String mobile = m.getText().toString();

                updateData(name, email, mobile);
            }

        });
    }

    private void updateData(String name, String email, String mobile) {

        HashMap user = new HashMap();

        user.put("Name", name);
        user.put("Email", email);
        user.put("Mobile", mobile);

        dbr = FirebaseDatabase.getInstance("https://ralk-ef10e-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Delivery Partners");
        dbr.child(email).updateChildren(user).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (task.isSuccessful()) {
                    n.setText("");
                    e.setText("");
                    m.setText("");

                    Toast.makeText(updateDelivery.this,"update success",Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(updateDelivery.this,"update failed",Toast.LENGTH_SHORT).show();


                }
            }


        });


    }


}

