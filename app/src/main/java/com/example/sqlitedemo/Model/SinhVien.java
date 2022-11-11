package com.example.sqlitedemo.Model;

import java.io.Serializable;

public class SinhVien implements Serializable {
    //MSV, TenSV, Năm sinh, Lớp, Toán, Tin, Anh, Mã Lớp
    private String maSV_258;
    private String tenSV_258;
    private String namSinh_258;
    private Double diemToan_258;
    private Double diemTin_258;
    private Double diemAnh_258;
    private String maLop_258;

    public SinhVien(String maSV_258, String tenSV_258, String namSinh_258, Double diemToan_258, Double diemTin_258, Double diemAnh_258, String maLop_258) {
        this.maSV_258 = maSV_258;
        this.tenSV_258 = tenSV_258;
        this.namSinh_258 = namSinh_258;
        this.diemToan_258 = diemToan_258;
        this.diemTin_258 = diemTin_258;
        this.diemAnh_258 = diemAnh_258;
        this.maLop_258 = maLop_258;
    }

    public String getMaSV_258() {
        return maSV_258;
    }

    public void setMaSV_258(String maSV_258) {
        this.maSV_258 = maSV_258;
    }

    public String getTenSV_258() {
        return tenSV_258;
    }

    public void setTenSV_258(String tenSV_258) {
        this.tenSV_258 = tenSV_258;
    }

    public String getMaLop_258() {
        return maLop_258;
    }

    public void setMaLop_258(String maLop_258) {
        this.maLop_258 = maLop_258;
    }

    public String getNamSinh_258() {
        return namSinh_258;
    }

    public void setNamSinh_258(String namSinh_258) {
        this.namSinh_258 = namSinh_258;
    }

    public Double getDiemToan_258() {
        return diemToan_258;
    }

    public void setDiemToan_258(Double diemToan_258) {
        this.diemToan_258 = diemToan_258;
    }

    public Double getDiemTin_258() {
        return diemTin_258;
    }

    public void setDiemTin_258(Double diemTin_258) {
        this.diemTin_258 = diemTin_258;
    }

    public Double getDiemAnh_258() {
        return diemAnh_258;
    }

    public void setDiemAnh_258(Double diemAnh_258) {
        this.diemAnh_258 = diemAnh_258;
    }
}
