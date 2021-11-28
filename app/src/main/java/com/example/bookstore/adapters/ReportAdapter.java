package com.example.bookstore.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bookstore.R;
import com.example.bookstore.models.Report;

import java.util.ArrayList;

/**
 * Author : Hao
 * Describe : Create Adapter for ListView .
 */
public class ReportAdapter extends BaseAdapter {
    Context context;
    ArrayList<Report> Reports;

    public ReportAdapter(Context context, ArrayList<Report> reports) {
        this.context = context;
        Reports = reports;
    }

    @Override
    public int getCount() {
        return Reports.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get Layout : layout_report.xml
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.layout_report, parent, false);

        //Get View on layout_report.xml
        TextView Sender = convertView.findViewById(R.id.senderInReport);
        TextView reportedUser = convertView.findViewById(R.id.reportedUserInReport);
        TextView Tittle = convertView.findViewById(R.id.titleInReport);

        //Change data for layout
        String senderText = "Sender : " + Reports.get(position).getSender();
        Sender.setText(senderText);

        String reportedUserText = "Report to : " + Reports.get(position).getReportedUser();
        reportedUser.setText(reportedUserText);

        String tittleText = "Tittle : " + Reports.get(position).getTittle();
        Tittle.setText(tittleText);


        return convertView;
    }
}
