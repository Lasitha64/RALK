package com.example.ralk.cus;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class customer_main extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference category;

    TextView txtname;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //Init Firebase
        database = FirebaseDatabase.getInstance();
        category = database.getReference("Category");
    }
}
