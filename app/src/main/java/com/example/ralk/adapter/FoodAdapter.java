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

import com.example.ralk.FoodDetails;
import com.example.ralk.R;
import com.example.ralk.food_list;
import com.example.ralk.model.Food;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

public class FoodAdapter extends FirebaseRecyclerAdapter<Food,FoodAdapter.foodviewHolder> {



    public FoodAdapter(@NonNull FirebaseRecyclerOptions<Food> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull foodviewHolder holder, @SuppressLint("RecyclerView")int position, @NonNull Food model) {
        Picasso.get().load(model.getImage()).into(holder.Image);
        holder.Name.setText(model.getName());
        System.out.println(model.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodId = getRef(position).getKey();

                System.out.println(foodId);

                Intent menuintent = new Intent(v.getContext(), FoodDetails.class);
                System.out.println("Button Clicked");

                menuintent.putExtra("FoodId",foodId);
                v.getContext().startActivity(menuintent);
            }
        });
    }

    @NonNull

    @Override
    public FoodAdapter.foodviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_food_item, parent, false);
        return new FoodAdapter.foodviewHolder(view);
    }

    class foodviewHolder
            extends RecyclerView.ViewHolder {
        TextView Name;
        ImageView Image;
        public foodviewHolder(@NonNull View itemView)
        {
            super(itemView);

            Name = itemView.findViewById(R.id.food_menu);
            Image = itemView.findViewById(R.id.food_image);


            System.out.println(Name);

        }
    }
}
