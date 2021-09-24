package com.example.ralk;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ralk.model.Deliverylist;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class delivery_manager_main extends AppCompatActivity {

 EditText orderno,dpname,dctime;
 Button button2;
 DatabaseReference reff;
 Deliverylist deliverylist;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate((savedInstanceState));
        setContentView(R.layout.delivery_manager_main);
        orderno=(EditText)findViewById(R.id.orderno);
        dpname=(EditText) findViewById(R.id.dpname);
        dctime=(EditText) findViewById(R.id.dctime);
        button2=(Button) findViewById(R.id.button2);
        deliverylist=new Deliverylist();
        reff= FirebaseDatabase.getInstance("https://ralk-ef10e-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Deliverylist");


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int orderNo=Integer.parseInt(orderno.getText().toString().trim());
                deliverylist.setDpname(dpname.getText().toString());
                deliverylist.setDctime(dctime.getText().toString());
                deliverylist.setOrderno(orderNo);
                reff.push().setValue(deliverylist);
                Toast.makeText(delivery_manager_main.this, "data paka", Toast.LENGTH_SHORT).show();

            }
        });



    }

}
