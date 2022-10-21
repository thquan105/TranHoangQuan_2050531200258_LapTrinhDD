package com.example.ui_signinsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Start_Activity extends AppCompatActivity {
    ImageButton btnGo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnGo = findViewById(R.id.btn_go);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
                finish();
            }
        });
    }

    public void openLogin(){
        Intent intent = new Intent(this, Login_Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }
}