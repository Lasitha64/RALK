package com.example.ralk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ralk.database.Database;
import com.example.ralk.model.Food;
import com.example.ralk.model.Order;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class FoodDetails extends AppCompatActivity{

    TextView name,price,description;
    EditText quantity;
    Button add, viewcart;
    ImageView image;

    String foodId="";

    Food currentFood;

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
        viewcart = (Button)findViewById(R.id.btn_cart_view);

        viewcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cartIntent = new Intent(FoodDetails.this,cart.class);
                startActivity(cartIntent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToCart(new Order(
                        foodId,
                        currentFood.getName(),
                        quantity.getText().toString(),
                        currentFood.getPrice()

                ));

                Toast.makeText(FoodDetails.this,"Added to Cart",Toast.LENGTH_LONG).show();
            }
        });

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
            currentFood = snapshot.getValue(Food.class);

            Picasso.get().load(currentFood.getImage()).into(image);
            name.setText(currentFood.getName());
            price.setText(currentFood.getPrice());
            description.setText(currentFood.getDescription());
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });
    }
}
