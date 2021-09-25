package com.example.ralk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.ralk.databinding.ActivityMainBinding;

public class EnterCatagory extends AppCompatActivity {

    ActivityMainBinding binding;
    ImageView imageNewView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setContentView(R.layout.activity_enter_catagory);


        binding.imageNewView.se
    }
}