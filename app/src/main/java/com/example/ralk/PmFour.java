package com.example.ralk;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ralk.database.DBHelper;
import com.google.api.Context;

import java.util.ArrayList;
import java.util.List;

public class PmFour extends AppCompatActivity {


    EditText et1, et2, et3, et4;
    //Initialising the variables of buttons
    Button button3,button4,button5;

    ImageView img;
    String e1,e2;
    int e3,e5;
    double e4;
    private Context context;
    private String[] cameraPermisiion;
    private String[] storagePermssion;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pm_three);
//        et1 = findViewById(R.id.ProductManagerAddItem_name_of_the_food);
//        et2 = findViewById(R.id.ProductManagerAddItem_Discription);
//        et3 = findViewById(R.id.ProductManagerAddItem_menu_ID);
//        et4 = findViewById(R.id.ProductManagerAddItem_Prise);
//
//
//        //getting the image
//        img = findViewById(R.id.input_Image);
//        cameraPermisiion =new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
//        storagePermssion = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ActivityCompat.requestPermissions(
//                        PmFour.this,
//                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
//                        PICK_IMAGE_REQUEST
//                );
//            }
//        });

        public void deleteProd1(View view){

            DBHelper dbHelper =  new DBHelper(this);
            List ids = new ArrayList<>();
            ids = dbHelper.deleteProduct();
            dbHelper.deleteProduct((int)ids.get(0));
            finish();
            startActivity(getIntent());
            Toast.makeText(PmFour.this, "Deleted successfully", Toast.LENGTH_SHORT).show();

        }
    }
}




