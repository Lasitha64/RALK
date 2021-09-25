package com.example.ralk;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProductManagerAddItem extends AppCompatActivity implements View.OnClickListener {
    private static final int PICK_IMAGE = 1;
    ImageView inputImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_manager_add_item);
        inputImageView=(ImageView)findViewById(R.id.input_Image);


        inputImageView.setOnClickListener((View.OnClickListener) this);
    }
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        Intent data = result.getData();
                        //provide crashing
                        assert data != null;
                        inputImageView.setImageURI(data.getData());;
                    }
                }
            });
    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.input_Image) {// Do something
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            someActivityResultLauncher.launch(Intent.createChooser(intent, "Select Picture"));
            //someActivityResultLauncher.launch(intent);
        }

    }

}