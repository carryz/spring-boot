package com.example.demo.model;

import java.util.Date;

public class orderinfo {
    private  Integer order_id;
    private String cus_account;
    private String nurse_account;
    private Date order_time;
    private Date order_begintime;
    private Date order_endtime;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public void setCus_account(String cus_account) {
        this.cus_account = cus_account;
    }

    public void setNurse_account(String nurse_account) {
        this.nurse_account = nurse_account;
    }

    public String getCus_account() {
        return cus_account;
    }

    public String getNurse_account() {
        return nurse_account;
    }

    public Date getOrder_begintime() {
        return order_begintime;
    }

    public Date getOrder_endtime() {
        return order_endtime;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_begintime(Date order_begintime) {
        this.order_begintime = order_begintime;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public void setOrder_endtime(Date order_endtime) {
        this.order_endtime = order_endtime;
    }
}
