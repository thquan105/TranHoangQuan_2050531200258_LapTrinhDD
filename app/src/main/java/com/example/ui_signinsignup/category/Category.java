package com.example.ui_signinsignup.category;

import com.example.ui_signinsignup.page.Page;

import java.util.ArrayList;

public class Category {
    private String nameCategory;
    private ArrayList<Page> pages;
    private boolean isH;

    public Category(String nameCategory, ArrayList<Page> pages, Boolean isH) {
        this.nameCategory = nameCategory;
        this.pages = pages;
        this.isH = isH;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public ArrayList<Page> getPages() {
        return pages;
    }


    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }

    public boolean isH() {
        return isH;
    }

    public void setH(boolean h) {
        isH = h;
    }
}