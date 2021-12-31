package com.example.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookstore.models.ProductModel;

/**
 * Created by reiko-lhnhat on 12/3/2021.
 */
public class BuyerDetailProductActivity extends AppCompatActivity {
    private ImageView imageProduct;
    private TextView  nameProduct;
    private TextView  priceProduct;
    private TextView  quantityProduct;
    private TextView  descriptionProduct;
    private ImageButton backward;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail_buyer);

        imageProduct = findViewById(R.id.imageProductatDetail);
        nameProduct = findViewById(R.id.nameProductatDetail);
        priceProduct = findViewById(R.id.priceProductatDetail);
        quantityProduct = findViewById(R.id.quantityatDetail);
        descriptionProduct = findViewById(R.id.descriptionProduct);
        backward = findViewById(R.id.backward_from_detailproduct_buyer);

        Intent intent = getIntent();
        ProductModel product = (ProductModel) intent.getSerializableExtra("clickProduct_ProductDetail");
        imageProduct.setImageResource(product.getImg());
        nameProduct.setText(product.getName());
        priceProduct.setText("Price: " + product.getPrice() +"vnđ");
        quantityProduct.setText("Quanity: " + Integer.toString(product.getQuantity()));
        descriptionProduct.setText(product.getDescription());

        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
