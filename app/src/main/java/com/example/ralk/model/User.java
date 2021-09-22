package com.example.ralk.model;

public class User {

    public String name;
    public String email;
    public String phone;
    public String pass;
    public String repass;
    public String hno;
    public String city;

    public User(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRepass() {
        return repass;
    }

    public void setRepass(String repass) {
        this.repass = repass;
    }

    public String getHno() {
        return hno;
    }

    public void setHno(String hno) {
        this.hno = hno;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User(String name, String email, String phone, String pass, String repass, String hno, String city) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.pass = pass;
        this.repass = repass;
        this.hno = hno;
        this.city = city;
    }
}
