package com.example.tacgiatacpham;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvTacgia;
    private TacGiaAdapter tacGiaAdapter;
    ArrayList<TacGia> tacGiaArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }
    public void initView() {
        rcvTacgia = findViewById(R.id.rcv_tacgia);
        rcvTacgia.setHasFixedSize(true);
        tacGiaArrayList = new ArrayList<TacGia>();

        tacGiaArrayList.add(new TacGia( R.drawable.huycan,"tg1","Cù Huy Cận"," là một chính khách, từng giữ nhiều chức vụ lãnh đạo cao cấp trong chính phủ Việt Nam",9.5));
        tacGiaArrayList.add(new TacGia( R.drawable.ngdu,"tg2","Nguyễn Du", "là một nhà thơ, nhà văn hóa lớn thời Lê mạt Nguyễn sơ ở Việt Nam. Ông được người Việt kính trọng tôn xưng là Đại thi hào dân tộc và được UNESCO vinh danh là Danh nhân văn hóa thế giới", 8.9));
        tacGiaArrayList.add(new TacGia( R.drawable.macngon,"tg3","Mạc Ngôn"," là một nhà văn người Trung Quốc xuất thân từ nông dân. Ông đã từng được thế giới biết đến với tác phẩm Cao lương đỏ đã được đạo diễn nổi tiếng Trương Nghệ Mưu chuyển thể thành phim.",8.9));
        tacGiaArrayList.add(new TacGia( R.drawable.chan,"tg4","William Shakespeare"," là nhà văn vĩ đại nhất của Anh và là nhà viết kịch đi trước thời đại. Ông còn được vinh danh là nhà thơ tiêu biểu của nước Anh và là Thi sĩ của dòng sông Avon",7.8));
        tacGiaArrayList.add(new TacGia( R.drawable.hemingway,"tg5","Ernest Hemingway","là một tiểu thuyết gia người Mỹ, nhà văn viết truyện ngắn và là một nhà báo. Ông là một phần của cộng đồng những người xa xứ ở Paris",8.7));



        tacGiaAdapter = new TacGiaAdapter(this, tacGiaArrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvTacgia.setLayoutManager(linearLayoutManager);

        rcvTacgia.setAdapter(tacGiaAdapter);

    }
}