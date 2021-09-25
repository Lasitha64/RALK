package com.example.ralk.common;

import com.example.ralk.model.User;

public class Common {

    public String name;
    public String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Common() {
    }

    public Common(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
