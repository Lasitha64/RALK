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

public class admin extends AppCompatActivity {

    Button button4,button3;



    RecyclerView recyclerView;
    ArrayList<aorder> list;
    aorderadapter aorderadapter;
    FirebaseFirestore db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);

        list=new ArrayList<aorder>();
        aorderadapter=new aorderadapter(admin.this,list);


        recyclerView = findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(aorderadapter);

        db=FirebaseFirestore.getInstance();



        eventChangeListner();


        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(admin.this, empDetails.class));
            }
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(admin.this, apayments.class));
            }
        });

    }

    private void eventChangeListner() {

        db.collection("Orders").orderBy("orderID", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if(error!=null){
                            Log.e("Firestore error",error.getMessage());
                            return;

                        }
                        for(DocumentChange dc:value.getDocumentChanges()){

                            if(dc.getType()==DocumentChange.Type.ADDED){

                                list.add(dc.getDocument().toObject(aorder.class));
                            }
                            aorderadapter.notifyDataSetChanged();
                        }

                    }
                });

    }


}














