package com.example.bookstore;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstore.adapters.ProductListAdapter;
import com.example.bookstore.models.Product;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
/**
 * Created by reiko-lhnhat on 12/3/2021.
 */
public class MainBuyerHomepageActivity extends AppCompatActivity{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolBar;

    private ArrayList<Product> listProduct;
    private RecyclerView recyclerView;
    private ProductListAdapter productListAdapter;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_buyer);

        initTopAndBottomBar();
        initData();

        recyclerView = findViewById(R.id.list_product);
        productListAdapter = new ProductListAdapter(listProduct);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(productListAdapter);
    }

    /**
     * Initialize Action Bar on top and bottom
     */
    void initTopAndBottomBar(){
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    public void initData(){
        listProduct = new ArrayList<>();
        listProduct.add(new Product("haobu01", "20000", 20, "abc"));
        listProduct.add(new Product("hiếu 10 mái", "20000", 19,"cdcd"));
        listProduct.add(new Product("hê lô bé Lê Dzan Đạt", "20000", 17,"bcd"));
        listProduct.add(new Product("Triết ông trùm đái đường", "20000", 20, "abc"));
        listProduct.add(new Product("lthieu", "20000", 19,"cdcd"));
        listProduct.add(new Product("nhatks14", "20000", 18,"cdc"));
        listProduct.add(new Product("DatAKC", "20000", 17,"bcd"));
        listProduct.add(new Product("DatAKC", "20000", 17,"bcd"));
    }
}
