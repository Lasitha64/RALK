package com.example.ralk.cus;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ralk.NavActivity;
import com.example.ralk.OrderView;
import com.example.ralk.adapter.CustomerAdapter;
import com.example.ralk.R;
import com.example.ralk.cart;
import com.example.ralk.model.Category;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class customer_main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    CustomerAdapter adapter;
    DatabaseReference mbase;

    private DrawerLayout drawer;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_main );

        //NavBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.nav_view);
        System.out.println("Item selected");
        navView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();




        // Create a instance of the database and get
        // its reference
        mbase = FirebaseDatabase.getInstance("https://ralk-ef10e-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Category");

        RecyclerView recyclerView = findViewById(R.id.recycler1);

        // To display the Recycler view linearly
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));

        // It is a class provide by the FirebaseUI to make a
        // query in the database to fetch appropriate data
        FirebaseRecyclerOptions<Category> options
                = new FirebaseRecyclerOptions.Builder<Category>()
                .setQuery(mbase, Category.class)
                .build();
        // Connecting object of required Adapter class to
        // the Adapter class itself
        adapter = new CustomerAdapter(options);
        // Connecting Adapter class with the Recycler view*/
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

    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        System.out.println(id);

        if(id == R.id.nav_menu){

        }else if(id == R.id.nav_mycart){
            System.out.println("My Cart");
            Intent cartIntent = new Intent(customer_main.this, cart.class);
            startActivity(cartIntent);
        }else if(id == R.id.nav_order_status){
            Intent orderIntent = new Intent(customer_main.this, OrderView.class);
            startActivity(orderIntent);
        }else if(id == R.id.nav_signout){
            Intent signout = new Intent(customer_main.this, activity_customer_login.class);
            signout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(signout);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
