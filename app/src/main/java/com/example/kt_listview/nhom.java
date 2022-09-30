package com.example.kt_listview;

public class nhom {
    private String Ten;
    private String Mota;
    private String Anh;

    public nhom(String ten, String mota, String anh) {
        Ten = ten;
        Mota = mota;
        Anh = anh;
    }

    public nhom() {
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

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String anh) {
        Anh = anh;
    }
}

