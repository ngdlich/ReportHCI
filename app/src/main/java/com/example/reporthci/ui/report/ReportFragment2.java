package com.example.reporthci.ui.report;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reporthci.MainActivity;
import com.example.reporthci.R;
import com.example.reporthci.adapter.ReportAdapter;
import com.example.reporthci.adapter.ReportAdapter2;
import com.example.reporthci.model.Report;

import java.util.ArrayList;

public class ReportFragment2 extends Fragment {

    private ArrayList<Report> mReports;
    private RecyclerView mRecyclerReport;
    private ReportAdapter2 mReportAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null);
        View root = inflater.inflate(R.layout.fragment_list_report, container, false);


        ((MainActivity) getActivity()).setActionBarTitle("Báo cáo");
        ((MainActivity) getActivity()).setNavChecked();

        mRecyclerReport = root.findViewById(R.id.recyclerReport);
        mReports = new ArrayList<>();
        createReportList();
        mReportAdapter = new ReportAdapter2(getActivity(), mReports);
        mRecyclerReport.setAdapter(mReportAdapter);
        mRecyclerReport.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;
    }

    private void createReportList() {
        mReports.add(new Report("Kiểm tra tụ bù 151", "29-05-2020  10:00:00","ĐH Bách khoa Hà Nội", "558TN/234/73/1"));
        mReports.add(new Report("Kiểm tra tạ chống rung 021", "21-06-2020  10:00:00","Thanh Nhàn 1", "478TN/234/63/1"));
        mReports.add(new Report("Kiểm tra dây dẫn ASCR 178", "01-06-2020  10:00:00","Bệnh viện Bạch Mai", "478TN/234/63/1"));
        mReports.add(new Report("Kiểm tra Recloser 001", "26-05-2020  10:00:00","ĐH Bách khoa Hà Nội", "478TN/234/63/1"));
        mReports.add(new Report("Kiểm tra kháng điện 088", "30-05-2020  10:00:00","Tạ Quang Bửu 2", "478TN/234/63/1"));
        mReports.add(new Report("Kiểm tra dây dẫn ASCR 178", "01-06-2020  10:00:00","Bệnh viện Bạch Mai", "478TN/234/63/1"));
        mReports.add(new Report("Kiểm tra kháng điện 088", "30-05-2020  10:00:00","Tạ Quang Bửu 2", "478TN/234/63/1"));
        mReports.add(new Report("Kiểm tra cột thép 008", "02-06-2020  10:00:00","Đống Đa 03", "478TN/234/63/1"));
        mReports.add(new Report("Kiểm tra cột thép 008", "02-06-2020  10:00:00","Đống Đa 03", "478TN/234/63/1"));
        mReports.add(new Report("Kiểm tra cáp treo 432", "05-06-2020  10:00:00","Trường Chinh", "478TN/234/63/1"));
        mReports.add(new Report("Kiểm tra Recloser 001", "26-05-2020  10:00:00","ĐH Bách khoa Hà Nội", "478TN/234/63/1"));
        mReports.add(new Report("Kiểm tra tụ bù 151", "29-05-2020  10:00:00","ĐH Bách khoa Hà Nội", "558TN/234/73/1"));
        mReports.add(new Report("Kiểm tra tạ chống rung 021", "21-06-2020  10:00:00","Thanh Nhàn 1", "478TN/234/63/1"));
        mReports.add(new Report("Kiểm tra cáp treo 432", "05-06-2020  10:00:00","Trường Chinh", "478TN/234/63/1"));
    }
}