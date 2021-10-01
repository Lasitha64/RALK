package com.example.ralk;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ralk.cus.activity_customer_login;
import com.google.android.material.navigation.NavigationView;

public class NavActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_main);

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
            Intent cartIntent = new Intent(NavActivity.this,cart.class);
            startActivity(cartIntent);
        }else if(id == R.id.nav_order_status){
            Intent orderIntent = new Intent(NavActivity.this,OrderView.class);
            startActivity(orderIntent);
        }else if(id == R.id.nav_signout){
            Intent signout = new Intent(NavActivity.this, activity_customer_login.class);
            signout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(signout);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
