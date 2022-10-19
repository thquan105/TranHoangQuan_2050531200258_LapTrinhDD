package com.example.recycleviewngang;

public class Phone {
    private String name_phone;
    private String price_phone;
    private int image_phone;

    public Phone(String name_phone, String price_phone, int image_phone) {
        this.name_phone = name_phone;
        this.price_phone = price_phone;
        this.image_phone = image_phone;
    }

    public String getName_phone() {
        return name_phone;
    }

    public void setName_phone(String name_phone) {
        this.name_phone = name_phone;
    }

    public String getPrice_phone() {
        return price_phone;
    }

    public void setPrice_phone(String price_phone) {
        this.price_phone = price_phone;
    }

    public int getImage_phone() {
        return image_phone;
    }

    public void setImage_phone(int image_phone) {
        this.image_phone = image_phone;
    }
}
