package com.example.ralk;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class aorderadapter extends RecyclerView.Adapter<aorderadapter.MyViewHolder> {

    Context context;
    ArrayList<aorder> aorderArrayList;

    public aorderadapter(Context context, ArrayList<aorder> aorderArrayList) {

        this.context = context;
        this.aorderArrayList = aorderArrayList;
    }

    @NonNull
    @Override
    public aorderadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.aorder, parent, false);
        return new MyViewHolder(v);


    }

    @Override
    public void onBindViewHolder(@NonNull aorderadapter.MyViewHolder holder, int position) {

        aorder ao = aorderArrayList.get(position);

        holder.oid.setText(ao.orderID);
        holder.cusname.setText(ao.CusName);
        holder.address.setText(ao.Address);
        holder.p.setText(String.valueOf(ao.Price));
        holder.mp.setText(String.valueOf(ao.Mobile));

    }

    @Override
    public int getItemCount() {
        return aorderArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView oid, cusname, address, p, mp;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            oid = itemView.findViewById(R.id.dpid);
            cusname = itemView.findViewById(R.id.dpn);
            address = itemView.findViewById(R.id.dpe);
            p = itemView.findViewById(R.id.p);
            mp = itemView.findViewById(R.id.dpm);



        }
    }
}