package com.example.ui_signinsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail_Activity extends AppCompatActivity {
    TextView txt_name, txt_description, txt_about;
    ImageView image, iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txt_name = findViewById(R.id.txt_Name);
        txt_description = findViewById(R.id.txt_Description);
        txt_about = findViewById(R.id.txt_About);
        image = findViewById(R.id.img_hinh);

        iv_back = findViewById(R.id.btn_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        txt_name.setText(getIntent().getExtras().getString("Name"));
        txt_description.setText(getIntent().getExtras().getString("Des"));
        txt_about.setText(getIntent().getExtras().getString("about"));
        int int_image = getIntent().getIntExtra("image", 0);
        image.setImageResource(int_image);
    }
}