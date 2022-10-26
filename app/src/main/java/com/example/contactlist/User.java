package com.example.contactlist;

public class User {
    private String Ten;
    private String So;

    public User(String ten, String so) {
        Ten = ten;
        So = so;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getSo() {
        return So;
    }

    public void setSo(String so) {
        So = so;
    }
}
