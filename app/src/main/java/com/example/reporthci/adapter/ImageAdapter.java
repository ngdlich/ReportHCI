package com.example.reporthci.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reporthci.ItemClickListener;
import com.example.reporthci.R;
import com.example.reporthci.model.Report;
import com.example.reporthci.ui.ReportActivity;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Bitmap> mReports;

    public ImageAdapter(Context mContext, ArrayList<Bitmap> mHeros) {
        this.mContext = mContext;
        this.mReports = mHeros;
    }


    @NonNull
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.item_image, parent, false);
        ImageAdapter.ViewHolder viewHolder = new ImageAdapter.ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageAdapter.ViewHolder holder, int position) {
        Bitmap report = mReports.get(position);
        holder.imgTT.setImageBitmap(report);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, final int position, boolean isLongClick) {
                if(isLongClick){
                    //showAlertDialog();
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("ReportHCI");
                    builder.setMessage("Bạn có chắc chắn muốn xóa ảnh không?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            mReports.remove(position);
                            notifyDataSetChanged();
                            /*recycler.removeViewAt(position);
                            mAdapter.notifyItemRemoved(position);
                            mAdapter.notifyItemRangeChanged(position, list.size());*/
                            Toast.makeText(mContext, "Ảnh đã được xóa", Toast.LENGTH_SHORT).show();
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
        });
    }

    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("ReportHCI");
        builder.setMessage("Bạn có chắc chắn muốn gửi báo cáo không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(mContext, "Báo cáo đã được gửi thành công", Toast.LENGTH_SHORT).show();
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
    public int getItemCount() {
        return mReports.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        private ImageView imgTT;

        private ItemClickListener itemClickListener;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTT = itemView.findViewById(R.id.img_tt);

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
