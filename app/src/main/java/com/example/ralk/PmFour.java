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

import com.example.ralk.model.Food;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class PmFour extends AppCompatActivity {

    //Initialising the variables of text field
    EditText ProductManagerAddItem_item_ID,ProductManagerAddItem_name_of_the_food,ProductManagerAddItem_menu_ID,ProductManagerAddItem_Discription,ProductManagerAddItem_Prise;
    //Initialising the variables of buttons
    Button button3,button4,button5;
    //Initialising the database reference
    DatabaseReference reff;
    //Giving the path of the parent class
    com.example.ralk.model.Food Food;


    //On create function
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pm_four);

        //Assining the values to the variables
        getCount();
        //Text fields
        ProductManagerAddItem_item_ID=(EditText)findViewById(R.id.ProductManagerAddItem_item_ID);
        ProductManagerAddItem_name_of_the_food=(EditText)findViewById(R.id.ProductManagerAddItem_name_of_the_food);
        ProductManagerAddItem_menu_ID=(EditText) findViewById(R.id.ProductManagerAddItem_menu_ID);
        ProductManagerAddItem_Discription=(EditText) findViewById(R.id.ProductManagerAddItem_Discription);
        ProductManagerAddItem_Prise=(EditText) findViewById(R.id.ProductManagerAddItem_Prise);
        //Buttons
        button3=(Button) findViewById(R.id.button3);
        button4=(Button) findViewById(R.id.button4);
        button5=(Button) findViewById(R.id.button5);

        Food=new Food();

        reff= FirebaseDatabase.getInstance("https://ralk-ef10e-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Food");


        //Function of the button 3
        //#Enter De
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String dbid;
//
//
//                if (count==0){
//                    dbid = "1";
//                }else{
//                    dbid = String.valueOf(count+1);
//                }
//                int menuId=Integer.parseInt(ProductManagerAddItem_menu_ID.getText().toString());
//                Food.setPrice(ProductManagerAddItem_Prise.getText().toString());
//                Food.setDescription(ProductManagerAddItem_Discription.getText().toString());
//                Food.setName(ProductManagerAddItem_name_of_the_food.getText().toString());
//                Food.setMenuId(menuId);
//
//                // reff.push().setValue(Food);
//                reff.child(dbid).setValue(Food);
//                Toast.makeText(PmFour.this, "data entered", Toast.LENGTH_SHORT).show();
//
//            }
//        });

        //Read data
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mapdb = ProductManagerAddItem_item_ID.getText().toString();

                reff.child("Food").child(mapdb).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Error getting data", task.getException());

                            Toast.makeText(PmFour.this, "data connected", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Log.d("firebase", String.valueOf(Objects.requireNonNull(task.getResult()).toString()));

                            Toast.makeText(PmFour.this, "data not connected", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });




       // button4.setOnClickListener(new View.OnClickListener() {

      //      private AlertDialog.Builder Review;

//            @Override
//            public void onClick(View view) {
//                //Initializing the variable for the db connection
//                String mapdb = ProductManagerAddItem_item_ID.getText().toString();
//
//                Map<String,Object> map = new HashMap<>();
//
//
//                reff.child(mapdb).setValue(Food);
//                Toast.makeText(PmFour.this, "data entered", Toast.LENGTH_SHORT).show();
//                        reff.child(mapdb).updateChildren(map)
//                        .addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void unused) {
//                                //Toast.makeText(Review.getContext(),"Updated Successfully",Toast.LENGTH_SHORT).show();
//                                Toast.makeText(Review.getContext(),"Update Successful!",Toast.LENGTH_SHORT).show();
//
//                                log.dismiss();
//                            }
//                        })
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(Exception e) {
//                                Toast.makeText(Review.getContext(),"Error While Updating",Toast.LENGTH_SHORT).show();
//                                dialogPlus.dismiss();
//                            }
//                        });
//            }


       // });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PmFour.this, PmFour.class));
            }
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
        
        
        
        


        //Update Functionality
//        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
//                        .setContentHolder(new ViewHolder(R.layout.activity_updates_popups))
//                        .setExpanded(true,1150)
//                        .create();
//
//
//
//                view = dialogPlus.getHolderView();
//
//                EditText Review = view.findViewById(R.id.txtNames);
//                Button btnUpdate = view.findViewById(R.id.btnUpdates);
//
//
//                Review.setText(model.getReview());
//
//                dialogPlus.show();
//
//                btnUpdate.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Map<String,Object> map = new HashMap<>();
//
//
//                        FirebaseDatabase.getInstance().getReference().child()
//                                .child(Objects.requireNonNull(getRef(position).getKey())).updateChildren(map)
//                                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                    @Override
//                                    public void onSuccess(Void unused) {
//                                        //Toast.makeText(Review.getContext(),"Updated Successfully",Toast.LENGTH_SHORT).show();
//                                        Toast.makeText(Review.getContext(),"Update Successful!",Toast.LENGTH_SHORT).show();
//
//                                        dialogPlus.dismiss();
//                                    }
//                                })
//                                .addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(Exception e) {
//                                        Toast.makeText(Review.getContext(),"Error While Updating",Toast.LENGTH_SHORT).show();
//                                        dialogPlus.dismiss();
//                                    }
//                                });
//                    }
//                });
//
//
//
//
//            }
//        });
        
        //kkkkkkkkkkkkkkkkkkkkkkkkkkkkk

    }
}




