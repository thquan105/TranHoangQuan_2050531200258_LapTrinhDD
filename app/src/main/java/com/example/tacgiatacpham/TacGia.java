package com.example.tacgiatacpham;

public class TacGia {
    //hình ảnh, tên, mô tả, sao
    private int hinhanh;
    private String tenTacGia, moTa;
    private double rate;
    private String maTacgia;

    public TacGia() {
    }


    public TacGia(int hinhanh,String maTacgia, String tenTacGia, String moTa, double rate) {
        this.maTacgia = maTacgia;
        this.hinhanh = hinhanh;
        this.tenTacGia = tenTacGia;
        this.moTa = moTa;
        this.rate = rate;
    }

    public String getMaTacgia() {
        return maTacgia;
    }

    public void setMaTacgia(String maTacgia) {
        this.maTacgia = maTacgia;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
