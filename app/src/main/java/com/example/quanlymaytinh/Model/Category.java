package com.example.quanlymaytinh.Model;

public class Category {
    private String maCategory;
    private String tenCategory;
    private int soLuong;

    public Category(String maCategory, String tenCategory, int soLuong) {
        this.maCategory = maCategory;
        this.tenCategory = tenCategory;
        this.soLuong = soLuong;
    }

    public String getMaCategory() {
        return maCategory;
    }

    public void setMaCategory(String maCategory) {
        this.maCategory = maCategory;
    }

    public String getTenCategory() {
        return tenCategory;
    }

    public void setTenCategory(String tenCategory) {
        this.tenCategory = tenCategory;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
