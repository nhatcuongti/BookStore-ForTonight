package com.example.bookstore;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstore.adapters.ItemAdapter;
import com.example.bookstore.models.ItemOrderModel;
import com.example.bookstore.utils.ProcessCurrency;

import java.util.ArrayList;

public class PaymentActivity extends AppCompatActivity implements ItemAdapter.AdapterUpdate{

    ArrayList<ItemOrderModel> listItems = new ArrayList<>();
    RecyclerView rv;
    ItemAdapter ia;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_screen);

        initData();
        ia = new ItemAdapter(listItems, this);

        rv.setAdapter(ia);
        rv.setLayoutManager(new LinearLayoutManager(this));

        //TextView v = findViewById(R.id.totalCostProduct);
    }

    private void initData() {
        rv = findViewById(R.id.view);
        listItems.add(new ItemOrderModel(R.drawable.dac_nhan_tam, "Đắc nhân tâm", 350000));
        listItems.add(new ItemOrderModel(R.drawable.nha_gia_kim, "Nhà giả kim", 150000));
        listItems.add(new ItemOrderModel(R.drawable.tu_duy_phan_bien, "Tư duy phản biện", 500000));


    }

    public void UpdateTotalCostAndProduct(Boolean isPlus, int money) {
        //TextView totalProduct = findViewById(R.id.totalNumberProductOfCart);
        //TextView totalCost = findViewById(R.id.totalCostProduct);

        //int totalProductValue = Integer.valueOf(totalProduct.getText().toString()).intValue(); //Lấy tổng số lượng của sản phẩm
        //totalProductValue = (isPlus) ? totalProductValue + 1 : totalProductValue - 1; // Thay đổi tùy vào isPlus
        //totalProduct.setText(String.valueOf(totalProductValue)); // Set lại giá trị khi đã tính toán xong

        //int totalCostValue = ProcessCurrency.convertStringToNumber(totalCost.getText().toString());// Lấy tổng chi phí của toàn bộ sản phẩm trong đơn hàng
        //totalCostValue = (isPlus) ? totalCostValue + money : totalCostValue - money; // Thay đổi tùy vào isPlus
        //totalCost.setText(ProcessCurrency.convertNumberToString(totalCostValue)); // Set lại giá trị khi đã tính toán xong

    }
}