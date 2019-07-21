package com.example.demo.mapper;

//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Date;
////import com.example.demo.model.Department;
//import com.example.demo.model.newnurseinfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import com.example.demo.mapper.NurseDao;
//import com.example.demo.model.Nurse_test;
//
//@Repository
//public class NewNurseDao {
//    public static Date dates;
//    private static Map<String, newnurseinfo> newNurses = null;
//
//    @Autowired
//    private DepartmentDao departmentDao;
//
//    NurseDao tmp=new NurseDao();
//
//    Nurse_test obj=new Nurse_test();
//
//    static{
//        newNurses = new HashMap<String, newnurseinfo>();
//
//        newNurses.put("17777777777", new newnurseinfo("17777777777", "123", "张昊", "男", "111.111.111.111", "88888888@qq.com", "88888888","17777777777",7,177.7,"nb", "在岗"));
//    }
//
//    public Collection<newnurseinfo> getAll(){
//        return newNurses.values();
//    }
//
//    public void save(newnurseinfo newn){
////        if(employee.getNurse_account() == null){
////            employee.setId(initId++);
////        }
//        System.out.println();
////        System.out.println(newn.getNew_account());
//        obj.setNurse_account(newn.getNew_account());
////        System.out.println(obj.getNurse_account());
//        obj.setNurse_password(newn.getNew_password());
//        obj.setNurse_name(newn.getNew_name());
//        obj.setNurse_gender(newn.getNew_gender());
//        obj.setNurse_picture(newn.getNew_pic());
//        obj.setNurse_intro(newn.getNew_intro());
//        obj.setNurse_level(newn.getNew_level());
////        System.out.println(newn.getNew_phone());
//        obj.setNurse_phone(newn.getNew_phone());
////        System.out.println(obj.getNurse_phone());
//        obj.setNurse_email(newn.getNew_email());
//        obj.setNurse_qq(newn.getNew_qq());
//        obj.setNurse_price(newn.getNew_price());
//        obj.setNurse_state("在职");
//        obj.setNurse_time_entry(new Date());
//        tmp.save(obj);
////        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
////        nurses.put(nurse.getNew_account(), nurse);
//    }
//    public newnurseinfo get(String new_account){
//        return newNurses.get(new_account);
//    }
//
//    public void delete(String new_account){
//        newNurses.remove(new_account);
//    }
//}
