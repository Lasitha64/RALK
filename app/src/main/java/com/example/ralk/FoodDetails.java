package com.example.ralk;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ralk.model.Food;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class FoodDetails extends AppCompatActivity{

    TextView name,price,description;
    EditText quantity;
    Button add;
    ImageView image;

    String foodId="";


    DatabaseReference database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_details);

        database = FirebaseDatabase.getInstance("https://ralk-ef10e-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Foods");

        name = (TextView) findViewById(R.id.txName);
        price = (TextView)  findViewById(R.id.txPrice);
        description = (TextView) findViewById(R.id.txDesc);
        image = (ImageView) findViewById(R.id.imageCat);

        quantity = (EditText) findViewById(R.id.tfQuantity);
        add = (Button) findViewById(R.id.btnadd);

        if(getIntent() != null)
            foodId = getIntent().getStringExtra("FoodId");
        if(!foodId.isEmpty()){
            getDetailFood(foodId);
        }
    }

    private void getDetailFood(String foodId) {
    database.child(foodId).addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            Food food = snapshot.getValue(Food.class);

            Picasso.get().load(food.getImage()).into(image);
            name.setText(food.getName());
            price.setText(food.getPrice());
            description.setText(food.getDescription());
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });
    }
}
