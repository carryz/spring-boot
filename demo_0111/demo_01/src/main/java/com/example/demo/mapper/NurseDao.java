//package com.example.demo.mapper;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Date;
////import com.example.demo.model.Department;
//import com.example.demo.model.Nurse_test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//
//@Repository
//public class NurseDao {
//    public static Date dates;
//    private static Map<String, Nurse_test> nurses = null;
//
//    @Autowired
//    private DepartmentDao departmentDao;
//
//    static{
//        nurses = new HashMap<String, Nurse_test>();
//
////        nurses.put("17777777777", new Nurse_test("17777777777", "123", "张昊", "男", "111.111.111.111", "88888888@qq.com", "88888888","17777777777",7,177.7,"nb", "在岗"));
////        nurses.put(1002, new nurse(1002, "E-BB", "bb@163.com", 1, new Department(102, "D-BB")));
////        nurses.put(1003, new nurse(1003, "E-CC", "cc@163.com", 0, new Department(103, "D-CC")));
////        nurses.put(1004, new nurse(1004, "E-DD", "dd@163.com", 0, new Department(104, "D-DD")));
////        nurses.put(1005, new nurse(1005, "E-EE", "ee@163.com", 1, new Department(105, "D-EE")));
//    }
//
//    public Collection<Nurse_test> getAll(){
//        return nurses.values();
//    }
//
//    public void save(Nurse_test nurse){
////        if(employee.getNurse_account() == null){
////            employee.setId(initId++);
////        }
//
////        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
//        nurses.put(nurse.getNurse_account(), nurse);
//    }
//    public Nurse_test get(String nurse_account){
//        return nurses.get(nurse_account);
//    }
//
//    public void delete(String nurse_account){
//        nurses.remove(nurse_account);
//    }
//}
