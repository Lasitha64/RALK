package com.example.ralk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ralk.deliveryView;

import java.util.ArrayList;

public class deliveryAdapter extends RecyclerView.Adapter<deliveryAdapter.MyViewHolder> {

    Context context;
    ArrayList<deliveryView> deliveryViewArrayList;

    public deliveryAdapter(Context context, ArrayList<deliveryView> deliveryViewArrayList) {

        this.context = context;
        this.deliveryViewArrayList = deliveryViewArrayList;
    }

    @NonNull
    @Override
    public deliveryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.deliverycard, parent, false);
        return new MyViewHolder(v);


    }

    @Override
    public void onBindViewHolder(@NonNull deliveryAdapter.MyViewHolder holder, int position) {

        deliveryView dv = deliveryViewArrayList.get(position);

        holder.dpid.setText(dv.DP_ID);
        holder.dpn.setText(dv.Name);
        holder.dpe.setText(dv.Email);
        holder.dpm.setText(dv.Mobile);


    }

    @Override
    public int getItemCount() {
        return deliveryViewArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView dpid, dpn, dpe, dpm;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            dpid = itemView.findViewById(R.id.dpid);
            dpn = itemView.findViewById(R.id.dpn);
            dpe = itemView.findViewById(R.id.dpe);
            dpm = itemView.findViewById(R.id.dpm);


        }
    }

}