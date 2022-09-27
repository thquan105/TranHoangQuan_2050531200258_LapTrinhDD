package com.example.thongtinsinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText txtTen;
    EditText txtMasv;
    EditText txtEmail;
    EditText txtSDT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btnNhap);
        txtTen = (EditText) findViewById(R.id.ten);
        txtMasv = (EditText) findViewById(R.id.masv);
        txtEmail = (EditText) findViewById(R.id.email);
        txtSDT = (EditText) findViewById(R.id.sdt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra("ten",String.valueOf(txtTen.getText()));
                intent.putExtra("masv",String.valueOf(txtMasv.getText()));
                intent.putExtra("email",String.valueOf(txtEmail.getText()));
                intent.putExtra("sdt",String.valueOf(txtSDT.getText()));

                startActivity(intent);
            }
        });
    }
}