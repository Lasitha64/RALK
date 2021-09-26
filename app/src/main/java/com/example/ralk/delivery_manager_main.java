package com.example.ralk;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ralk.model.Deliverylist;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Objects;

public class delivery_manager_main extends AppCompatActivity {

    EditText orderno,dpname,dctime;
    Button button2,button3,btViewList;
    DatabaseReference reff;
    Deliverylist deliverylist;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate((savedInstanceState));
        setContentView(R.layout.delivery_manager_main);
        getCount();
        orderno=(EditText)findViewById(R.id.orderno);
        dpname=(EditText) findViewById(R.id.dpname);
        dctime=(EditText) findViewById(R.id.dctime);
        button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.button3);
        btViewList = (Button) findViewById(R.id.btViewList);

        deliverylist=new Deliverylist();

        reff= FirebaseDatabase.getInstance("https://ralk-ef10e-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Deliverylist");


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dbid;


                if (count==0){
                    dbid = "1";
                }else{
                    dbid = String.valueOf(count+1);
                }
                int orderNo=Integer.parseInt(orderno.getText().toString().trim());
                deliverylist.setDpname(dpname.getText().toString());
                deliverylist.setDctime(dctime.getText().toString());
                deliverylist.setOrderno(orderNo);

               // reff.push().setValue(deliverylist);
                reff.child(dbid).setValue(deliverylist);
                Toast.makeText(delivery_manager_main.this, "data paka", Toast.LENGTH_SHORT).show();

            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int orderNo=Integer.parseInt(orderno.getText().toString().trim());
                deliverylist.setDpname(dpname.getText().toString());
                deliverylist.setDctime(dctime.getText().toString());
                deliverylist.setOrderno(orderNo);


            }
        });

        btViewList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent viewListIntent = new Intent(delivery_manager_main.this,
                        Delivery_manager_retrive.class);
                startActivity(viewListIntent);
             }
        });

    }

    public static long count = 0;

    public void getCount(){

        DatabaseReference readRef = FirebaseDatabase.getInstance("https://ralk-ef10e-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Deliverylist");
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    count = (snapshot.getChildrenCount());

                    Toast.makeText(getApplicationContext(), "Database has "+ count +" values", Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(getApplicationContext(), "No source to display", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
