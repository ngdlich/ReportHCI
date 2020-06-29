package com.example.reporthci.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reporthci.ItemClickListener;
import com.example.reporthci.R;
import com.example.reporthci.model.Device;
import com.example.reporthci.model.Report;
import com.example.reporthci.ui.DeviceActivity;
import com.example.reporthci.ui.ReportActivity;

import java.util.ArrayList;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.ViewHolder> implements Filterable {

    private Context mContext;
    private ArrayList<Device> mDevices;
    private ArrayList<Device> mDevicesFull;

    public DeviceAdapter(Context mContext, ArrayList<Device> mHeros) {
        this.mContext = mContext;
        this.mDevices = mHeros;
        mDevicesFull = new ArrayList<>(mHeros);
    }


    @NonNull
    @Override
    public DeviceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.row_device, parent, false);
        DeviceAdapter.ViewHolder viewHolder = new DeviceAdapter.ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceAdapter.ViewHolder holder, int position) {
        Device device = mDevices.get(position);
        holder.tvTenThietBi.setText(device.getTenThietBi());
        holder.tvLoaiThietBi.setText(device.getTenThietBi());
        holder.tvDuongDay.setText(device.getDuongDay());
        holder.tvViTri.setText(device.getViTri());
        holder.anhTB.setImageResource(mContext.getResources().getIdentifier(device.getAnhTB(), "drawable", mContext.getPackageName()));


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(!isLongClick){
                    Intent intent = new Intent(mContext, DeviceActivity.class);
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDevices.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Device> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mDevicesFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Device item : mDevicesFull) {
                    if (item.getTenThietBi().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mDevices.clear();
            mDevices.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        private TextView tvTenThietBi;
        private TextView tvLoaiThietBi;
        private TextView tvDuongDay;
        private TextView tvViTri;
        private ImageView anhTB;

        private ItemClickListener itemClickListener;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenThietBi = itemView.findViewById(R.id.tv_ten_thiet_bi);
            tvLoaiThietBi = itemView.findViewById(R.id.tv_loai_tb);
            tvDuongDay = itemView.findViewById(R.id.tv_duong_day_tb);
            tvViTri = itemView.findViewById(R.id.tv_vi_tri_tb);
            anhTB = itemView.findViewById(R.id.ivAnhTB);

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
