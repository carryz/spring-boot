package com.example.demo.service;

import com.example.demo.mapper.ManageMapper;
import com.example.demo.model.manager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
@Service
public class ManagerService implements Manager_Service {

    @Resource
    ManageMapper manageMapper;

    @Override
    public void save(manager man){
        manageMapper.insert_manager(man);
    }
    @Override
    public manager get(String manager_account){
        return manageMapper.find_username_manager(manager_account);
    }
    @Override
    public void delete(String manager_account){

    }
}
