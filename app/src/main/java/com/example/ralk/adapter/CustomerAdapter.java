package com.example.ralk.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ralk.R;
import com.example.ralk.food_list;
import com.example.ralk.model.Category;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;


public class CustomerAdapter  extends FirebaseRecyclerAdapter<Category,CustomerAdapter.customerViewholder>{

    public CustomerAdapter(
            @NonNull FirebaseRecyclerOptions<Category> options)
    {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CustomerAdapter.customerViewholder holder, @SuppressLint("RecyclerView") int position, @NonNull Category model) {
        Picasso.get().load(model.getImage()).into(holder.Image);
        holder.Name.setText(model.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String categoryid = getRef(position).getKey();

                System.out.println(categoryid);

                Intent menuintent = new Intent(v.getContext(), food_list.class);
                System.out.println("Button Clicked");

               menuintent.putExtra("Categoryid",categoryid);
                v.getContext().startActivity(menuintent);
            }
        });

    }

    @NonNull
    @Override
    public CustomerAdapter.customerViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view =  LayoutInflater.from(parent.getContext())
               .inflate(R.layout.category_list, parent, false);
        return new CustomerAdapter.customerViewholder(view);
    }

    class customerViewholder
            extends RecyclerView.ViewHolder {
        TextView Name;
        ImageView Image;



        public customerViewholder(@NonNull View itemView)
        {
            super(itemView);

            Name = itemView.findViewById(R.id.menu_text);
            Image = itemView.findViewById(R.id.menu_image);

            System.out.println(Name);

        }



    }
}
