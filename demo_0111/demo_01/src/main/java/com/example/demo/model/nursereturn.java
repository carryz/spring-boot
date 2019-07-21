package com.example.demo.model;

import java.util.Date;

public class nursereturn {
    private String cus_account;
    private String nurse_account;
    private Integer nursereturn_id;
    private Date nurse_return_timr;

    public String getNurse_account() {
        return nurse_account;
    }

    public String getCus_account() {
        return cus_account;
    }

    public void setNurse_account(String nurse_account) {
        this.nurse_account = nurse_account;
    }

    public void setCus_account(String cus_account) {
        this.cus_account = cus_account;
    }

    public Date getNurse_return_timr() {
        return nurse_return_timr;
    }

    public Integer getNursereturn_id() {
        return nursereturn_id;
    }

    public void setNurse_return_timr(Date nurse_return_timr) {
        this.nurse_return_timr = nurse_return_timr;
    }

    public void setNursereturn_id(Integer nursereturn_id) {
        this.nursereturn_id = nursereturn_id;
    }
}
