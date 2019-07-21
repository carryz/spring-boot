package com.example.demo.service;

import com.example.demo.mapper.CustomerMapper;
import com.example.demo.mapper.ManageMapper;
import com.example.demo.mapper.NurseMapper;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Collection;
import java.util.HashMap;


@Service
public class Orderinfo_Server implements Order_Service{
    @Resource
    ManageMapper manageMapper;
    @Resource
    NurseMapper nurseMapper;
    @Resource
    CustomerMapper customerMapper;

    @Override
    public void save(orderinfo order){
        System.out.println(order.getOrder_id());
        if(manageMapper.get_order(order.getOrder_id()) != null){
            System.out.println("11111");
            manageMapper.update_order(order);
        }
        else {
            System.out.println("2222");
            manageMapper.insert_order(order);
        }
    }
    @Override
    public Collection<orderinfo> getAll(){
       // System.out.print(orderinfos.values());
        return manageMapper.showorder();
    }
    @Override
    public orderinfo get(Integer id){

        return manageMapper.get_order(id);
    }

    @Override
    public Collection<orderinfo> get_order(String account, Date date){
        return manageMapper.nurseorder(account,date);
    }

    @Override
    public Collection<orderinfo> get_order_cusbefore(String account, Date date){
        return manageMapper.cusorder(account,date);
    }
    @Override
    public Collection<orderinfo> get_order_cusfinish(String account, Date date){
        return manageMapper.cusorder_finish(account,date);
    }

    @Override
    public void delete(Integer id){
        manageMapper.delete_order(id);
    }

    @Override
    public Collection<orderinfo> get_order_finish(String account, Date date){
        return manageMapper.nurseorder_finish(account,date);
    }

}

