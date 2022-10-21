package com.example.ui_signinsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Signup_Activity extends AppCompatActivity {
    private TextView txtview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);
        //      Event Sign In
        txtview = (TextView) findViewById(R.id.txtLogin);
        txtview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signup_Activity.this, Login_Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right);
                finish();
            }
        });
    }
}