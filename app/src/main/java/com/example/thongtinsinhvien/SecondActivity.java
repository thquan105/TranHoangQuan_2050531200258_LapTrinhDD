package com.example.thongtinsinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    Button btn;
    TextView txtTen, txtMasv, txtEmail, txtSdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn = (Button) findViewById(R.id.btnTrolai);
        txtTen = (TextView) findViewById(R.id.textTen);
        txtMasv = (TextView) findViewById(R.id.textMasv);
        txtEmail = (TextView) findViewById(R.id.textEmail);
        txtSdt = (TextView) findViewById(R.id.textSdt);

        Intent intent = getIntent();

        String ten = intent.getStringExtra("ten");
        String masv = intent.getStringExtra("masv");
        String email = intent.getStringExtra("email");
        String sdt = intent.getStringExtra("sdt");

        txtTen.setText(ten);
        txtMasv.setText(masv);
        txtEmail.setText(email);
        txtSdt.setText(sdt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}