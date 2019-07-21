package com.example.demo.service;

import com.example.demo.mapper.CustomerMapper;
import com.example.demo.mapper.DepartmentDao;
import com.example.demo.mapper.ManageMapper;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import java.util.HashMap;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class Customer_server implements Customer_service{

    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private ManageMapper manageMapper;

    public void save(customer new_customer){
        if(customerMapper.cus_info(new_customer.getCus_account())!=null){
            customerMapper.cus_update(new_customer);
        }
        else{
            customerMapper.insert_cus(new_customer);
        }
    }

    public Collection<customer> getAll(){
        Collection<customer> customers ;
        customers = manageMapper.cus_info();
        return  customers;

    }
    public customer get(String account){
        return manageMapper.cus_account_info(account);
    }

    public void delete(String account){
        manageMapper.delete_cus(account);

    }

}

