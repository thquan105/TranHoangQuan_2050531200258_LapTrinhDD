package com.example.sqlitedemo.Adapter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        holder.khoa_258.setText(sv_258.getKhoa_258());
    }

    @Override
    public int getItemCount() {
        return sinhViens_258.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView masv_258, tensv_258, khoa_258;
        public Button btnDel_258,btnEdit_258;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            masv_258 = itemView.findViewById(R.id.maSV_258);
            tensv_258 = itemView.findViewById(R.id.tenSV_258);
            khoa_258  = itemView.findViewById(R.id.khoa_258);
            btnDel_258 = itemView.findViewById(R.id.btnDel);
            btnEdit_258 = itemView.findViewById(R.id.btnEdit);


            //Xử lý khi nút Chi tiết được bấm
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
                                @SuppressLint("Range") String maSV_258 =cursor.getString(cursor.getColumnIndex("masv"));
                                @SuppressLint("Range") String tenSV_258 = cursor.getString(cursor.getColumnIndex("tensv"));
                                @SuppressLint("Range") String khoaSV_258 = cursor.getString(cursor.getColumnIndex("khoa"));
                                @SuppressLint("Range") String maLop_258 = cursor.getString(cursor.getColumnIndex("malop"));

                                DsSvActivity.arrayList_258.add(new SinhVien(maSV_258,tenSV_258,khoaSV_258,maLop_258));
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
            //Khi click vào sửa
            btnEdit_258.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Dialog dialog = new Dialog(view.getContext());
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.dialog_sinhvien);
                    dialog.show();
                    EditText tv1 = (EditText) dialog.findViewById(R.id.isMaSV_258);
                    EditText tv2 = (EditText) dialog.findViewById(R.id.isName_258);
                    EditText tv3 = (EditText) dialog.findViewById(R.id.isKhoa_258);
                    EditText tv4 = (EditText) dialog.findViewById(R.id.isMaLop_258);
                    tv1.setText(masv_258.getText().toString().trim());
                    tv2.setText(tensv_258.getText().toString().trim());
                    tv3.setText(khoa_258.getText().toString().trim());
                    tv4.setVisibility(View.GONE);
                    Button btok = (Button) dialog.findViewById(R.id.btn_ok_258);
                    Button btcancel = (Button) dialog.findViewById(R.id.btn_cancel_258);

                    btok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            DsSvActivity.dbHelper_258.QueryData("UPDATE tblsinhvien SET masv = '"+tv1.getText().toString().trim()+ "',tensv='"+ tv2.getText().toString().trim()+ "',khoa='"+ tv3.getText().toString().trim()+"' WHERE masv ='"+masv_258.getText().toString().trim()+"'");
                            DsSvActivity.arrayList_258 = new ArrayList<SinhVien>();
                            Cursor cursor = DsSvActivity.dbHelper_258.GetData("SELECT * FROM tblsinhvien WHERE malop = '"+DsSvActivity.maLop_258.trim() +"'");
                            while (cursor.moveToNext()){
                                @SuppressLint("Range") String maSV_258 =cursor.getString(cursor.getColumnIndex("masv"));
                                @SuppressLint("Range") String tenSV_258 = cursor.getString(cursor.getColumnIndex("tensv"));
                                @SuppressLint("Range") String khoaSV_258 = cursor.getString(cursor.getColumnIndex("khoa"));
                                @SuppressLint("Range") String maLop_258 = cursor.getString(cursor.getColumnIndex("malop"));

                                DsSvActivity.arrayList_258.add(new SinhVien(maSV_258,tenSV_258,khoaSV_258,maLop_258));
                            }
                            DsSvActivity.sinhVienAdapter_258 = new SinhVienAdapter(DsSvActivity.arrayList_258, view.getContext());
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL,false);
                            DsSvActivity.recyclerView_258.setAdapter(DsSvActivity.sinhVienAdapter_258);
                            DsSvActivity.recyclerView_258.setLayoutManager(linearLayoutManager);
                            dialog.dismiss();

                        }
                    });
                    btcancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.cancel();
                        }
                    });
                }
            });

        }
    }
}
