package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.example.sqlitedemo.Adapter.LopAdapter;
import com.example.sqlitedemo.Model.Lop;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView_258;
    DBHelper dbHelper_258;
    ArrayList<Lop> arrayList_258 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView_258 = (RecyclerView) findViewById(R.id.rcv_Lop_258);
        // tạo db
        dbHelper_258 = new DBHelper(this, "qlsinhvien", null, 1);
        //cuộn mượt hơn
        recyclerView_258.setHasFixedSize(true);

        //tạo table
        dbHelper_258.QueryData("CREATE TABLE IF NOT EXISTS tbllop ( " +
                "malop TEXT PRIMARY KEY, " +
                "tenlop TEXT, " +
                "siso INTEGER)");
        //MSV, TenSV, Năm sinh, Lớp, Toán, Tin, Anh, Mã Lớp
        dbHelper_258.QueryData("CREATE TABLE IF NOT EXISTS tblsinhvien ( " +
                "masv TEXT PRIMARY KEY, " +
                "tensv TEXT, " +
                "ngaySinh TEXT, " +
                "toan DOUBLE, " +
                "tin DOUBLE, " +
                "anh DOUBLE, " +
                "malop TEXT NOT NULL CONSTRAINT malop REFERENCES tbllop(malop) ON DELETE CASCADE)");

        //Nhập dữ liệu
        Cursor cursor_258 = dbHelper_258.GetData("SELECT * FROM tbllop");
        if (cursor_258.getCount() == 0) {
            dbHelper_258.QueryData("INSERT INTO tbllop (malop, tenlop, siso) VALUES ('20T1','CNTT1',65)");
            dbHelper_258.QueryData("INSERT INTO tbllop (malop, tenlop, siso) VALUES ('20T2','CNTT2',74)");
            dbHelper_258.QueryData("INSERT INTO tbllop (malop, tenlop, siso) VALUES ('20T3', 'CNTT3',67)");
            dbHelper_258.QueryData("INSERT INTO tbllop (malop, tenlop, siso) VALUES ('21T1', 'CNTT3',70)");
            dbHelper_258.QueryData("INSERT INTO tbllop (malop, tenlop, siso) VALUES ('21T2', 'CNTT3',72)");
            dbHelper_258.QueryData("INSERT INTO tbllop (malop, tenlop, siso) VALUES ('21T3', 'CNTT3',48)");
        }
        cursor_258 = dbHelper_258.GetData("SELECT * FROM tblsinhvien");
        if (cursor_258.getCount() == 0) {
            dbHelper_258.QueryData("INSERT INTO tblsinhvien (masv, tensv, ngaySinh, toan, tin, anh, malop) VALUES ('2050531200258', 'H Quan 1', '2002',8 , 9, 8, '20T2')");
            dbHelper_258.QueryData("INSERT INTO tblsinhvien (masv, tensv, ngaySinh, toan, tin, anh, malop) VALUES ('2050531200259', 'H Quan 2', '2002',8 , 7, 8, '20T1')");
            dbHelper_258.QueryData("INSERT INTO tblsinhvien (masv, tensv, ngaySinh, toan, tin, anh, malop) VALUES ('2050531200260', 'H Quan 3', '2002',8 , 8, 9, '20T3')");
            dbHelper_258.QueryData("INSERT INTO tblsinhvien (masv, tensv, ngaySinh, toan, tin, anh, malop) VALUES ('2050531200261', 'H Quan 4', '2002',8 , 8, 7, '20T1')");
            dbHelper_258.QueryData("INSERT INTO tblsinhvien (masv, tensv, ngaySinh, toan, tin, anh, malop) VALUES ('2050531200262', 'H Quan 5', '2002',8 , 9, 6, '20T3')");
            dbHelper_258.QueryData("INSERT INTO tblsinhvien (masv, tensv, ngaySinh, toan, tin, anh, malop) VALUES ('2050531200263', 'H Quan 6', '2002',9 , 8, 8, '20T2')");
            dbHelper_258.QueryData("INSERT INTO tblsinhvien (masv, tensv, ngaySinh, toan, tin, anh, malop) VALUES ('2150531200258', 'H Quan 7', '2003',8 , 7, 8, '21T2')");
            dbHelper_258.QueryData("INSERT INTO tblsinhvien (masv, tensv, ngaySinh, toan, tin, anh, malop) VALUES ('2150531200259', 'H Quan 8', '2003',7 , 8, 9, '21T1')");
            dbHelper_258.QueryData("INSERT INTO tblsinhvien (masv, tensv, ngaySinh, toan, tin, anh, malop) VALUES ('2150531200260', 'H Quan 9', '2003',8 , 8, 7, '21T3')");
            dbHelper_258.QueryData("INSERT INTO tblsinhvien (masv, tensv, ngaySinh, toan, tin, anh, malop) VALUES ('2150531200261', 'H Quan 10', '2003',8 , 9, 8, '21T1')");
            dbHelper_258.QueryData("INSERT INTO tblsinhvien (masv, tensv, ngaySinh, toan, tin, anh, malop) VALUES ('2150531200262', 'H Quan 11', '2003',8 , 8, 7, '21T3')");
            dbHelper_258.QueryData("INSERT INTO tblsinhvien (masv, tensv, ngaySinh, toan, tin, anh, malop) VALUES ('2150531200263', 'H Quan 12', '2003',7 , 9, 7, '21T2')");
        }
        getDataLop();
    }
    public void getDataLop(){
        //Lấy dữ liệu từ tbllop
        Cursor dataLop_258 = dbHelper_258.GetData("SELECT * FROM tbllop");

        dataLop_258.moveToFirst();
        while (!dataLop_258.isAfterLast()){
            String ma = dataLop_258.getString(0);
            String ten = dataLop_258.getString(1);
            int num = dataLop_258.getInt(2);
            arrayList_258.add(new Lop(ma, ten, num));
            dataLop_258.moveToNext();
        }
        dataLop_258.close();
        //Quy định kiểu hiển thị
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView_258.setLayoutManager(layoutManager);
        LopAdapter lopAdapter = new LopAdapter(arrayList_258, getApplicationContext());
        recyclerView_258.setAdapter(lopAdapter);
    }

}