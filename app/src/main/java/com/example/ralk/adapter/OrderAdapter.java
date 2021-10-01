package com.example.ralk.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ralk.R;
import com.example.ralk.model.Request;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.w3c.dom.Text;

public class OrderAdapter extends FirebaseRecyclerAdapter<Request, OrderAdapter.OrderViewHolder> implements View.OnClickListener {

   // OrderAdapter adapter;


    public OrderAdapter(@NonNull FirebaseRecyclerOptions<Request> options) {
        super(options);
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onBindViewHolder(@NonNull OrderViewHolder holder, int position, @NonNull Request model) {
        holder.toderid.setText("adapter.getRef(position).getKey()");
        holder.torderstatus.setText(convertCodeToStatus(model.getStatus()));
        holder.torderaddress.setText(model.getAdddress());
        holder.torderphone.setText(model.getPhone());
    }

    private String convertCodeToStatus(String status) {
        if(status.equals("0"))
            return "Placed";
        else if(status.equals("1"))
            return "On my way";
        else
            return "Shipped";
    }

    @NonNull
    @Override
    public OrderAdapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_layout,parent, false);
        return new OrderAdapter.OrderViewHolder(view);
    }

     class OrderViewHolder extends RecyclerView.ViewHolder {
        public TextView toderid, torderstatus, torderphone, torderaddress;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);

            toderid = (TextView) itemView.findViewById(R.id.order_id);
            torderaddress = (TextView) itemView.findViewById(R.id.order_address);
            torderstatus = (TextView) itemView.findViewById(R.id.order_status);
            torderphone = (TextView) itemView.findViewById(R.id.order_phone);
        }
    }
}
