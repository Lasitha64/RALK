package com.example.ralk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ralk.cus.activity_customer_login;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class admin extends AppCompatActivity {

    Button button4;



    RecyclerView recycle_View;

    DatabaseReference database;

    aorderadapter aorderadapter;

    ArrayList<aorder> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);

        button4 = findViewById(R.id.button4);

        recycle_View = (RecyclerView) findViewById(R.id.recycle_View);
        database = FirebaseDatabase.getInstance("https://ralk-ef10e-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Orders");

        // To display the Recycler view linearly
        recycle_View.setLayoutManager(
                new LinearLayoutManager(this));

        // It is a class provide by the FirebaseUI to make a
        // query in the database to fetch appropriate data
        FirebaseRecyclerOptions<aorder> options
                = new FirebaseRecyclerOptions.Builder<aorder>()
                .setQuery(database, aorder.class)
                .build();
        // Connecting object of required Adapter class to
        // the Adapter class itself
        aorderadapter = new aorderadapter(options);
        // Connecting Adapter class with the Recycler view*/
        recycle_View.setAdapter(aorderadapter);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(admin.this, empDetails.class));
            }
        });

    }
        @Override
        protected void onStart()

        {
            super.onStart();
            aorderadapter.startListening();
        }

        // Function to tell the app to stop getting
        // data from database on stoping of the activity
        @Override protected void onStop()
        {
            super.onStop();
            aorderadapter.stopListening();
        }


        }














