package com.example.quanlymaytinh.Model;

public class Computer {
    private String maComputer;
    private String tenComputer;
    private String moTa;
    private String maCategory;

    public Computer(String maComputer, String tenComputer, String moTa, String maCategory) {
        this.maComputer = maComputer;
        this.tenComputer = tenComputer;
        this.moTa = moTa;
        this.maCategory = maCategory;
    }

    public String getMaComputer() {
        return maComputer;
    }

    public void setMaComputer(String maComputer) {
        this.maComputer = maComputer;
    }

    public String getTenComputer() {
        return tenComputer;
    }

    public void setTenComputer(String tenComputer) {
        this.tenComputer = tenComputer;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getMaCategory() {
        return maCategory;
    }

    public void setMaCategory(String maCategory) {
        this.maCategory = maCategory;
    }
}
