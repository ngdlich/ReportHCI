package com.example.reporthci.ui;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.reporthci.MainActivity;
import com.example.reporthci.R;

import java.util.ArrayList;
import java.util.List;

public class SsAnhActivity extends Fragment {


    TextView tv1, tv2, tv3, tv4, tv5;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.ss_anh_2, container, false);


        ((MainActivity) getActivity()).setActionBarTitle("So sánh ảnh");
        ((MainActivity) getActivity()).setNavChecked();

        tv1 = root.findViewById(R.id.tv_so1);
        tv2 = root.findViewById(R.id.tv_so2);
        tv3 = root.findViewById(R.id.tv_so3);
        tv4 = root.findViewById(R.id.tv_so4);
        tv5 = root.findViewById(R.id.tv_so5);

        tv1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                tv1.setTextColor(getResources().getColor(R.color.white));
                tv1.setBackground(getResources().getDrawable(R.drawable.circle_tv1));
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                tv2.setTextColor(getResources().getColor(R.color.white));
                tv2.setBackground(getResources().getDrawable(R.drawable.circle_tv1));
            }
        });

        tv3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                tv3.setTextColor(getResources().getColor(R.color.white));
                tv3.setBackground(getResources().getDrawable(R.drawable.circle_tv1));
            }
        });

        tv4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                tv4.setTextColor(getResources().getColor(R.color.white));
                tv4.setBackground(getResources().getDrawable(R.drawable.circle_tv1));
            }
        });

        tv5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                tv5.setTextColor(getResources().getColor(R.color.white));
                tv5.setBackground(getResources().getDrawable(R.drawable.circle_tv1));
            }
        });

        return root;
    }

}
