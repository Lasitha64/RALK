package com.example.ralk.adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ralk.LoginDeliveryManager;
import com.example.ralk.MainActivity;
import com.example.ralk.R;
import com.example.ralk.admin.adminList;
import com.example.ralk.admin.updatedelcatadmin;
import com.example.ralk.common.Common;
import com.example.ralk.food_list;
import com.example.ralk.model.Category;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;
import com.squareup.picasso.Picasso;


public class adminCatAdapter  extends FirebaseRecyclerAdapter<Category,adminCatAdapter.admincatViewHolder>{

    public adminCatAdapter(
            @NonNull FirebaseRecyclerOptions<Category> options)
    {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull adminCatAdapter.admincatViewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull Category model) {
        Picasso.get().load(model.getImage()).into(holder.Image);
        holder.Name.setText(model.getName());

        holder.updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    final DialogPlus dialogPlus =  DialogPlus.newDialog(holder.updatebutton.getContext())
                            .setContentHolder(new ViewHolder(R.layout.admin_update))
                            .setExpanded(true, 1100)
                            .create();



                    View myview = dialogPlus.getHolderView();
                EditText name = myview.findViewById(R.id.edtName);
                Button btnselect = myview.findViewById(R.id.btnselect);
                Button btnupload = myview.findViewById(R.id.btnupload);

                name.setText(model.getName());

                dialogPlus.show();
                updatedelcatadmin update = new updatedelcatadmin();
                btnselect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        update.changeImage(model);


                    }
                });

                btnupload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        update.chooseImage();

                    }
                });


            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String categoryid = getRef(position).getKey();

                System.out.println(categoryid);

                Intent menuintent = new Intent(v.getContext(), adminList.class);
                System.out.println("Button Clicked");

                menuintent.putExtra("Categoryid",categoryid);
                v.getContext().startActivity(menuintent);
            }
        });

    }

    @NonNull
    @Override
    public adminCatAdapter.admincatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.admin_item, parent, false);
        return new adminCatAdapter.admincatViewHolder(view);
    }

    public class admincatViewHolder
            extends RecyclerView.ViewHolder {
        TextView Name;
        ImageView Image;
        Button updatebutton,deletebutton;
        FirebaseRecyclerAdapter<Category, adminCatAdapter.admincatViewHolder> adapter;
        private MenuItem item;


        public admincatViewHolder(@NonNull View itemView)
        {
            super(itemView);



            Name = itemView.findViewById(R.id.food_menu);
            Image = itemView.findViewById(R.id.food_image);
            updatebutton = itemView.findViewById(R.id.updatebutton);
            deletebutton =itemView.findViewById(R.id.deletebutton);





        }











    }
}
