package com.example.ralk.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ralk.Delivery_model;
import com.example.ralk.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

public class DeliveryAdapter extends RecyclerView.Adapter<DeliveryAdapter.myViewHolder> {


    private List<Delivery_model> modelListIns = null;

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delivery_item,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        Delivery_model model = modelListIns.get(position);
        holder.orderno.setText(model.getOrderno());
        holder.dpname.setText(model.getDpname());
        holder.dctime.setText(model.getDctime());
    }

    @Override
    public int getItemCount() {
        return modelListIns.size();
    }

    public void submitList(List<Delivery_model> modelList){

        modelListIns = modelList;
        notifyDataSetChanged();
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView orderno,dpname,dctime;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            orderno =(TextView)itemView.findViewById(R.id.orderno);
            dpname =(TextView)itemView.findViewById(R.id.dpname);
            dctime =(TextView)itemView.findViewById(R.id.dctime);
        }
    }


}
