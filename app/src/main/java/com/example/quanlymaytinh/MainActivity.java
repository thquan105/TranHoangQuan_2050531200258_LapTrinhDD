package com.example.quanlymaytinh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;


import com.example.quanlymaytinh.Adapter.CategoryAdapter;
import com.example.quanlymaytinh.Model.Category;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DBHelper dbHelper;
    ArrayList<Category> arrayList = new ArrayList<>();
    CategoryAdapter categoryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rcv_Category);
        //cuộn mượt hơn
        recyclerView.setHasFixedSize(true);
        dbHelper = new DBHelper(this, "qlMayTinh", null, 1);
        //tạo table
        dbHelper.QueryData("CREATE TABLE IF NOT EXISTS tblCategory ( maCategory TEXT PRIMARY KEY, tenCategory TEXT, soLuong INTEGER)");

        dbHelper.QueryData("CREATE TABLE IF NOT EXISTS tblComputer ( maComputer TEXT PRIMARY KEY, tenComputer TEXT, moTa TEXT, maCategory TEXT " +
                "NOT NULL CONSTRAINT maCategory REFERENCES tblCategory(maCategory) ON DELETE CASCADE)");

        //Nhập Data
        Cursor cursor = dbHelper.GetData("SELECT * FROM tblCategory");
        if (cursor.getCount() == 0) {
            dbHelper.QueryData("INSERT INTO tblCategory (maCategory, tenCategory, soLuong) VALUES ('ca1','Laptop LENOVO',5)");
            dbHelper.QueryData("INSERT INTO tblCategory (maCategory, tenCategory, soLuong) VALUES ('ca2','Laptop MSI',4)");
            dbHelper.QueryData("INSERT INTO tblCategory (maCategory, tenCategory, soLuong) VALUES ('ca3','Laptop ASUS',4)");
            dbHelper.QueryData("INSERT INTO tblCategory (maCategory, tenCategory, soLuong) VALUES ('ca4','Laptop DELL',3)");
        }
        cursor = dbHelper.GetData("SELECT * FROM tblComputer");
        if (cursor.getCount() == 0) {
            dbHelper.QueryData("INSERT INTO tblComputer (maComputer, tenComputer, moTa, maCategory) VALUES ('le1','Lenovo IdeaPad','Laptop Lenovo','ca1')");
            dbHelper.QueryData("INSERT INTO tblComputer (maComputer, tenComputer, moTa, maCategory) VALUES ('le2','Lenovo Yoga','Laptop Lenovo','ca1')");
            dbHelper.QueryData("INSERT INTO tblComputer (maComputer, tenComputer, moTa, maCategory) VALUES ('le3','Lenovo ThinkPad','Laptop Lenovo','ca1')");
            dbHelper.QueryData("INSERT INTO tblComputer (maComputer, tenComputer, moTa, maCategory) VALUES ('le4','Lenovo Legion','Laptop Lenovo','ca1')");
            dbHelper.QueryData("INSERT INTO tblComputer (maComputer, tenComputer, moTa, maCategory) VALUES ('le5','Lenovo ThinkBook','Laptop Lenovo','ca1')");

            dbHelper.QueryData("INSERT INTO tblComputer (maComputer, tenComputer, moTa, maCategory) VALUES ('m1','MSI 1','Laptop MSI','ca2')");
            dbHelper.QueryData("INSERT INTO tblComputer (maComputer, tenComputer, moTa, maCategory) VALUES ('m2','MSI 2','Laptop MSI','ca2')");
            dbHelper.QueryData("INSERT INTO tblComputer (maComputer, tenComputer, moTa, maCategory) VALUES ('m3','MSI 3','Laptop MSI','ca2')");
            dbHelper.QueryData("INSERT INTO tblComputer (maComputer, tenComputer, moTa, maCategory) VALUES ('m4','MSI 4','Laptop MSI','ca2')");

            dbHelper.QueryData("INSERT INTO tblComputer (maComputer, tenComputer, moTa, maCategory) VALUES ('a1','ASUS 1','Laptop ASUS','ca3')");
            dbHelper.QueryData("INSERT INTO tblComputer (maComputer, tenComputer, moTa, maCategory) VALUES ('a2','ASUS 2','Laptop ASUS','ca3')");
            dbHelper.QueryData("INSERT INTO tblComputer (maComputer, tenComputer, moTa, maCategory) VALUES ('a3','ASUS 3','Laptop ASUS','ca3')");
            dbHelper.QueryData("INSERT INTO tblComputer (maComputer, tenComputer, moTa, maCategory) VALUES ('a4','ASUS 4','Laptop ASUS','ca3')");

            dbHelper.QueryData("INSERT INTO tblComputer (maComputer, tenComputer, moTa, maCategory) VALUES ('d1','Dell 1','Laptop Dell','ca4')");
            dbHelper.QueryData("INSERT INTO tblComputer (maComputer, tenComputer, moTa, maCategory) VALUES ('d2','Dell 2','Laptop Dell','ca4')");
            dbHelper.QueryData("INSERT INTO tblComputer (maComputer, tenComputer, moTa, maCategory) VALUES ('d3','Dell 3','Laptop Dell','ca4')");
        }
        getDataCategory();
//        lopCategory = new CategoryAdapter(arrayList, new AdapterView.OnItemLongClickListener(){

    }
    public void getDataCategory(){

        //Lấy dữ liệu từ tblCategory
        Cursor dataLop = dbHelper.GetData("SELECT * FROM tblCategory");

        dataLop.moveToFirst();
        while (!dataLop.isAfterLast()){
            String ma = dataLop.getString(0);
            String ten = dataLop.getString(1);
            int num = dataLop.getInt(2);
            arrayList.add(new Category(ma, ten, num));
            dataLop.moveToNext();
        }
        dataLop.close();
        //Quy định kiểu hiển thị
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(arrayList, getApplicationContext());
        recyclerView.setAdapter(categoryAdapter);
    }
}