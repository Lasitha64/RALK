package com.example.ralk;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ralk.database.DBHelper;
import com.google.api.Context;

import java.util.ArrayList;
import java.util.List;

public class PmFour extends AppCompatActivity {


    EditText et1, et2, et3, et4, et5;


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
        setContentView(R.layout.activity_pm_four);
        et1 = findViewById(R.id.ProductManagerAddItem_name_of_the_food);
        et2 = findViewById(R.id.ProductManagerAddItem_Discription);
        et3 = findViewById(R.id.ProductManagerAddItem_menu_ID);
        et4 = findViewById(R.id.ProductManagerAddItem_Prise);
        //ID ude for delete
        et5 = findViewById(R.id.ProductManagerAddItem_item_ID);

    }

//    Display method

    public void displaymethod(View view) {
        List product = new ArrayList<>();

        DBHelper dbHelper = new DBHelper(this);
        int ids = Integer.parseInt(et5.getText().toString());
        Log.d("error", String.valueOf(ids));
        product = dbHelper.readProduct(ids);

        if (product.size() == 0 || product.size() == 0) {

        } else {
            et1.setText((String) product.get(0));
            et2.setText((String) product.get(1));
            et3.setText((String) product.get(2));
            et4.setText((String) product.get(3));

        }
    }

    //update method

    public void editQty1(View view){
        String t1 = et1.getText().toString();
        String t2 = et2.getText().toString();
        String t3 = et3.getText().toString();
        String t4 = et4.getText().toString();
        String t5 = et5.getText().toString();

        DBHelper dbHelper =  new DBHelper(this);
        int ids = Integer.parseInt(et5.getText().toString());

        //pasing the values
        dbHelper.updateProduct(ids,t1, t2,Integer.parseInt(t3),Double.parseDouble(t4));
        Toast.makeText(PmFour.this, "updated successfully", Toast.LENGTH_SHORT).show();

    }

    //delete method


        public void deleteProd1(View view){


            DBHelper dbHelper = new DBHelper(this);
            int ids = Integer.parseInt(et5.getText().toString());
            dbHelper.deleteProduct(ids);
            finish();
            startActivity(getIntent());
            Toast.makeText(PmFour.this, "Deleted successfully", Toast.LENGTH_SHORT).show();

        }
}




