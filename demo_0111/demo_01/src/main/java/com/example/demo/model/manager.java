package com.example.demo.model;

public class manager {
    private String manager_account;
    private String manager_password;
    private String manager_name;
    private String manager_gender;
    private String manager_phone;
    private String manager_email;

    public String getManager_account(){
        return manager_account;
    }
    public String getManager_password(){
        return manager_password;
    }
    public String getManager_name(){
        return manager_name;
    }
    public String getManager_gender(){
        return manager_gender;
    }
    public String getManager_phone(){
        return manager_phone;
    }
    public String getManager_email(){
        return manager_email;
    }

    public void setManager_account(String manager_account) {
        this.manager_account = manager_account;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public void setManager_email(String manager_email) {
        this.manager_email = manager_email;
    }

    public void setManager_gender(String manager_gender) {
        this.manager_gender = manager_gender;
    }

    public void setManager_password(String manager_password) {
        this.manager_password = manager_password;
    }

    public void setManager_phone(String manager_phone) {
        this.manager_phone = manager_phone;
    }
}
