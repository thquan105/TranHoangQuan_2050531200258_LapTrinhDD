package com.example.ui_signinsignup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class Page_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PageAdapter pageAdapter;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        initView();

        back = (ImageView) findViewById(R.id.btnBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    public void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rcv_page);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Page> arrayList = new ArrayList<>();
        //imgsrc,Name,Description
        arrayList.add(new Page(R.drawable.img_bantruyenthong,"Ban Truyền Thông Đoàn trường UTE - Media", "Câu lạc bộ giao lưu"));
        arrayList.add(new Page(R.drawable.img_cris,"CrisDevilGamer", "Nghệ sỹ"));
        arrayList.add(new Page(R.drawable.img_dhspkt,"Trường Đại học Sư phạm Kỹ thuật - Đại Học Đà Nẵng", "Trang web giáo dục"));
        arrayList.add(new Page(R.drawable.img_tuoitredhdn,"Tuổi trẻ Đại học Đà Nẵng", "Tổ chức cộng đồng"));
        arrayList.add(new Page(R.drawable.img_mixigaming,"MixiGaming", "Người tạo video chơi game"));
        arrayList.add(new Page(R.drawable.img_denvau,"Đen Vâu FC", "Trang dành cho fan của Đen"));
        arrayList.add(new Page(R.drawable.img_tranthanh,"Trấn Thành", "Nghệ sĩ"));



        pageAdapter = new PageAdapter(arrayList,getApplicationContext());
        recyclerView.setAdapter(pageAdapter);
    }
}