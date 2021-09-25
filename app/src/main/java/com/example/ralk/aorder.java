package com.example.ralk;

import androidx.appcompat.app.AppCompatActivity;

public class aorder  {

    String cusname,address,p,dp;



    public String getCusname() {
        return cusname;
    }

    public String getAdd() {
        return address;
    }

    public String getP() {
        return p;
    }

    public String getDp() {
        return dp;
    }



    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setP(String p) {
        this.p = p;
    }

    public void setDp(String dp) {
        this.dp = dp;
    }

    public aorder( String cusname, String address, String p, String dp) {

        this.cusname = cusname;
        this.address = address;
        this.p = p;
        this.dp = dp;
    }

    public aorder() {
    }
}
