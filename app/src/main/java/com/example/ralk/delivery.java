package com.example.ralk;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class delivery extends AppCompatActivity {

    Button button37,button16;

    RecyclerView recyclerView;
    ArrayList<deliveryView> list;
    deliveryAdapter deliveryAdapter ;
    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery);

        list=new ArrayList<deliveryView>();
        deliveryAdapter=new deliveryAdapter(delivery.this,list);


        recyclerView = findViewById(R.id.drecycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(deliveryAdapter);

        db=FirebaseFirestore.getInstance();



        eventChangeListner();


        button37 = findViewById(R.id.button37);

        button37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(delivery.this, add_delivery.class));
            }
        });

        button16 = findViewById(R.id.button16);

        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(delivery.this, updateDelivery.class));
            }
        });





    }

    private void eventChangeListner() {

        db.collection("Delivery Partners").orderBy("DP_ID", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if(error!=null){
                            Log.e("Firestore error",error.getMessage());
                            return;

                        }
                        for(DocumentChange dc:value.getDocumentChanges()){

                            if(dc.getType()==DocumentChange.Type.ADDED){

                                list.add(dc.getDocument().toObject(deliveryView.class));
                            }
                            deliveryAdapter.notifyDataSetChanged();
                        }

                    }
                });


    }
}