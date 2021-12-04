package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.bookstore.adapters.ItemAdapter;
import com.example.bookstore.models.ItemOrderModel;
import com.example.bookstore.utils.ProcessCurrency;

import java.util.ArrayList;

public class BuyerCartActivity extends AppCompatActivity implements ItemAdapter.AdapterUpdate {

    ArrayList<ItemOrderModel> listItems = new ArrayList<>();
    RecyclerView rv;
    ItemAdapter ia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_cart);



        initData();
        ia = new ItemAdapter(listItems, this);

        rv.setAdapter(ia);
        rv.setLayoutManager(new LinearLayoutManager(this));

        TextView v = findViewById(R.id.totalCostProduct);


    }

    /**
     * Author : Hao
     * Mô tả : Hàm này dùng để lấy dữ liệu từ database về và tính toán sẵn một số giá trị mặc định như
     * tổng giá tiền hoặc là tổng số lượng sản phẩm
     */
    private void initData() {
        rv = findViewById(R.id.recyclerView);
        listItems.add(new ItemOrderModel(R.drawable.dac_nhan_tam, "Đắc nhân tâm", 350000));
        listItems.add(new ItemOrderModel(R.drawable.nha_gia_kim, "Nhà giả kim", 150000));
        listItems.add(new ItemOrderModel(R.drawable.tu_duy_phan_bien, "Tư duy phản biện", 500000));

        TextView totalCost = findViewById(R.id.totalCostProduct);
        totalCost.setText("1,000,000");

        TextView totalProduct = findViewById(R.id.totalNumberProductOfCart);
        totalProduct.setText("3");
    }

    @Override
    /**
     * Author : Hao
     * Parameter :
     *   -isPlus : bằng True khi click vào dấu "+" ở trong giỏ hàng. Bằng false khi click vào
     *   dấu "-" ở trong giở hàng
     *   -money : Là giá của sản phẩm vừa click vào dấu "+" hoặc dấu "-"
     *
     * Mô tả : Implement Interface của ItemOrder.model . Mục tiêu là thay đổi hai giá trị
     * tổng số lượng sản phẩm và tổng giá tiền
     */
    public void UpdateTotalCostAndProduct(Boolean isPlus, int money) {
        TextView totalProduct = findViewById(R.id.totalNumberProductOfCart);
        TextView totalCost = findViewById(R.id.totalCostProduct);

        int totalProductValue = Integer.valueOf(totalProduct.getText().toString()).intValue(); //Lấy tổng số lượng của sản phẩm
        totalProductValue = (isPlus) ? totalProductValue + 1 : totalProductValue - 1; // Thay đổi tùy vào isPlus
        totalProduct.setText(String.valueOf(totalProductValue)); // Set lại giá trị khi đã tính toán xong

        int totalCostValue = ProcessCurrency.convertStringToNumber(totalCost.getText().toString());// Lấy tổng chi phí của toàn bộ sản phẩm trong đơn hàng
        totalCostValue = (isPlus) ? totalCostValue + money : totalCostValue - money; // Thay đổi tùy vào isPlus
        totalCost.setText(ProcessCurrency.convertNumberToString(totalCostValue)); // Set lại giá trị khi đã tính toán xong

    }
}