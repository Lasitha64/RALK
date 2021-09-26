package com.example.ralk.admin;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ralk.R;
import com.example.ralk.adapter.adminCatAdapter;
import com.example.ralk.common.Common;
import com.example.ralk.model.Category;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.security.Key;
import java.util.UUID;

public class updatedelcatadmin extends AppCompatActivity {

    Uri saveUri;
    private final int PICK_IMAGE_REQUEST = 71;


    Button btnselect, btnupload;
    ProgressBar pbar;
    FirebaseStorage storage;
    StorageReference storageReference;
    Category newCategory;
    EditText edtName;
    FirebaseDatabase db;
    DatabaseReference df;
    FirebaseRecyclerAdapter<Category, adminCatAdapter.admincatViewHolder> adapter;
    private Object Key;

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //showUpdateDialog(adapter.getRef(item.getOrder()).getKey(),adapter.getItem(item.getOrder()));
//    }

    //    @Override
//    public boolean onContextItemSelected(@NonNull MenuItem item) {
//
//        if(item.getTitle().equals(Common.UPDATE)){
//            System.out.println("open dialog");
//            showUpdateDialog(adapter.getRef(item.getOrder()).getKey(),adapter.getItem(item.getOrder()));
//        }
//        return super.onContextItemSelected(item);
////        setContentView(R.layout.admin_update);
////
////        db = FirebaseDatabase.getInstance("https://ralk-ef10e-default-rtdb.asia-southeast1.firebasedatabase.app/");
////        df = db.getReference("Category");
////        storage = FirebaseStorage.getInstance();
////        storageReference = storage.getReference();
////
////
////        add = findViewById(R.id.add);
////        upload = findViewById(R.id.uploadeimg);
////        pbar = findViewById(R.id.admincataddpbar);
////        imgname = findViewById(R.id.cattextname);
//    }

    private void showUpdateDialog(String key, Category item) {

//        AlertDialog.Builder alertD = new AlertDialog.Builder(updatedelcatadmin.this);
//        alertD.setTitle("Update Category");
//        alertD.setMessage("Please Fill full information");
//
//        LayoutInflater inflater = this.getLayoutInflater();
//        @SuppressLint("InflateParams") View add_menu_layout = inflater.inflate(R.layout.admin_update,null);
//
//        edtName = add_menu_layout.findViewById(R.id.edtName);
//        btnselect = add_menu_layout.findViewById(R.id.btnselect);
//        btnupload = add_menu_layout.findViewById(R.id.btnupload);
//
//        edtName.setText(item.getName());

//        btnselect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                chooseImage();
//            }
//        });
//
//        btnupload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                changeImage(item);
//            }
//        });

//
//        alertD.setView(add_menu_layout);
//
//        alertD.setPositiveButton("YES", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//                dialog.dismiss();
//            }
//        });
//
//        alertD.setPositiveButton("NO", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//        alertD.show();

    }

    public void changeImage(Category item) {
        if(saveUri != null){
            String imageName = UUID.randomUUID().toString();
            final StorageReference imageFolder = storageReference.child("images/"+imageName);

            imageFolder.putFile(saveUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(updatedelcatadmin.this, "Image Saved", Toast.LENGTH_SHORT).show();
                            imageFolder.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                  item.setImage(uri.toString());
                                  item.setName(edtName.getText().toString());
                                    df.child((String) Key).setValue(item);
                                }
                            });
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(updatedelcatadmin.this, "Failed to upload image", Toast.LENGTH_SHORT).show();
                        }
                    });



        }
    }

    public void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"),PICK_IMAGE_REQUEST);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            saveUri = data.getData();
           // upload.setText("Image Selected");
        }
    }


}
