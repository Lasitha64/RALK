package com.example.ralk;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ralk.adapter.OrderAdapter;
import com.example.ralk.common.Common;
import com.example.ralk.model.Request;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OrderView extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter<Request, OrderAdapter> adapter;

    FirebaseDatabase database;
    DatabaseReference ref;
    Common com;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_status);

        database = FirebaseDatabase.getInstance("https://ralk-ef10e-default-rtdb.asia-southeast1.firebasedatabase.app/");
        ref = database.getReference("Requests");

        recyclerView = (RecyclerView) findViewById(R.id.listOrders);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);

    //    loadOrders(com.getPhone());

    }

//    private void loadOrders(String phone) {
//        adapter = new FirebaseRecyclerAdapter<Request, OrderAdapter>(
//                Request.class,
//                R.layout.order_status,
//                OrderAdapter.class,
//                ref.orderByChild("phone")
//                .equalTo(phone)
////        )
//        {
//            @Override
//            protected void onBindViewHolder(@NonNull OrderAdapter holder, int position, @NonNull Request model) {
//
//            }
//
//            @NonNull
//            @Override
//            public OrderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                return null;
//            }
//        }
   // }
}
