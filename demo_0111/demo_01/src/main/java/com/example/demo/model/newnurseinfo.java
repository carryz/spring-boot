package com.example.demo.model;

import java.util.Date;

public class newnurseinfo {
    private String new_account;
    private String new_password;
    private String new_name;
    private String new_gender;
    private String new_pic;
    private String new_email;
    private String new_qq;
    private String new_phone;
    private String new_intro;
    private Integer new_level;
    private float new_price;
    private Date new_time_entry;

    public String getNew_account() {
        return new_account;
    }

    public String getNew_email() {
        return new_email;
    }

    public String getNew_gender() {
        return new_gender;
    }

    public String getNew_password() {
        return new_password;
    }

    public String getNew_name() {
        return new_name;
    }

    public String getNew_pic() {
        return new_pic;
    }

    public Date getNew_time_entry() {
        return new_time_entry;
    }

    public String getNew_phone() {
        return new_phone;
    }

    public void setNew_account(String new_account) {
        this.new_account = new_account;
    }

    public void setNew_email(String new_email) {
        this.new_email = new_email;
    }

    public void setNew_gender(String new_gender) {
        this.new_gender = new_gender;
    }

    public String getNew_qq() {
        return new_qq;
    }

    public void setNew_name(String new_name) {
        this.new_name = new_name;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public void setNew_pic(String new_pic) {
        this.new_pic = new_pic;
    }

    public float getNew_price() {
        return new_price;
    }

    public Integer getNew_level() {
        return new_level;
    }

    public String getNew_intro() {
        return new_intro;
    }

    public void setNew_phone(String new_phone) {
        this.new_phone = new_phone;
    }

    public void setNew_intro(String new_intro) {
        this.new_intro = new_intro;
    }

    public void setNew_qq(String new_qq) {
        this.new_qq = new_qq;
    }

    public void setNew_level(Integer new_level) {
        this.new_level = new_level;
    }

    public void setNew_price(float new_price) {
        this.new_price = new_price;
    }

    public void setNew_time_entry(Date new_time_entry) {
        this.new_time_entry = new_time_entry;
    }
}
