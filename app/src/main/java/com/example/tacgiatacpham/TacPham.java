package com.example.tacgiatacpham;

public class TacPham {
    private String ten, nam, theloai, mota;
    private int hinhanh;

    public TacPham() {
    }

    public TacPham(String ten, String nam, String theloai, String mota, int hinhanh) {
        this.ten = ten;
        this.nam = nam;
        this.theloai = theloai;
        this.mota = mota;
        this.hinhanh = hinhanh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }
}
