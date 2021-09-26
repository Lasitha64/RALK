package com.example.ralk;

public class Delivery_model {

    Integer orderno;
    String dpname,dctime;

    Delivery_model()
    {

    }
    public Delivery_model(Integer orderno, String dpname, String dctime) {
        this.orderno = orderno;
        this.dpname = dpname;
        this.dctime = dctime;
    }

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    public String getDpname() {
        return dpname;
    }

    public void setDpname(String dpname) {
        this.dpname = dpname;
    }

    public String getDctime() {
        return dctime;
    }

    public void setDctime(String dctime) {
        this.dctime = dctime;
    }
}
