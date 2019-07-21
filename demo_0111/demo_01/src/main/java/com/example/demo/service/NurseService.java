package com.example.demo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
//import com.example.demo.model.Department;
import com.example.demo.mapper.ManageMapper;
import com.example.demo.mapper.NurseMapper;
import com.example.demo.model.newnurseinfo;
import com.example.demo.model.nurse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;


@Repository
public class NurseService  implements  Nurse_Service{
    @Resource
    NurseMapper nurseMapper;
    @Resource
    ManageMapper manageMapper;

    @Override
    public Collection<nurse> getAll(){
        return manageMapper.nurse_info();
    }
    @Override
    public void save(nurse new_nurse){
        System.out.println(new_nurse.getNurse_account());
        if(manageMapper.nurse_account_info(new_nurse.getNurse_account()) != null){
            System.out.println("111");
            manageMapper.update_nurse(new_nurse);
        }
        else{
            System.out.println(222);
            manageMapper.newnurse(new_nurse);
        }

    }
    @Override
    public nurse get(String nurse_account){

        return manageMapper.nurse_account_info(nurse_account);
    }
    @Override
    public void delete(String nurse_account){
        manageMapper.delete_nurse(nurse_account);
    }

    @Override
    public void delete_new(String new_nurse){
        manageMapper.noupdatenurse(new_nurse);
    }
    @Override
    public void insert(newnurseinfo newnurse){
        System.out.println(newnurse.getNew_pic());
        manageMapper.updatenursse(newnurse);
    }

    @Override
    public Collection<newnurseinfo> show_new(){
        return manageMapper.show_update();
    }

    @Override
    public newnurseinfo get_new(String account){
        return manageMapper.get_new_nurse(account);
    }
}
