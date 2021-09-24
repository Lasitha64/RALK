package com.example.ralk.model;

public class Deliverylist {


    private Integer Orderno;
    private String  Dpname;
    private String Dctime;

    public Deliverylist() {
    }

    public Integer getOrderno() {
        return Orderno;
    }

    public void setOrderno(Integer orderno) {
        Orderno = orderno;
    }

    public String getDpname() {
        return Dpname;
    }

    public void setDpname(String dpname) {
        Dpname = dpname;
    }

    public String getDctime() {
        return Dctime;
    }

    public void setDctime(String dctime) {
        Dctime = dctime;
    }
}
