package com.example.demo.service;

import com.example.demo.model.cusreturn;
import com.example.demo.model.cusreturnrecord;
import com.example.demo.model.nurse;
import com.example.demo.model.orderinfo;

import java.util.Collection;
import java.util.Date;

public interface Shop_Service {
    Collection<nurse> get_Nurse();
    void add_order(orderinfo order);
    void add_content(cusreturnrecord record);
    nurse get_nurse(String account);
    void add_return(cusreturn cus_return);
    void update_order(Date begin,Date end);
}
