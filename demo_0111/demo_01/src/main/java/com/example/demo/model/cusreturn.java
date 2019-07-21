package com.example.demo.model;

import java.util.Date;

public class cusreturn {
    private String cus_account;
    private Integer cusreturn_id;
    private String nurse_account;
    private Date cus_return_time;

    public void setCusreturn_id(Integer cusreturn_id) {
        this.cusreturn_id = cusreturn_id;
    }

    public Integer getCusreturn_id() {
        return cusreturn_id;
    }

    public void setCus_account(String cus_account) {
        this.cus_account = cus_account;
    }

    public void setNurse_account(String nurse_account) {
        this.nurse_account = nurse_account;
    }

    public Date getCus_return_time() {
        return cus_return_time;
    }

    public String getCus_account() {
        return cus_account;
    }

    public String getNurse_account() {
        return nurse_account;
    }

    public void setCus_return_time(Date cus_return_time) {
        this.cus_return_time = cus_return_time;
    }
}
