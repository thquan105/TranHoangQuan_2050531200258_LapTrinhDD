package com.example.ui_signinsignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ui_signinsignup.page.Page;
import com.example.ui_signinsignup.page.PageAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Page_Activity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private RecyclerView recyclerView;
    private PageAdapter pageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        initView();

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.menu_page);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        startActivity(new Intent(getApplicationContext(), Home_Activity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.menu_page:
                        return true;
                    case R.id.menu_profile:
                        startActivity(new Intent(getApplicationContext(), Profile_Activity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                }
                return false;
            }
        });
    }

    Boolean doubleTap = false;
    @Override
    public void onBackPressed() {
        if (doubleTap) {
            finish();
        } else {
            Toast.makeText(Page_Activity.this, "Press Back again to exit the application!", Toast.LENGTH_SHORT).show();
            doubleTap = true;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleTap = false;
                }
            }, 1800);
        }
    }


    public void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rcv_page);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Page> arrayList = new ArrayList<>();
        //imgsrc,Name,Description,(About)
        arrayList.add(new Page(R.drawable.img_bantruyenthong,"Ban Truyền Thông Đoàn trường UTE - Media", "Câu lạc bộ giao lưu", "Ban này sẽ đảm nhiệm vai trò quảng bá hoạt động của Ban, các chương trình do Trường Đại Học Sư phạm Kỹ thuật Đà Nẵng tổ chức."));
        arrayList.add(new Page(R.drawable.img_cris,"Cris Devil Gamer", "Nghệ sỹ", "Hello Các bạn, Chào mừng các bạn đã trở lại với channel của mình, mình là Cris Devil Gamer."));
        arrayList.add(new Page(R.drawable.img_dhspkt,"Trường Đại học Sư phạm Kỹ thuật - Đại Học Đà Nẵng", "Trang web giáo dục","Trang thông tin tuyển sinh - Trường Đại học Sư phạm Kỹ thuật - Đại học Đà Nẵng."));
        arrayList.add(new Page(R.drawable.img_tuoitredhdn,"Tuổi trẻ Đại học Đà Nẵng", "Tổ chức cộng đồng", "Đoàn Thanh niên Cộng sản Hồ Chí Minh được thành lập theo quyết định số 24/QÐ-BTV."));
        arrayList.add(new Page(R.drawable.img_mixigaming,"Mixi Gaming", "Người tạo video chơi game","Hí Anh em, Mình là Độ."));
        arrayList.add(new Page(R.drawable.img_denvau,"Đen Vâu FC", "Trang dành cho fan của Đen", "Đen Vâu FC là cộng đồng Đồng âm lớn nhất của Đen Vâu."));
        arrayList.add(new Page(R.drawable.img_tranthanh,"Trấn Thành", "Nghệ sĩ", "Kênh Youtube chính thức : https://youtube.com/TRANTHANHTOWN."));
        arrayList.add(new Page(R.drawable.img_daiphatthanh, "Đài Phát Thanh","Công ty truyền thông, tin tức", "Từ đây phát ra những tín hiệu thông tin vui vẻ, tích cực và thú vị. Liên hệ với chúng tôi qua: contact.cotdien@gmail.com"));
        arrayList.add(new Page(R.drawable.img_dienban,"Điện Bàn", "Trang web văn hoá & xã hội","Chào mừng đến với trang fanpage Điện Bàn. Liên Hê quảng cáo vui lòng inbox Fanpage."));
        arrayList.add(new Page(R.drawable.img_garena, "Garena Liên Quân Mobile", "Trò chơi điện tử", "Fanpage chính thức dành cho người chơi Liên Quân Mobile. Tất cả các sự kiện và thông tin quan trọng sẽ được thông báo chính thức tại đây."));
        arrayList.add(new Page(R.drawable.img_yody, "YODY","Cửa hàng quần áo", "Yody - Trải nghiệm tuyệt vời"));


        pageAdapter = new PageAdapter(arrayList,getApplicationContext());
        recyclerView.setAdapter(pageAdapter);
    }
}