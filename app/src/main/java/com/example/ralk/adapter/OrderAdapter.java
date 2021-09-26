package com.example.ralk.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ralk.R;

import org.w3c.dom.Text;

public class OrderAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView toderid, torderstatus, torderphone, torderaddress;



    public OrderAdapter(@NonNull View itemView) {
        super(itemView);

        toderid = (TextView) itemView.findViewById(R.id.order_id);
        torderaddress = (TextView) itemView.findViewById(R.id.order_address);
        torderstatus = (TextView) itemView.findViewById(R.id.order_status);
        torderphone = (TextView) itemView.findViewById(R.id.order_phone);
    }

    @Override
    public void onClick(View v) {

    }
}
