package com.example.ralk;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
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
                getCount();

                String dbid;

                if (count == 0) {
                    dbid = "1";
                } else {
                    dbid = String.valueOf(count + 1);
                }


                String name = n.getText().toString();
                String email = e.getText().toString();
                String mobile = m.getText().toString();
                String password = pass.getText().toString();
                HashMap<String, String> userMap = new HashMap<>();
                userMap.put("Name", name);
                userMap.put("Email", email);
                userMap.put("Mobile", mobile);
                userMap.put("Def Password", password);
                //root.push().setValue(userMap);
                root.child(dbid).setValue(userMap);

            }


        });


    }


    public long count = 0;

    public void getCount() {
        DatabaseReference readRef = FirebaseDatabase.getInstance("https://ralk-ef10e-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Delivery Partners");
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    count = (snapshot.getChildrenCount());
                    Toast.makeText(getApplicationContext(), "Database has " + count + " values", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No source to display", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


}



