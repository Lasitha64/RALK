package com.example.ralk;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;

public class updateDelivery extends AppCompatActivity {

    Button button41;
    private EditText un, ue, um, udpid;
    private FirebaseFirestore db;
    private Object OnCompleteListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        udpid = findViewById(R.id.udpid);
        un = findViewById(R.id.un);
        ue = findViewById(R.id.ue);
        um = findViewById(R.id.um);

        db = FirebaseFirestore.getInstance();
        button41 = findViewById(R.id.button41);
        button41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String DP_ID = udpid.getText().toString();
                String Name = un.getText().toString();
                String Email = ue.getText().toString();
                String Mobile = um.getText().toString();

                updateData(DP_ID, Name, Email, Mobile);
            }

        });
    }

    private void updateData(String DP_ID, String Name, String Email, String Mobile) {
        if (!Name.isEmpty() || !Email.isEmpty() || Mobile.isEmpty()) {

            HashMap<String, Object> user = new HashMap<>();
            user.put("DP_ID", DP_ID);
            user.put("Name", Name);
            user.put("Email", Email);
            user.put("Mobile", Mobile);

            db.collection("Delivery Partners").whereEqualTo("DP_ID",DP_ID  )
                    .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful() && !task.getResult().isEmpty()) {

                        DocumentSnapshot documentSnapshot = task.getResult().getDocuments().get(0);
                        String documentID = documentSnapshot.getId();
                        db.collection("Delivery Partners")
                                .document(documentID)
                                .update(user)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(updateDelivery.this, "Data Updated !!", Toast.LENGTH_SHORT).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(updateDelivery.this, "Data not Updated !!", Toast.LENGTH_SHORT).show();
                            }
                        });

                    } else {
                        Toast.makeText(updateDelivery.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }


            });

        }

    }

}
