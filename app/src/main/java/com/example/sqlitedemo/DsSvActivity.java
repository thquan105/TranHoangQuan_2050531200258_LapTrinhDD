package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sqlitedemo.Adapter.SinhVienAdapter;
import com.example.sqlitedemo.Model.SinhVien;

import java.util.ArrayList;

public class DsSvActivity extends AppCompatActivity {
    public static DBHelper dbHelper_258;
    public static ArrayList<SinhVien> arrayList_258 = new ArrayList<>();
    public static RecyclerView recyclerView_258;
    public static String maLop_258;
    public static SinhVienAdapter sinhVienAdapter_258;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_sv);

        recyclerView_258 = (RecyclerView) findViewById(R.id.rcv_sv_258);

        maLop_258 = getIntent().getExtras().getString("Ma");

        dbHelper_258 = new DBHelper(this, "qlsinhvien", null, 1);
        //cuộn mượt hơn
        recyclerView_258.setHasFixedSize(true);
        //Back
        ImageView ic_back_258 = (ImageView) findViewById(R.id.btnBack_258);
        ic_back_258.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getDataComputer();
        Button button = (Button) findViewById(R.id.btn_themSV_258);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(DsSvActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_sinhvien);
                dialog.show();
                EditText tv1 = (EditText) dialog.findViewById(R.id.isMaSV_258);
                EditText tv2 = (EditText) dialog.findViewById(R.id.isName_258);
                EditText tv3 = (EditText) dialog.findViewById(R.id.isKhoa_258);
                EditText tv4 = (EditText) dialog.findViewById(R.id.isMaLop_258);

                tv4.setText(maLop_258.trim());
                Button btok = (Button) dialog.findViewById(R.id.btn_ok_258);
                Button btcancel = (Button) dialog.findViewById(R.id.btn_cancel_258);
                btok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dbHelper_258.QueryData("INSERT INTO tblsinhvien (masv, tensv, khoa, malop) VALUES ('"+tv1.getText().toString().trim()+"', '"+tv2.getText().toString().trim()+"', '"+tv3.getText().toString().trim()+"', '"+tv4.getText().toString()+"')");
                        getDataComputer();
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
    public void getDataComputer() {
        DsSvActivity.arrayList_258 = new ArrayList<SinhVien>();
        //Lấy dữ liệu
        Cursor dataSV_258 = dbHelper_258.GetData("SELECT * FROM tblsinhvien WHERE malop = '"+ maLop_258.trim()+"'");

        dataSV_258.moveToFirst();
        while (!dataSV_258.isAfterLast()){
            String ma = dataSV_258.getString(0);
            String ten = dataSV_258.getString(1);
            String khoa = dataSV_258.getString(2);
            arrayList_258.add(new SinhVien(ma, ten, khoa, maLop_258.trim()));
            dataSV_258.moveToNext();
        }
        dataSV_258.close();
        //Quy định kiểu hiển thị
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView_258.setLayoutManager(layoutManager);
        sinhVienAdapter_258 = new SinhVienAdapter(arrayList_258, getApplicationContext());
        recyclerView_258.setAdapter(sinhVienAdapter_258);
    }
}