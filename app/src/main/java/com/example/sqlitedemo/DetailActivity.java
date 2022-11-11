package com.example.sqlitedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqlitedemo.Adapter.SinhVienAdapter;
import com.example.sqlitedemo.Model.SinhVien;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    Button btnEdit_258;
    ImageView btnBack_258;
    SinhVien sinhVien_258;
    TextView msv, ten, nam, dtoan, dtin, danh, diemtb, maLop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btnEdit_258 = findViewById(R.id.btnEdit);
        sinhVien_258 =  (SinhVien) getIntent().getExtras().get("SINHVIEN");


        anhxa();

        getDataSinhVien();


        btnBack_258 = findViewById(R.id.btn_Back_258);
        btnBack_258.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DsSvActivity.arrayList_258 = new ArrayList<SinhVien>();
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
                finish();
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
                EditText tv3 = (EditText) dialog.findViewById(R.id.isNamSinh_258);
                EditText tv4 = (EditText) dialog.findViewById(R.id.isToan_258);
                EditText tv5 = (EditText) dialog.findViewById(R.id.isTin_258);
                EditText tv6 = (EditText) dialog.findViewById(R.id.isAnh_258);
                EditText tv7 = (EditText) dialog.findViewById(R.id.isMaLop_258);

                tv1.setText(msv.getText().toString().trim());
                tv2.setText(ten.getText().toString().trim());
                tv3.setText(nam.getText().toString().trim());
                tv4.setText(dtoan.getText().toString().trim());
                tv5.setText(dtin.getText().toString().trim());
                tv6.setText(danh.getText().toString().trim());
                tv7.setText(maLop.getText().toString().trim());

                Button btok = (Button) dialog.findViewById(R.id.btn_ok_258);
                Button btcancel = (Button) dialog.findViewById(R.id.btn_cancel_258);

                btok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (tv1 == null && tv2 == null && tv3 == null && tv4 == null && tv5 == null && tv6 == null && tv7 == null) {
                            Toast.makeText(getApplicationContext(), "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                        } else {
                            DsSvActivity.dbHelper_258.QueryData("UPDATE tblsinhvien SET " +
                                    "masv = '" + tv1.getText().toString().trim() + "', " +
                                    "tensv='" + tv2.getText().toString().trim() + "', " +
                                    "ngaySinh='" + tv3.getText().toString().trim() + "', " +
                                    "toan= " + tv4.getText().toString().trim() + ", " +
                                    "tin=" + tv5.getText().toString().trim() + ", " +
                                    "anh= " + tv6.getText().toString().trim() + ", " +
                                    "malop= '" + tv7.getText().toString().trim() + "' " +
                                    "WHERE masv ='" + sinhVien_258.getMaSV_258().trim() + "'");
                            getDataSinhVien();
                            dialog.dismiss();
                        }
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
    public void anhxa(){
        msv = findViewById(R.id.txtMsv_258);
        ten = findViewById(R.id.txtTen_258);
        nam = findViewById(R.id.txtNamsinh_258);
        dtoan = findViewById(R.id.txtToan_258);
        dtin = findViewById(R.id.txtTin_258);
        danh = findViewById(R.id.txtAnh_258);
        diemtb = findViewById(R.id.txtDtb_258);
        maLop = findViewById(R.id.txtmalop_258);
    }

    public void getDataSinhVien() {
        Cursor cursor = DsSvActivity.dbHelper_258.GetData("Select * from tblsinhvien where masv = '"+sinhVien_258.getMaSV_258()+"'");
        while (cursor.moveToNext()){
            //(masv, tensv, ngaySinh, toan, tin, anh, malop)
            msv.setText(cursor.getString(0));
            ten.setText(cursor.getString(1));
            nam.setText(cursor.getString(2));
            dtoan.setText(cursor.getString(3));
            dtin.setText(cursor.getString(4));
            danh.setText(cursor.getString(5));
            maLop.setText(cursor.getString(6));
            Double dtb = (cursor.getDouble(3) + cursor.getDouble(4) + cursor.getDouble(5))/3;
            diemtb.setText(String.format("%.2f", dtb));
        }
    }
}