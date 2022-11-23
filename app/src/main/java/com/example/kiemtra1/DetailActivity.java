package com.example.kiemtra1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        TextView textViewten = (TextView)findViewById(R.id.tenDS);
        TextView textViewmota = (TextView) findViewById(R.id.motaDS);
        Intent intent= getIntent();
        textViewten.setText(intent.getStringExtra("Ten"));
        textViewmota.setText(intent.getStringExtra("MoTa"));

    }
}