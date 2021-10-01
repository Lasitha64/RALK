package com.example.ralk.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.ralk.R;
import com.example.ralk.model.Order;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {

    private List<Order> listdata = new ArrayList<>();
    private Context context;

    public CartAdapter(List<Order> listdata, Context context) {
        this.listdata = listdata;
        this.context = context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.cart_layout, parent, false);
        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        TextDrawable drawable = TextDrawable.builder()
                .buildRound("" + listdata.get(position).getQuantity(), Color.RED);
        holder.cart_count.setImageDrawable(drawable);

        Locale locale = new Locale("en" , "LK");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        int price = (Integer.parseInt(listdata.get(position).getPrice())) * (Integer.parseInt(listdata.get(position).getQuantity()));
        holder.price.setText(fmt.format(price));
        holder.cartName.setText(listdata.get(position).getProductName());
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }
}
