//package com.example.demo.mapper;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Date;
////import com.example.demo.model.Department;
//import com.example.demo.model.manager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//
//@Repository
//public class ManagerDao {
//    public static Date dates;
//    private static Map<String, manager> managers = null;
//
//
//    static{
//        managers = new HashMap<String, manager>();
//
//        managers.put("17777777777", new manager("17777777777", "123", "张昊", "男", "17777777777", "88888888@qq.com"));
//    }
//
//    public Collection<manager> getAll(){
//        return managers.values();
//    }
//
//    public void save(manager man){
////        if(employee.getNurse_account() == null){
////            employee.setId(initId++);
////        }
//
////        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
//        managers.put(man.getManager_account(), man);
//    }
//    public manager get(String manager_account){
//        return managers.get(manager_account);
//    }
//
//    public void delete(String manager_account){
//        managers.remove(manager_account);
//    }
//}
