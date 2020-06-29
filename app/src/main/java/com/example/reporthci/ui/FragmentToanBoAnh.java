package com.example.reporthci.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.reporthci.MainActivity;
import com.example.reporthci.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentToanBoAnh extends Fragment {


    private Spinner spnCategory, spnCategory1;
    Button btnSave;
    Button btnSend;
    ImageButton btnMap;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_toan_bo_anh, container, false);


        //((MainActivity) getActivity()).setActionBarTitle("Báo cáo");
        ((MainActivity) getActivity()).setNavChecked1();



        return root;
    }

    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("ReportHCI");
        builder.setMessage("Bạn có chắc chắn muốn gửi báo cáo không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "Báo cáo đã được gửi thành công", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
