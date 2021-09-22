package com.example.ralk.cus;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ralk.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class activity_customer_login extends AppCompatActivity {

    EditText etemail, etpass;
    Button bsignup, blogin;
    FirebaseAuth fAuth;
    ProgressBar pbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);

        etemail = (EditText) findViewById(R.id.logemail);
        etpass = (EditText) findViewById(R.id.logpass);
        fAuth = FirebaseAuth.getInstance();
        blogin = (Button) findViewById(R.id.btnlog);
        bsignup = (Button) findViewById(R.id.btnsignup);
        pbar = (ProgressBar) findViewById(R.id.progressBar);

        fAuth = FirebaseAuth.getInstance();

        bsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_customer_login.this, activity_customer_signup.class));
            }
        });

        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etemail.getText().toString().trim();
                String password = etpass.getText().toString().trim();

//                if (TextUtils.isEmpty(email)) {
//                    etemail.setError("Email is Required.");
//                    etemail.requestFocus();
//                }
//                if (TextUtils.isEmpty(password)) {
//                    etpass.setError("Password is Required.");
//                    etpass.requestFocus();
//                }
//                if (password.length() < 10) {
//                    etpass.setError("Password Must be 10 Characters");
//                    etpass.requestFocus();
//                }
                pbar.setVisibility(View.VISIBLE);

                // authenticate the user

                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(activity_customer_login.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), customerMainView.class));
                        } else {
                            Toast.makeText(activity_customer_login.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            pbar.setVisibility(View.GONE);
                        }

                    }
                });
            }
        });


    }













}