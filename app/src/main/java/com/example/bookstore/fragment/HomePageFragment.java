package com.example.bookstore.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookstore.R;
import com.example.bookstore.adapters.ReportAdapter;
import com.example.bookstore.models.ReportModel;

import java.util.ArrayList;

public class HomePageFragment extends Fragment {
    private ArrayList<ReportModel> reportModels = new ArrayList<>();
    private ReportAdapter reportAdapter;
    private ListView lv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_homepage_admin, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();

        reportAdapter = new ReportAdapter(getActivity(), reportModels);
        lv.setAdapter(reportAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), reportModels.get(position).getTittle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Taking data for Reports
     */
    public void initData(){
        lv = getActivity().findViewById(R.id.lvReport);
        reportModels.add(new ReportModel("nhatcuongti", "nvmtriet", "Qua Bo Lao"));
        reportModels.add(new ReportModel("nhatcuongti", "lthieu", "Qua Lao again"));
        reportModels.add(new ReportModel("nhatcuongti", "nhatks14", "Qua Diem"));
        reportModels.add(new ReportModel("nhatcuongti", "DatAKC++", "Qua Long"));
    }
}
