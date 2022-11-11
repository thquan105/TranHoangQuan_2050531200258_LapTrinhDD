package com.example.sqlitedemo.Adapter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlitedemo.DetailActivity;
import com.example.sqlitedemo.DsSvActivity;
import com.example.sqlitedemo.Model.SinhVien;
import com.example.sqlitedemo.R;

import java.util.ArrayList;


public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.ViewHolder> {
    ArrayList<SinhVien> sinhViens_258;
    Context context;

    public SinhVienAdapter(ArrayList<SinhVien> sinhViens_258, Context context) {
        this.sinhViens_258 = sinhViens_258;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_sv, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SinhVien sv_258 = sinhViens_258.get(position);
        if ( sv_258 == null)
        {
            return;
        }
        holder.masv_258.setText(sv_258.getMaSV_258());
        holder.tensv_258.setText(sv_258.getTenSV_258());
        holder.namSinh_258.setText(sv_258.getNamSinh_258());
        holder.cardView_258.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("SINHVIEN", sv_258);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sinhViens_258.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //MSV, TenSV, Năm sinh, Lớp, Toán, Tin, Anh, Mã Lớp
        TextView masv_258, tensv_258, namSinh_258;
        CardView cardView_258;
        public Button btnDel_258;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            masv_258 = itemView.findViewById(R.id.maSV_258);
            tensv_258 = itemView.findViewById(R.id.tenSV_258);
            namSinh_258  = itemView.findViewById(R.id.namsinh_258);
            btnDel_258 = itemView.findViewById(R.id.btnDel);
            cardView_258 = itemView.findViewById(R.id.card_sv_258);

            btnDel_258.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alertDiaLog = new AlertDialog.Builder(view.getContext());
                    alertDiaLog.setTitle("Thông báo");
                    alertDiaLog.setMessage("Bạn có muốn xóa sinh viên "+ tensv_258.getText().toString().trim()+" ?"    );
                    alertDiaLog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            DsSvActivity.dbHelper_258.QueryData("DELETE from tblsinhvien where masv ='"+masv_258.getText().toString().trim()+"'");
                            DsSvActivity.arrayList_258 = new ArrayList<>();
                            Cursor cursor = DsSvActivity.dbHelper_258.GetData("Select * from tblsinhvien where malop = '"+DsSvActivity.maLop_258.trim() +"'");
                            while (cursor.moveToNext()){
                                //(masv, tensv, ngaySinh, toan, tin, anh, malop)
                                @SuppressLint("Range") String maSV_258 =cursor.getString(cursor.getColumnIndex("masv"));
                                @SuppressLint("Range") String tenSV_258 = cursor.getString(cursor.getColumnIndex("tensv"));
                                @SuppressLint("Range") String namSinh_258 = cursor.getString(cursor.getColumnIndex("ngaySinh"));
                                @SuppressLint("Range") Double toan_258 = cursor.getDouble(cursor.getColumnIndex("toan"));
                                @SuppressLint("Range") Double tin_258 = cursor.getDouble(cursor.getColumnIndex("tin"));
                                @SuppressLint("Range") Double anh_258 = cursor.getDouble(cursor.getColumnIndex("anh"));
                                @SuppressLint("Range") String maLop_258 = cursor.getString(cursor.getColumnIndex("malop"));

                                DsSvActivity.arrayList_258.add(new SinhVien(maSV_258, tenSV_258, namSinh_258, toan_258, tin_258, anh_258, maLop_258));
                            }
                            DsSvActivity.sinhVienAdapter_258 = new SinhVienAdapter(DsSvActivity.arrayList_258, view.getContext());
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL,false);
                            DsSvActivity.recyclerView_258.setAdapter(DsSvActivity.sinhVienAdapter_258);
                            DsSvActivity.recyclerView_258.setLayoutManager(linearLayoutManager);
                        }
                    });
                    alertDiaLog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    alertDiaLog.show();
                }
            });
        }
    }
}
