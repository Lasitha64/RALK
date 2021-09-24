package com.example.ralk.cus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ralk.MainActivity;
import com.example.ralk.R;
import com.example.ralk.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class activity_customer_signup extends AppCompatActivity {

    EditText etname, etemail, etphone, etpass, etrpass, ethouse, etcity;
    Button bsignup,blogin;
    private FirebaseAuth mAuth;
    ProgressBar pbar;
    FirebaseFirestore fStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_signup);

        etname = findViewById(R.id.tname);
        etemail = findViewById(R.id.temail);
        etphone = findViewById(R.id.tphone);
        etpass = findViewById(R.id.tpass);
        etrpass = findViewById(R.id.trpass);
        ethouse = findViewById(R.id.thouseno);
        etcity = findViewById(R.id.tcity);
        bsignup= findViewById(R.id.bsignupcus);
        blogin   = findViewById(R.id.btnlogin);

        mAuth = FirebaseAuth.getInstance();;

        pbar = findViewById(R.id.progressBar2);

        if (mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), customer_main.class));

        }

        bsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etname.getText().toString();
                String email = etemail.getText().toString();
                String phone = etphone.getText().toString();
                String password = etpass.getText().toString().trim();
                String rpassword = etrpass.getText().toString().trim();
                String houseno = ethouse.getText().toString();
                String city = etcity.getText().toString();

                System.out.println(rpassword +"  "+ password);

                if(TextUtils.isEmpty(name)){
                    etname.setError("Name is Required");
                    etname.requestFocus();
                }
                 if(TextUtils.isEmpty(email)){
                    etemail.setError("Email is Required");
                    etemail.requestFocus();
                }
                 if(!email.matches( "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
                    etemail.setError("Invalid email format");
                    etemail.requestFocus();
                }
                 if(!(phone.length()==10)){
                    etphone.setError("Invalid telephone number format");
                    etphone.requestFocus();
                }
                 if(TextUtils.isEmpty(password)){
                    etpass.setError("Password is required");
                    etpass.requestFocus();
                }
                 if(TextUtils.isEmpty(rpassword) ){
                    etrpass.setError("Retype Password");
                    etrpass.requestFocus();
                }
                 if(password.length() < 6){
                     etpass.setError("Password is too short");
                     etrpass.requestFocus();
                 }
//                 if (password != rpassword ){
//                    etrpass.setError("Miss match with the password");
//                    etrpass.requestFocus();
               // }
                 if(TextUtils.isEmpty(houseno)){
                    ethouse.setError("House number is Required");
                    ethouse.requestFocus();
                }
                 if(TextUtils.isEmpty(city)){
                    etcity.setError("House number is Required");
                    etcity.requestFocus();
                }

                    pbar.setVisibility(View.VISIBLE);
                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull  Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                User user = new User(name, email, phone, password, rpassword, houseno, city);

                                Task<Void> database = FirebaseDatabase.getInstance("https://ralk-ef10e-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Users")
                                        .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(activity_customer_signup.this, "User Created", Toast.LENGTH_LONG).show();
                                            pbar.setVisibility(View.GONE);
                                        } else {
                                            Toast.makeText(activity_customer_signup.this, "Failed to create user", Toast.LENGTH_LONG).show();
                                            pbar.setVisibility(View.GONE);
                                        }
                                    }
                                });


                            } else {
                                Toast.makeText(activity_customer_signup.this, "Failed with createUser func"+task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                pbar.setVisibility(View.GONE);
                            }
                        }
                    });


            }
        });

        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_customer_signup.this, activity_customer_login.class));
            }
        });

    }

}