package com.example.reporthci.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.app.Fragment;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.reporthci.LsActivity;
import com.example.reporthci.MainActivity;
import com.example.reporthci.R;
import com.example.reporthci.ToanBoAnhActivity;
import com.example.reporthci.model.Device;

import java.util.ArrayList;
import java.util.List;

public class DeviceActivity extends AppCompatActivity {


    LinearLayout btnMap;
    Button btnToanBoAnh, btnSsAnh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_device);
        Toolbar toolbar = findViewById(R.id.toolbar_device);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Thiết bị 001");


        btnMap = findViewById(R.id.btn_map_device);

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=21.001792,105.848402");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        btnToanBoAnh = findViewById(R.id.btn_toan_bo_anh);
        btnSsAnh = findViewById(R.id.btn_ss_anh);

        btnToanBoAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeviceActivity.this, ToanBoAnhActivity.class);
                startActivity(intent);
            }
        });

        btnSsAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeviceActivity.this, LsActivity.class);
                startActivity(intent);
            }
        });


    }

    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(DeviceActivity.this);
        builder.setTitle("ReportHCI");
        builder.setMessage("Bạn có chắc chắn muốn gửi báo cáo không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DeviceActivity.this, "Báo cáo đã được gửi thành công", Toast.LENGTH_SHORT).show();
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

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}