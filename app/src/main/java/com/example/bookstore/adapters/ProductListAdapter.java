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
    private OnProductListener mOnProductListener;
    public ProductListAdapter( ArrayList<Product> productList, OnProductListener onProductListener) {
        this.productList = productList;
        this.mOnProductListener = onProductListener;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_onlist_layout, parent, false);
        return new ViewHolder(view,  mOnProductListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product data = productList.get(position);
        holder.imageProduct.setImageResource(R.mipmap.img);
        holder.nameProduct.setText(data.getName());
        holder.price.setText(data.getPrice() + " vnđ");
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageProduct;
        TextView nameProduct;
        TextView price;
        OnProductListener onProductListener;
        ViewHolder(View v, OnProductListener onProductListener) {
            super(v);
            imageProduct = v.findViewById(R.id.imageProductonList);
            nameProduct = v.findViewById(R.id.nameProductonList);
            price = v.findViewById(R.id.priceProductonList);
            this.onProductListener = onProductListener;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
           onProductListener.onProductClick(getAdapterPosition());
        }
    }
    public interface OnProductListener{
        void onProductClick(int positionProduct);
    }
}
