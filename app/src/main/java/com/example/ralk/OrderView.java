package com.example.ralk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ralk.adapter.FoodAdapter;
import com.example.ralk.adapter.OrderAdapter;
import com.example.ralk.common.Common;
import com.example.ralk.model.Food;
import com.example.ralk.model.Request;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class OrderView extends AppCompatActivity {

    public RecyclerView recyclerView;





    DatabaseReference mbase;
    OrderAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_status);

        mbase = FirebaseDatabase.getInstance("https://ralk-ef10e-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Requests");


        RecyclerView recyclerView = findViewById(R.id.listOrders);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));

      //  String phone = Common.currentUser.getPhone();

     //   System.out.println("phone");
     //   Query query = ref.orderByChild("phone").equalTo(phone);

        FirebaseRecyclerOptions<Request> options
                = new FirebaseRecyclerOptions.Builder<Request>()
                .setQuery(mbase,Request.class)
                .build();

        adapter = new OrderAdapter(options);
        recyclerView.setAdapter(adapter);


    }


}
