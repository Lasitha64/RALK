package com.example.ralk;

public class deliveryView {

    public deliveryView(){

    }

    public deliveryView(String DP_ID, String name, String email, String mobile) {
        this.DP_ID = DP_ID;
        Name = name;
        Email = email;
        Mobile = mobile;
    }

    String DP_ID,Name,Email,Mobile;


    public String getDP_ID() {
        return DP_ID;
    }

    public void setDP_ID(String DP_ID) {
        this.DP_ID = DP_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }
}
