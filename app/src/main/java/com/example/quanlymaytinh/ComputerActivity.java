package com.example.quanlymaytinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class ComputerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);

        String ma = getIntent().getExtras().getString("Ma");

        Toast.makeText(ComputerActivity.this, ma, Toast.LENGTH_SHORT).show();
    }
}