package com.example.ralk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
public class add_delivery extends AppCompatActivity {
    private EditText n,e,m,pass;
    private Button button24;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_delivery);
        n=findViewById(R.id.n);
        e=findViewById(R.id.e);
        m=findViewById(R.id.m);
        pass=findViewById(R.id.pass);

        db=FirebaseFirestore.getInstance();

        button24=findViewById(R.id.button24);
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String name = n.getText().toString();
                String email = e.getText().toString();
                String mobile = m.getText().toString();
                String password = pass.getText().toString();

                saveToFireStore(name,email,mobile,password);

                startActivity(new Intent(add_delivery.this, delivery.class));
            }


                ;



        });


    }

    private void saveToFireStore(String name, String email, String mobile, String password) {
        if(!name.isEmpty() && !email.isEmpty() && !mobile.isEmpty() &&  !password.isEmpty()){

            HashMap<String , Object> map = new HashMap<>();
            map.put("Name" , name);
            map.put("Email" , email);
            map.put("Mobile" , mobile);
            map.put("Password" , password);

            db.collection("Delivery Partners").document(name).set(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(add_delivery.this, "Data Added !!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(add_delivery.this, "Failed !!", Toast.LENGTH_SHORT).show();

                }
            });

        }else{
            Toast.makeText(this, "Empty Fields not Allowed", Toast.LENGTH_SHORT).show();
    }


    }





    }






