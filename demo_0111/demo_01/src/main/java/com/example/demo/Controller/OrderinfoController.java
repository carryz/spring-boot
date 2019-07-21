package com.example.demo.Controller;

import com.example.demo.mapper.CustomerMapper;
import com.example.demo.model.orderinfo;
import com.example.demo.service.Customer_server;
import com.example.demo.service.Orderinfo_Server;
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
public class OrderinfoController {
    //查询所有员工返回列表页面

    @Autowired
    Orderinfo_Server orderinfo_server;
    @Autowired
    UploadImageService uploadImageService;

    @GetMapping("/ords")
    public String list(Model model) {
        Collection<orderinfo> orders = orderinfo_server.getAll();
        model.addAttribute("ords",orders);

        return "ord/list.html";

    }
    //跳转到添加页面
    @GetMapping("/ord")
    public String toAddPage(){
        //来到添加页面,查出所有的部门
        //Collection<customer> departments = departmentDao.getDepartments();
        //model.addAttribute("depts", departments);
        return "ord/add.html";
    }
    //员工添加
    @PostMapping("/ord")
    //spring mvc会自动将请求对象和入参对象一一对应，要求请求参数和JAVABean里面属性参数名一致即可
    public String addEmp(orderinfo orderinfol, Model model,
                         HttpSession session, HttpServletRequest request)throws IOException {
        orderinfo_server.save(orderinfol);
        return "redirect:/ords";
    }
    //员工修改
    //来到修改页面，先查询员工信息并进行回显，再提交进行修改
    @GetMapping("/ord/{order_id}")
    public String toEditPage(@PathVariable("order_id") Integer id,Model model){
        orderinfo order = orderinfo_server.get(id);
//        System.out.println("0000");
        model.addAttribute("ord", order);

//        System.out.println("1111");
        //来到添加页面,查出所有的部门
        //Collection<Department> departments = departmentDao.getDepartments();
        // model.addAttribute("depts", departments);
        return "ord/update.html";
    }
    //员工提交修改申请以后进行响应
    @PutMapping("/ord")
    public String updatecustomer(orderinfo ord){
       // System.out.println(method);
        System.out.println(ord.getOrder_id());
        orderinfo_server.save(ord);
        return "redirect:/ords";
    }
    //员工进行删除
    @DeleteMapping("/ord/{order_id}")
    public String deleteEmployee(@PathVariable("order_id") Integer order_id){
        orderinfo_server.delete(order_id);
        return "redirect:/ords";
    }
}

