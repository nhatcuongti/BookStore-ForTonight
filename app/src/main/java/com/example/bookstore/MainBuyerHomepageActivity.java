package com.example.bookstore;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstore.adapters.ProductListAdapter;
import com.example.bookstore.models.ProductModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
/**
 * Created by reiko-lhnhat on 12/3/2021.
 */
public class MainBuyerHomepageActivity extends AppCompatActivity implements ProductListAdapter.OnProductListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolBar;
    EditText searchView;

    private ArrayList<ProductModel> listProduct;
    private RecyclerView recyclerView;
    private ProductListAdapter productListAdapter;
    private ImageButton goToCartBtn;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_buyer);



        initTopAndBottomBar();
        initData();

        searchView = findViewById(R.id.search_bar_view);
        //set recycle
        recyclerView = findViewById(R.id.list_product);
        productListAdapter = new ProductListAdapter(listProduct, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(productListAdapter);


        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                productListAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        goToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainBuyerHomepageActivity.this, BuyerCartActivity.class);
                MainBuyerHomepageActivity.this.startActivity(intent);
            }
        });
    }

    /**
     * Initialize Action Bar on top and bottom
     */
    void initTopAndBottomBar(){
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolBar = findViewById(R.id.toolbar);
        goToCartBtn = findViewById(R.id.carBtn_homepageBuyer);
        setSupportActionBar(toolBar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    public void initData(){
        listProduct = new ArrayList<>();
        listProduct.add(new ProductModel("haobu01", "20000", 20, "abc"));
        listProduct.add(new ProductModel("hi???u 10 m??i", "20000", 19,"cdcd"));
        listProduct.add(new ProductModel("h?? l?? b?? L?? Dzan ?????t", "20000", 17,"B?? T??n L?? D??n ?????t, qu?? qu??n TP HCM" +
                " hi???n ??ang s???ng v?? l??m vi???c t???i tp H??? Ch?? Minh, ?????c th??n single boy, c?? ch??? v?? " +
                "L?? D??n Ng???c s???ng t???i cam qu??t. B???n c???a b?? t??n Qu??ch Tri???t, anh c???a b?? t??n H??o bu???i "));
        listProduct.add(new ProductModel("Tri???t ??ng tr??m ????i ???????ng", "20000", 20, "abc"));
        listProduct.add(new ProductModel("lthieu", "20000", 19,"cdcd"));
        listProduct.add(new ProductModel("nhatks14", "20000", 18,"cdc"));
        listProduct.add(new ProductModel("DatAKC", "20000", 17,"bcd"));
        listProduct.add(new ProductModel("DatAKC", "20000", 17,"bcd"));
    }

    @Override
    public void onProductClick(int positionProduct) {
        ProductModel product = listProduct.get(positionProduct);
        Intent intent = new Intent(this, BuyerDetailProductActivity.class);
        intent.putExtra("clickProduct_ProductDetail", product);
        this.startActivity(intent);
    }
}
