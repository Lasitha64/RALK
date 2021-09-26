package com.example.ralk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;
public class aorderadapter extends FirebaseRecyclerAdapter<aorder, aorderadapter.MyViewHolder> {
    Context context;
    public aorderadapter(FirebaseRecyclerOptions<aorder> options) {
        super(options);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.aorder,parent,false);
            return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position, aorder model) {
        holder.cusname.setText(model.getCusname());
            holder.address.setText(model.getAdd());
            holder.p.setText(model.getP());
            holder.dp.setText(model.getDp());
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView oid,cusname,address,p,dp;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cusname= itemView.findViewById(R.id.cn);
            address= itemView.findViewById(R.id.ad);
            p= itemView.findViewById(R.id.p);
            dp= itemView.findViewById(R.id.dp);

            System.out.println(oid);
        }
    }
}
