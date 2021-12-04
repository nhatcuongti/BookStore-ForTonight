package com.example.bookstore.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstore.R;
import com.example.bookstore.models.ProductModel;

import java.util.ArrayList;


/**
 * Created by reiko-lhnhat on 12/1/2021.
 */
public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {
    private ArrayList<ProductModel> productList;
    private OnProductListener mOnProductListener;
    public ProductListAdapter(ArrayList<ProductModel> productList, OnProductListener onProductListener) {
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
        ProductModel data = productList.get(position);
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
