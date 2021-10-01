package com.example.ralk;

import androidx.appcompat.app.AppCompatActivity;

public class aorder  {

    String orderID,CusName,Address;
    long Mobile,Price;


    public aorder(){

    }

    public aorder(String orderId, String cusName, String address, long mobile, long price) {
        orderID = orderId;
        CusName = cusName;
        Address = address;
        Mobile = mobile;
        Price = price;
    }

    public String getOrderId() {
        return orderID;
    }

    public void setOrderId(String orderId) {
        orderId = orderId;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String cusName) {
        CusName = cusName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public long getMobile() {
        return Mobile;
    }

    public void setMobile(long mobile) {
        Mobile = mobile;
    }

    public long getPrice() {
        return Price;
    }

    public void setPrice(long price) {
        Price = price;
    }
}
