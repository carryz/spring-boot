package com.example.demo.model;

import java.util.Date;

public class nurse {
    private String nurse_account;
    private String nurse_password;
    private String nurse_name;
    private String nurse_gender;
    private String nurse_picture;
    private String nurse_email;
    private String nurse_qq;
    private String nurse_phone;
    private Integer nurse_level;
    private float nurse_price;
    private Date nurse_time_entry;
    private String nurse_intro;
    private String nurse_state;

    public String getNurse_account() {
        return nurse_account;
    }
    public String getNurse_password(){
        return nurse_password;
    }
    public String getNurse_name(){
        return nurse_name;
    }
    public String getNurse_gender(){
        return nurse_gender;
    }
    public String getNurse_picture() {
        return nurse_picture;
    }
    public String getNurse_email(){
        return nurse_email;
    }
    public String getNurse_qq(){
        return nurse_qq;
    }
    public Integer getNurse_level(){
        return nurse_level;
    }
    public  String getNurse_phone(){
        return nurse_phone;
    }
    public float getNurse_price(){
        return nurse_price;
    }
    public String getNurse_intro(){
        return nurse_intro;
    }
    public Date getNurse_time_entry(){
        return nurse_time_entry;
    }
    public String getNurse_state(){
        return nurse_state;
    }

    public void setNurse_account(String nurse_account) {
        this.nurse_account = nurse_account;
    }

    public void setNurse_password(String nurse_password) {
        this.nurse_password = nurse_password;
    }

    public void setNurse_email(String nurse_email) {
        this.nurse_email = nurse_email;
    }

    public void setNurse_name(String nurse_name) {
        this.nurse_name = nurse_name;
    }

    public void setNurse_gender(String nurse_gender) {
        this.nurse_gender = nurse_gender;
    }

    public void setNurse_picture(String nurse_picture) {
        this.nurse_picture = nurse_picture;
    }

    public void setNurse_intro(String nurse_intro) {
        this.nurse_intro = nurse_intro;
    }

    public void setNurse_level(Integer nurse_level) {
        this.nurse_level = nurse_level;
    }

    public void setNurse_phone(String nurse_phone) {
        this.nurse_phone = nurse_phone;
    }

    public void setNurse_price(float nurse_price) {
        this.nurse_price = nurse_price;
    }

    public void setNurse_qq(String nurse_qq) {
        this.nurse_qq = nurse_qq;
    }

    public void setNurse_state(String nurse_state) {
        this.nurse_state = nurse_state;
    }

    public void setNurse_time_entry(Date nurse_time_entry) {
        this.nurse_time_entry = nurse_time_entry;
    }
}
