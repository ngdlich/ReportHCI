package com.example.reporthci.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reporthci.ItemClickListener;
import com.example.reporthci.R;
import com.example.reporthci.model.Report;
import com.example.reporthci.ui.ReportActivity;
import com.example.reporthci.ui.ReportActivity2;

import java.util.ArrayList;

public class ReportAdapter2 extends RecyclerView.Adapter<ReportAdapter2.ViewHolder> {

    private Context mContext;
    private ArrayList<Report> mReports;

    public ReportAdapter2(Context mContext, ArrayList<Report> mHeros) {
        this.mContext = mContext;
        this.mReports = mHeros;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.row_report, parent, false);
        ViewHolder viewHolder = new ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Report report = mReports.get(position);
        holder.tvTenBaoCao.setText(report.getTenBaoCao());
        holder.tvThoiGian.setText(report.getThoiGian());
        holder.tvDuongDay.setText(report.getDuongDay());
        holder.tvViTri.setText(report.getViTri());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(!isLongClick){
                    Intent intent = new Intent(mContext, ReportActivity2.class);
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mReports.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        private TextView tvTenBaoCao;
        private TextView tvThoiGian;
        private TextView tvDuongDay;
        private TextView tvViTri;

        private ItemClickListener itemClickListener;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenBaoCao = itemView.findViewById(R.id.tv_ten_bao_cao);
            tvThoiGian = itemView.findViewById(R.id.tv_thoi_gian);
            tvDuongDay = itemView.findViewById(R.id.tv_duong_day);
            tvViTri = itemView.findViewById(R.id.tv_vi_tri);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }


        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),true);
            return false;
        }
    }
}
