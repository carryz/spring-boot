package com.example.demo.Controller;

import com.example.demo.mapper.CustomerMapper;
import com.example.demo.model.customer;
import com.example.demo.service.Customer_server;
import com.example.demo.service.UploadImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Controller
public class CustomerController {
    //查询所有员工返回列表页面
    @Autowired
    CustomerMapper customermapper;
    @Autowired
    Customer_server customer_server;
    @Autowired
    UploadImageService uploadImageService;

    @GetMapping("/cuss")
    public String list(Model model) {
        Collection<customer> customers = customer_server.getAll();
        model.addAttribute("cuss",customers);

        return "cus/list.html";

    }
    //跳转到添加页面
    @GetMapping("/cus")
    public String toAddPage(){
        //来到添加页面,查出所有的部门
        //Collection<customer> departments = departmentDao.getDepartments();
        //model.addAttribute("depts", departments);
        return "cus/add.html";
    }
    //员工添加
    @PostMapping("/cus")
    //spring mvc会自动将请求对象和入参对象一一对应，要求请求参数和JAVABean里面属性参数名一致即可
    public String addEmp(customer customerl, Model model,
                         HttpSession session, HttpServletRequest request)throws IOException {
       customer_server.save(customerl);
        return "redirect:/cuss";
    }
    //员工修改
    //来到修改页面，先查询员工信息并进行回显，再提交进行修改
    @GetMapping("/cus/{cus_account}")
    public String toEditPage(@PathVariable("cus_account") String id,Model model){
        System.out.println(id);
        customer customerl = customer_server.get(id);

        model.addAttribute("cus", customerl);

        //来到添加页面,查出所有的部门
        //Collection<Department> departments = departmentDao.getDepartments();
       // model.addAttribute("depts", departments);
        return "cus/update.html";
    }
    //员工提交修改申请以后进行响应
    @PutMapping("/cus")
    public String updatecustomer(customer customerl){

        System.out.println(customerl.getCus_password());
        customer_server.save(customerl);
        return "redirect:/cuss";
    }
    //员工进行删除
    @DeleteMapping("/cus/{cus_account}")
    public String deleteEmployee(@PathVariable("cus_account") String cus_account){
        customer_server.delete(cus_account);
        return "redirect:/cuss";
    }
}

