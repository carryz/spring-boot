package com.example.demo.Controller;

import com.example.demo.mapper.DepartmentDao;
import com.example.demo.mapper.ManageMapper;
import com.example.demo.model.Department;
import com.example.demo.model.newnurseinfo;
import com.example.demo.service.NurseService;
import com.example.demo.service.UploadImageService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;



@Controller
public class NewNurseController{
    //查询所有员工返回列表页面
    @Autowired
    NurseService nurseService;
    //跳转到员工列表页面
    @GetMapping("/newNurses")
    public String list(Model model){
        Collection<newnurseinfo> employees = nurseService.show_new();

        model.addAttribute("newNurses", employees);
        return "/new_nurse/list.html";
    }
    //员工通过审核——添加

    //员工修改
    //来到修改页面，先查询员工信息并进行回显，再提交进行修改
    @GetMapping("/newNurse/{new_account}")
    public String toEditPage(@PathVariable("new_account") String new_account,Model model){
        System.out.println(new_account);
        newnurseinfo newNurse = nurseService.get_new(new_account);
       // System.out.println(newNurse.toString());
        model.addAttribute("newNurse", newNurse);

        //来到添加页面,查出所有的部门
        //Collection<Department> departments = departmentDao.getDepartments();
        //model.addAttribute("depts", departments);
        return "new_nurse/check.html";
    }
    //员工提交修改申请以后进行响应
    @PutMapping("/newNurse")
    public String updateEmployee(newnurseinfo employee){
//        System.out.println("Hello");
        System.out.println(employee.getNew_pic());
        nurseService.insert(employee);
        System.out.println("00000");
        nurseService.delete_new(employee.getNew_account());
        return "redirect:/newNurses";
    }
    //员工未通过审核——删除
    @DeleteMapping("/newNurse/{new_account}")
    public String deleteEmployee(@PathVariable("new_account") String new_account){
        System.out.println("11111111");
        nurseService.delete_new(new_account);
        return "redirect:/newNurses";
    }
}
