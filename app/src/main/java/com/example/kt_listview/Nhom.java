package com.example.kt_listview;

import android.content.Intent;

public class Nhom {
    private String Ten;
    private String Mota;
    private int Anh;

    public Nhom(String ten, String mota, int anh) {
        Ten = ten;
        Mota = mota;
        Anh = anh;
    }


    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getAnh() {
        return Anh;
    }

    public void setAnh(int anh) {
        Anh = anh;
    }
}

