package com.example.bookstore.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstore.R;
import com.example.bookstore.models.Product;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by reiko-lhnhat on 12/1/2021.
 */
public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {
    private ArrayList<Product> productList;

    public ProductListAdapter( ArrayList<Product> productList) {
        this.productList = productList;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_onlist_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product data = productList.get(position);
        Random rnd = new Random();
        int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.imageProduct.setImageResource(R.mipmap.img);
        holder.nameProduct.setText(data.getName());
        holder.price.setText(data.getPrice() + " vnđ");
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageProduct;
        TextView nameProduct;
        TextView price;
        ViewHolder(View v) {
            super(v);
            imageProduct = v.findViewById(R.id.imageProductonList);
            nameProduct = v.findViewById(R.id.nameProductonList);
            price = v.findViewById(R.id.priceProductonList);
        }
    }
}
