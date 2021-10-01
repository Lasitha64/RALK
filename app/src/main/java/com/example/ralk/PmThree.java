package com.example.ralk;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.ralk.database.DBHelper;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;

public class PmThree extends AppCompatActivity {
    public final static int PICK_IMAGE_REQUEST = 999;

//   //Initialising the variables of text field
//   EditText ProductManagerAddItem_name_of_the_food,ProductManagerAddItem_menu_ID,ProductManagerAddItem_Discription,ProductManagerAddItem_Prise;
//    //Initialising the variables of buttons
//    Button button3,button4,button5;
//    //Initialising the database reference
//    DatabaseReference reff;
//    //Giving the path of the parent class
//    com.example.ralk.model.Food Food;



    EditText et1, et2, et3, et4;

    ImageView img;
    String e1,e2;
    int e3,e5;
    double e4;
    private Context context;
    private String[] cameraPermisiion;
    private String[] storagePermssion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pm_three);
        //Initialize variable
        et1 = findViewById(R.id.ProductManagerAddItem_name_of_the_food);
        et2 = findViewById(R.id.ProductManagerAddItem_Discription);
        et3 = findViewById(R.id.ProductManagerAddItem_menu_ID);
        et4 = findViewById(R.id.ProductManagerAddItem_Prise);


        //getting the image
        img = findViewById(R.id.input_Image);
        cameraPermisiion =new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermssion = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        PmThree.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PICK_IMAGE_REQUEST
                );
            }
        });
    }

    public void savenewProduct(View view){
        e1 = et1.getText().toString();
        e2 = et2.getText().toString();
        try {
            e3 = Integer.parseInt(et3.getText().toString());
        } catch (NumberFormatException e) {
            finish();
            startActivity(getIntent());
            Toast.makeText(PmThree.this, "Please enter mane id", Toast.LENGTH_SHORT).show();
        }
        e4 = Double.parseDouble(et4.getText().toString());

        byte[] image1 = imageViewToByte(img);
        DBHelper dbHelper =  new DBHelper(this);
        Log.d("ei:",String.valueOf(e1));
        if(e1.isEmpty()){
            Toast.makeText(this,"Enter Name", Toast.LENGTH_SHORT).show();
        }else{
            dbHelper.addProductShop(e1,e2,e3,e4,image1);
            Toast.makeText(PmThree.this, "Saved successfully", Toast.LENGTH_SHORT).show();
        }
    }


    //Converting the image
    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }


    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PICK_IMAGE_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //gallery intent
                Intent gallertIntent = new Intent(Intent.ACTION_GET_CONTENT);
                gallertIntent.setType("image/*");
                startActivityForResult(gallertIntent, PICK_IMAGE_REQUEST);
            } else {
            }
            return;
        }
    }


    //Crop the image
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==PICK_IMAGE_REQUEST && resultCode ==RESULT_OK){
            Uri imageUri = data.getData();
            CropImage.activity(imageUri)
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(2,1)
                    .start(this);
        }
        if(requestCode== CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if(resultCode ==RESULT_OK){
                Uri resultUri = result.getUri();
                //set image choose from gallery to image view
                img.setImageURI(resultUri);
            }else if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error = result.getError();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    /*next button*/
    public void next(View v) {
        startActivity(new Intent(PmThree.this, PmFour.class));
    }

}