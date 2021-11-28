package com.example.bookstore;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bookstore.fragment.HomePageFragment;

/**
 * Author : Hao
 * Describe : This is Main Activity for Admin
 */
public class MainAdminActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_admin);

        initData();
    }

    /**
     * Author : Hao
     * Describe : Using to taking first data when activity is onCreate()
     */
    void initData(){
        HomePageFragment homePageFragment = new HomePageFragment();
        fragmentTransaction.add(R.id.containerFragment, homePageFragment);
        fragmentTransaction.commit();
    }
}
