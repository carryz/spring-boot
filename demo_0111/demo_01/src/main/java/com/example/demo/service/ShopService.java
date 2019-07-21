package com.example.demo.service;

import com.example.demo.mapper.CustomerMapper;
import com.example.demo.mapper.ManageMapper;
import com.example.demo.mapper.NurseMapper;
import com.example.demo.model.cusreturn;
import com.example.demo.model.cusreturnrecord;
import com.example.demo.model.nurse;
import com.example.demo.model.orderinfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Date;

@Service
public class ShopService implements Shop_Service {
    @Resource
    private NurseMapper nurseMapper;

    @Resource
    private ManageMapper manageMapper;

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public Collection<nurse> get_Nurse(){
        return manageMapper.nurse_info();
    }

    @Override
    public void add_order(orderinfo order){
        customerMapper.new_order(order);
    }

    @Override
    public void add_content(cusreturnrecord record){customerMapper.insert_record(record);}

    @Override
    public nurse get_nurse(String account){return manageMapper.nurse_account_info(account);}

    @Override
    public void update_order(Date begin, Date end){

    }

    @Override
    public void add_return(cusreturn cus_return){
        customerMapper.cus_return(cus_return);
    }
}
