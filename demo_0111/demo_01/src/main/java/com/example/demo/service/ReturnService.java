package com.example.demo.service;

import com.example.demo.mapper.CustomerMapper;
import com.example.demo.mapper.ManageMapper;
import com.example.demo.mapper.NurseMapper;
import com.example.demo.model.cusreturn;
import com.example.demo.model.cusreturnrecord;
import com.example.demo.model.nursereturn;
import com.example.demo.model.nursereturnrecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReturnService implements Return_Service {
//    @Resource
//    private ManageMapper manageMapper;
//    @Resource
//    private NurseMapper nurseMapper;
//    @Resource
//    private CustomerMapper customerMapper;
//
//    @Override
//    public List<nursereturnrecord> get_nurse_record() {
//        return manageMapper.show_nurserecord();
//    }
//    @Override
//    public Boolean insert_nurse_record(nursereturnrecord content){
//        return nurseMapper.nurse_content(content) !=  0;
//    }
//    @Override
//    public Boolean delete_nurse_record(Integer id){
//        return nurseMapper.delete_record(id) != 0;
//    }
//    @Override
//    public nursereturnrecord get_one_record(Integer id){
//        return manageMapper.get_anurse_record(id);
//    }
//    @Override
//    public  Boolean update_nurse_record(nursereturnrecord content) {
//        return nurseMapper.update_record(content) != 0;
//    }
//
//    @Override
//    public List<cusreturnrecord> get_cus_record() {
//        return manageMapper.show_cusrecord();
//    }
//    @Override
//    public Boolean insert_cus_record(cusreturnrecord content){
//        return customerMapper.insert_record(content) !=  0;
//    }
//    @Override
//    public Boolean delete_cus_record(Integer id){
//        return customerMapper.delete_cus_record(id) != 0;
//    }
//    @Override
//    public cusreturnrecord get_a_record(Integer id){
//        return customerMapper.show_record(id);
//    }
//    @Override
//    public  Boolean update_cus_record(cusreturnrecord content) {
//        return customerMapper.update(content) != 0;
//    }
//    @Override
//    public List<cusreturn> get_cus_return(){
//        return manageMapper.show_cusreturn();
//    }
//    @Override
//    public nursereturn get_anurse_return(Integer id){
//        return manageMapper.show_a_nursereturn(id);
//    }
//    @Override
//    public cusreturn get_acus_return(Integer id){
//        return manageMapper.show_a_cusreturn(id);
//    }
@Resource
private ManageMapper manageMapper;
    @Resource
    private NurseMapper nurseMapper;
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public List<nursereturnrecord> get_nurse_record() {
        return manageMapper.show_nurserecord();
    }
    @Override
    public Boolean insert_nurse_record(nursereturnrecord content){
        return nurseMapper.nurse_content(content) !=  0;
    }
    @Override
    public Boolean delete_nurse_record(Integer id){
        return nurseMapper.delete_record(id) != 0;
    }
    @Override
    public nursereturnrecord get_one_record(Integer id){
        return manageMapper.get_anurse_record(id);
    }
    @Override
    public  Boolean update_nurse_record(nursereturnrecord content) {
        return nurseMapper.update_record(content) != 0;
    }

    @Override
    public List<cusreturnrecord> get_cus_record() {
        return manageMapper.show_cusrecord();
    }
    @Override
    public Boolean insert_cus_record(cusreturnrecord content){
        return customerMapper.insert_record(content) !=  0;
    }
    @Override
    public Boolean delete_cus_record(Integer id){
        return customerMapper.delete_cus_record(id) != 0;
    }
    @Override
    public cusreturnrecord get_a_record(Integer id){
        return customerMapper.show_record(id);
    }
    @Override
    public  Boolean update_cus_record(cusreturnrecord content) {
        return customerMapper.update(content) != 0;
    }

    @Override
    public List<cusreturn> get_cus_return(){
        return manageMapper.show_cusreturn();
    }

    @Override
    public cusreturn get_acus_return(Integer id){
        return manageMapper.show_a_cusreturn(id);
    }

    public List<nursereturn> get_nurse_return(){
        return manageMapper.show_nursereturn();
    }
    public nursereturn get_anurse_return(Integer id){
        return manageMapper.show_a_nursereturn(id);
    }

}
