package com.example.demo.Controller;

import com.example.demo.configer.WebMvcConfg;
import com.example.demo.model.customer;
import com.example.demo.model.nurse;
import com.example.demo.model.orderinfo;
import com.example.demo.service.Customer_server;
import com.example.demo.service.Orderinfo_Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

@Controller//返回页面
public class CustomerBack {
    @Autowired
    Customer_server customer_server;
    @Autowired
    Orderinfo_Server orderinfo_server;

    @RequestMapping("/customer/index")
    public String toindex(Model model,HttpServletRequest request) {
        String account = (String) request.getSession().getAttribute(WebMvcConfg.SESSION_KEY);
        customer the_cus = customer_server.get(account);
        System.out.println(account);
//        model.addAttribute("customer_first",customer2);
        model.addAttribute("the_cus",the_cus);
        return "CustomerBack/index.html";
    }

    @RequestMapping("/customer/finished")
    public String tofinish(Model model,HttpServletRequest request) {
        Date date = new Date();
        String account = (String) request.getSession().getAttribute(WebMvcConfg.SESSION_KEY);
        Collection<orderinfo> order = orderinfo_server.get_order_cusfinish(account,date);

//        model.addAttribute("Nursefinish",orderinfo2);
        customer the_cus = customer_server.get(account);
        model.addAttribute("the_cus",the_cus);
        model.addAttribute("orders",order);
        return "CustomerBack/finished.html";
    }

    @RequestMapping("/customer/underway")
    public String tounderway(Model model,HttpServletRequest request) {
        Date date = new Date();
        String account = (String) request.getSession().getAttribute(WebMvcConfg.SESSION_KEY);
        Collection<orderinfo> order = orderinfo_server.get_order_cusbefore(account,date);

//        model.addAttribute("Nursefinish",orderinfo2);
        customer the_cus = customer_server.get(account);
        model.addAttribute("the_cus",the_cus);
        model.addAttribute("orders",order);
        return "CustomerBack/underway.html";
    }
    @GetMapping("/customer/edit")
    public String toedit(Model model,HttpServletRequest request) {
        String account = (String) request.getSession().getAttribute(WebMvcConfg.SESSION_KEY);
        customer the_cus = customer_server.get(account);
        model.addAttribute("edits",the_cus);
        return "CustomerBack/edit.html";
    }
    //员工提交修改申请以后进行响应
    @PutMapping("/edits")
    public String updateEmployee(customer customer){
//        System.out.println("Hello");
//        System.out.println(employee);
        customer_server.save(customer);
        return "redirect:/customer/index";
    }

}

