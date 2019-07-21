package com.example.demo.service;

import com.example.demo.mapper.CustomerMapper;
import com.example.demo.mapper.LoginMapper;
import com.example.demo.mapper.ManageMapper;
import com.example.demo.mapper.NurseMapper;
import com.example.demo.model.customer;
import com.example.demo.model.nurse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Login_Server {
//写好接口
      @Autowired
     // public LoginMapper loginMapper;//创建一个对象
      public ManageMapper manageMapper;

     @Autowired
    // public LoginMapper loginMapper;//创建一个对象
     public NurseMapper nurseMapper;
     @Autowired
    // public LoginMapper loginMapper;//创建一个对象
     public CustomerMapper customerMapper;

      //获取单个用户的信息
      public boolean ExistUser(String username,String password,String login_select){
          if(login_select.equals("客户") )
          {
              System.out.println(customerMapper.cus_login(username,password));
              return customerMapper.cus_login(username,password) != null;
          }
          else  if(login_select.equals("育婴师"))
          {
              return nurseMapper.login_find(username,password) != null;
          }
          else {
              return manageMapper.findmanage(username, password) != null;
          }
      }

      public Boolean Vertify_guest(String col,String Value,String login_select) {
          System.out.println(col+Value);
          if(login_select.equals("育婴师")) {
              if (col == "name") {
                  System.out.println(nurseMapper.get_name_nurse(Value));
                  return nurseMapper.get_name_nurse(Value) != null;
              } else if (col == "username") {
                  return nurseMapper.get_username_nurse(Value) != null;
              }
          }
          else if(login_select.equals("客户")) {
              if (col == "name") {
                  System.out.println(customerMapper.cus_name_get(Value));
                  return customerMapper.cus_name_get(Value) != null;
              } else if (col == "username") {
                  return customerMapper.cus_info(Value) != null;
              }
          }
          return false;
      }
//          System.out.println(loginMapper.Vertify_guest(col, Value));
//          return loginMapper.Vertify_guest(col, Value)!=null;
//      }

      public boolean Exist_Username(String name,String username,String res_select){
          if(res_select.equals("客户")) {
              return customerMapper.cus_login(name, username) != null;
          }
          else{
              return nurseMapper.login_find(name, username) != null;
          }
      }
      public int RegisterUser(String name,String username,String password,String res_select){
//          loginMapper.Insertguest(username, password);
         // return manageMapper.insert_manager(name,username, password);
          if(res_select.equals("客户")){
              customer cus = new customer();
              cus.setCus_account(username);
              cus.setCus_name(name);
              cus.setCus_password(password);
              System.out.println(cus.getCus_account()+res_select);

              int a = customerMapper.insert_cus(cus);
              System.out.println(a);
              return a;
          }
          else {
              nurse nur = new nurse();
              nur.setNurse_account(username);
              nur.setNurse_name(name);
              nur.setNurse_password(password);
              System.out.println(nur.getNurse_account()+res_select);
              return nurseMapper.newnurse(nur);
          }
      }
//    //获取所有用户信息
//
//    public ArrayList<person> selectAllUser(){
//        return userMapper.selectAllUser();
//    }
}
