package com.example.ralk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.ralk.adapter.FoodAdapter;
import com.example.ralk.model.Food;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class food_list extends AppCompatActivity {

    FoodAdapter adapter;
    DatabaseReference mbase;






    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list );

        // Create a instance of the database and get
        // its reference
        mbase = FirebaseDatabase.getInstance("https://ralk-ef10e-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Foods");


//        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
//        fab.setOnClickListener((view)->{
//            Intent cartIntent = new Intent(food_list.this,cart.class);
//        });


        RecyclerView recyclerView = findViewById(R.id.recycler_food);

        // To display the Recycler view linearly
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));



        // It is a class provide by the FirebaseUI to make a
        // query in the database to fetch appropriate data

        String categoryid = getIntent().getStringExtra("Categoryid");

       // System.out.println(categoryid);

        Query query = mbase.orderByChild("MenuId").equalTo(categoryid);

        //System.out.println(query);

        FirebaseRecyclerOptions<Food> options
                = new FirebaseRecyclerOptions.Builder<Food>()
                .setQuery(query,Food.class)
                .build();

        System.out.println(options);
        // Connecting object of required Adapter class to
        // the Adapter class itself
        adapter = new FoodAdapter(options);
        // Connecting Adapter class with the Recycler view*/
        //   Log.d("TAG",""+adapter.getItemCount());
       recyclerView.setAdapter(adapter);
    }



    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stoping of the activity
    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }
}