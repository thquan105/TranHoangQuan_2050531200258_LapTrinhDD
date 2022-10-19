package com.example.recycleviewngang;

import java.util.ArrayList;

public class Category {
    private String nameCategory;
    private ArrayList<Phone> phones;

    public Category(String nameCategory, ArrayList<Phone> phones) {
        this.nameCategory = nameCategory;
        this.phones = phones;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public ArrayList<Phone> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<Phone> phones) {
        this.phones = phones;
    }
}
