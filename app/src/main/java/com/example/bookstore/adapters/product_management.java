package com.example.bookstore.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstore.R;
import com.example.bookstore.models.ItemOrderModel;

import java.util.ArrayList;

public class product_management extends RecyclerView.Adapter<product_management.MyViewHolder> {
    private Context context;

    private ArrayList<ItemOrderModel> list = new ArrayList<>();

    public product_management(ArrayList<ItemOrderModel> arr, Context context)
    {
        this.list = arr;
        this.context = context;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name, price;
        private ImageView image;

        public MyViewHolder(final View view){

            super(view);
            name = view.findViewById(R.id.nameProduct);
            price = view.findViewById(R.id.priceProduct);
            image = view.findViewById(R.id.imageProduct);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        System.out.println("On create view holder");
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_product_management, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull product_management.MyViewHolder holder, int position) {
        System.out.println("On bind view holder");
        ItemOrderModel item = list.get(position);
        if (item == null)
            return;

        holder.name.setText(item.getNameBook());
        holder.price.setText(String.valueOf(item.getPrice()));
        holder.image.setImageResource(item.getImg());
    }

    @Override
    public int getItemCount() {
        System.out.println("GET ITEM COUNT");
        if (list != null){
            return list.size();
        }
        return 0;
    }
}
