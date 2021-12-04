package com.example.bookstore.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstore.R;
import com.example.bookstore.models.ItemOrderModel;
import com.example.bookstore.utils.ProcessCurrency;

import java.util.ArrayList;

/**
 * Author : Hào
 * Mô tả : ItemAdapter được sử dụng để gắn giá trị itemLists vào layout layout_products_cart
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>  {
    ArrayList<ItemOrderModel> itemLists;
    AdapterUpdate updateInterface;

    public ItemAdapter(ArrayList<ItemOrderModel> itemLists, AdapterUpdate updateInterface) {
        this.itemLists = itemLists;
        this.updateInterface = updateInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.layout_products_cart, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameBookView.setText(itemLists.get(position).getNameBook().toString());
        holder.priceView.setText(ProcessCurrency.convertNumberToString(itemLists.get(position).getPrice()));
        holder.imgView.setImageResource(itemLists.get(position).getImg());

        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Increase numberProduct to 1
                int numberProduct = Integer.valueOf(holder.numberProductView.getText().toString()).intValue();
                holder.numberProductView.setText(String.valueOf(numberProduct + 1));
                updateInterface.UpdateTotalCostAndProduct(true, ProcessCurrency.convertStringToNumber(holder.priceView.getText().toString()));



                notifyDataSetChanged();
            }
        });

        holder.btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numberProduct = Integer.valueOf(holder.numberProductView.getText().toString()).intValue();
                holder.numberProductView.setText(String.valueOf(numberProduct - 1));
                updateInterface.UpdateTotalCostAndProduct(false, ProcessCurrency.convertStringToNumber(holder.priceView.getText().toString()));
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return itemLists.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView nameBookView, priceView, numberProductView;
        ImageButton btnAdd, btnDecrease;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.imgBookCart);
            nameBookView = itemView.findViewById(R.id.nameBook);
            priceView = itemView.findViewById(R.id.priceBook);
            numberProductView = itemView.findViewById(R.id.numberProduct);
            btnAdd = (ImageButton) itemView.findViewById(R.id.btnAddOfOrder);
            btnDecrease =(ImageButton) itemView.findViewById(R.id.btnRemoveOfOrder);
        }
    }

    public interface AdapterUpdate{
        void UpdateTotalCostAndProduct(Boolean isPlus, int money);
    }
}
