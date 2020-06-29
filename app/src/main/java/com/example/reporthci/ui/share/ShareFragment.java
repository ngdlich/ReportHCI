package com.example.reporthci.ui.share;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.reporthci.MainActivity;
import com.example.reporthci.R;

public class ShareFragment extends Fragment {

    public Button btnPhanHoi;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        ((MainActivity) getActivity()).setActionBarTitle("Thông tin ứng dụng");
        ((MainActivity) getActivity()).setNavChecked3();

        View root = inflater.inflate(R.layout.fragment_share, container, false);


        btnPhanHoi = root.findViewById(R.id.btn_phan_hoi);

        btnPhanHoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email= new Intent(Intent.ACTION_SENDTO);
                email.setData(Uri.parse("mailto:ngdlich@gmail.com"));
                email.putExtra(Intent.EXTRA_SUBJECT, "Phàn hồi app");
                email.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(email);
            }
        });

        return root;
    }
}