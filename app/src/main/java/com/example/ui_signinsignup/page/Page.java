package com.example.ui_signinsignup.page;

public class Page {
    private int srcImg;
    private String txt_Name;
    private String txt_Description;

    public Page(int srcImg, String txt_Name, String txt_Description) {
        this.srcImg = srcImg;
        this.txt_Name = txt_Name;
        this.txt_Description = txt_Description;
    }

    public int getSrcImg() {
        return srcImg;
    }

    public void setSrcImg(int srcImg) {
        this.srcImg = srcImg;
    }

    public String getTxt_Name() {
        return txt_Name;
    }

    public void setTxt_Name(String txt_Name) {
        this.txt_Name = txt_Name;
    }

    public String getTxt_Description() {
        return txt_Description;
    }

    public void setTxt_Description(String txt_Description) {
        this.txt_Description = txt_Description;
    }
}
