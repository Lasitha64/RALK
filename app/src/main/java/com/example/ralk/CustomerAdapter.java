package com.example.ralk;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ralk.model.Category;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class CustomerAdapter  extends FirebaseRecyclerAdapter<Category,CustomerAdapter.customerViewholder>{

    public CustomerAdapter(
            @NonNull FirebaseRecyclerOptions<Category> options)
    {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CustomerAdapter.customerViewholder holder, int position, @NonNull Category model) {
        holder.Image.setImageURI(Uri.parse(model.getImage().toString()));
        holder.Name.setText(model.getName());
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

        }
    }
}
