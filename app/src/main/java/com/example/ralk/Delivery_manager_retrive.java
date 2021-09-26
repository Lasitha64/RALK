package com.example.ralk;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ralk.adapter.DeliveryAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Delivery_manager_retrive extends AppCompatActivity {

    RecyclerView recyclerView;
    DeliveryAdapter deliveryAdapter = new DeliveryAdapter();
    List<Delivery_model> deliveryModel = new ArrayList();
    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_manager_retrive);

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // getting data from firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance("https://ralk-ef10e-default-rtdb.asia-southeast1.firebasedatabase.app/");
        DatabaseReference ref = database.getReference("Deliverylist");

        // Attach a listener to read the data at our posts reference
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot: snapshot.getChildren()) {

                    Delivery_model movedComment = postSnapshot.getValue(Delivery_model.class);
                    deliveryModel.add(movedComment);
                }

                deliveryAdapter.submitList(deliveryModel);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }


    @Override
    protected void onStart() {
        super.onStart();
//        deliveryAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
//        deliveryAdapter.stopListening();
    }
}
