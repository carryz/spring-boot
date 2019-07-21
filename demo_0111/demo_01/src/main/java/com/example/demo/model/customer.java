package com.example.demo.model;

import java.util.Date;

public class customer {
    private String cus_account;
    private String cus_password;
    private String cus_name;
    private String cus_gender;
    private String cus_phone;
    private String cus_address;
    private Date cus_time_signin;

    public String getCus_account() {
        return cus_account;
    }

    public Date getCus_time_signin() {
        return cus_time_signin;
    }

    public String getCus_address() {
        return cus_address;
    }

    public String getCus_gender() {
        return cus_gender;
    }

    public String getCus_name() {
        return cus_name;
    }

    public String getCus_password() {
        return cus_password;
    }

    public String getCus_phone() {
        return cus_phone;
    }

    public void setCus_account(String cus_account) {
        this.cus_account = cus_account;
    }

    public void setCus_gender(String cus_gender) {
        this.cus_gender = cus_gender;
    }

    public void setCus_address(String cus_address) {
        this.cus_address = cus_address;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public void setCus_password(String cus_password) {
        this.cus_password = cus_password;
    }

    public void setCus_phone(String cus_phone) {
        this.cus_phone = cus_phone;
    }

    public void setCus_time_signin(Date cus_time_signin) {
        this.cus_time_signin = cus_time_signin;
    }
}
