package com.example.ralk.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.ralk.R;
import com.example.ralk.model.Order;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView cartName, price;
    public ImageView cart_count;



    public CartViewHolder(@NonNull View itemView) {
        super(itemView);
        cartName =(TextView)itemView.findViewById(R.id.cart_item_name);
        price = (TextView) itemView.findViewById(R.id.cart_item_price);
        cart_count = (ImageView)itemView.findViewById(R.id.cart_item_count);
    }

    @Override
    public void onClick(View v) {

    }
}

