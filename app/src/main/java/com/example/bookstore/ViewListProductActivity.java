package com.example.bookstore;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstore.adapters.ItemAdapter;
import com.example.bookstore.adapters.product_management;
import com.example.bookstore.models.ItemOrderModel;

import java.util.ArrayList;

public class ViewListProductActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private ArrayList<ItemOrderModel> list;
    private product_management productAdapter;

//    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_management_seller);
        recyclerView = findViewById(R.id.rcview_hieu);
        list = new ArrayList<>();

        initData();
        setAdapter();


    }

    private void setAdapter() {
        productAdapter = new product_management(list, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    void initData()
    {
//        recyclerView = findViewById(R.id.rcview_hieu);
        list.add(new ItemOrderModel(R.drawable.dac_nhan_tam, "Đắc nhân tâm", 350000));
        list.add(new ItemOrderModel(R.drawable.nha_gia_kim, "Nhà giả kim", 150000));
        list.add(new ItemOrderModel(R.drawable.tu_duy_phan_bien, "Tư duy phản biện", 500000));
    }
}
