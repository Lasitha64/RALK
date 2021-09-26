package com.example.ralk;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ralk.model.Food;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class PmThree extends AppCompatActivity {

    EditText ProductManagerAddItem_name_of_the_food,ProductManagerAddItem_menu_ID,ProductManagerAddItem_Discription,ProductManagerAddItem_Prise;
    Button button3,button4,button5;
    DatabaseReference reff;
    com.example.ralk.model.Food Food;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pm_three);

        getCount();
        ProductManagerAddItem_name_of_the_food=(EditText)findViewById(R.id.ProductManagerAddItem_name_of_the_food);
        ProductManagerAddItem_menu_ID=(EditText) findViewById(R.id.ProductManagerAddItem_menu_ID);
        ProductManagerAddItem_Discription=(EditText) findViewById(R.id.ProductManagerAddItem_Discription);
        ProductManagerAddItem_Prise=(EditText) findViewById(R.id.ProductManagerAddItem_Prise);
        button3=(Button) findViewById(R.id.button3);
        button4=(Button) findViewById(R.id.button4);
        button5=(Button) findViewById(R.id.button5);

        Food=new Food();

        reff= FirebaseDatabase.getInstance("https://ralk-ef10e-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Food");


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dbid;


                if (count==0){
                    dbid = "1";
                }else{
                    dbid = String.valueOf(count+1);
                }
                int menuId=Integer.parseInt(ProductManagerAddItem_menu_ID.getText().toString());
                Food.setPrice(ProductManagerAddItem_Prise.getText().toString());
                Food.setDescription(ProductManagerAddItem_Discription.getText().toString());
                Food.setName(ProductManagerAddItem_name_of_the_food.getText().toString());
                Food.setMenuId(menuId);

                // reff.push().setValue(Food);
                reff.child(dbid).setValue(Food);
                Toast.makeText(PmThree.this, "data entered", Toast.LENGTH_SHORT).show();

            }
        });


        button4.setOnClickListener(view -> {
            int menuId=Integer.parseInt(ProductManagerAddItem_menu_ID.getText().toString().trim());
            Food.setPrice(ProductManagerAddItem_Prise.getText().toString());
            Food.setDescription(ProductManagerAddItem_Discription.getText().toString());
            Food.setName(ProductManagerAddItem_name_of_the_food.getText().toString());
            Food.setMenuId(menuId);


        });
    }

    public static long count = 0;

    public void getCount(){

        DatabaseReference readRef = FirebaseDatabase.getInstance("https://ralk-ef10e-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Food");
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

//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
        });

    }
}