package com.example.demo.Controller;

import com.example.demo.configer.WebMvcConfg;
import com.example.demo.mapper.NurseMapper;
import com.example.demo.model.customer;
import com.example.demo.model.nurse;

import com.example.demo.model.orderinfo;
import com.example.demo.service.Nurse_Service;
import com.example.demo.service.Orderinfo_Server;
import com.example.demo.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

@Controller//返回页面
public class NursebackController {

    @Autowired
    Nurse_Service nurse_service;


    @Autowired
    Orderinfo_Server orderinfo_server;

    @RequestMapping("/nurseback/index")
    public String toindex(Model model, HttpServletRequest request) {
        String account = (String) request.getSession().getAttribute(WebMvcConfg.SESSION_KEY);
        nurse the_nurse = nurse_service.get(account);
        System.out.println(account);
        model.addAttribute("the_nurse",the_nurse);
        return "NurseBack/index.html";
    }
    @RequestMapping("/nurseback/underway")
    public String tounderway(Model model,HttpServletRequest request) {
        Date date = new Date();
        String account = (String) request.getSession().getAttribute(WebMvcConfg.SESSION_KEY);
        Collection<orderinfo> order = orderinfo_server.get_order(account,date);

//        model.addAttribute("Nursefinish",orderinfo2);
        nurse the_nurse = nurse_service.get(account);
        model.addAttribute("the_nurse",the_nurse);
        model.addAttribute("orders",order);
        return "NurseBack/underway.html";
    }

    @RequestMapping("/nurseback/finished")
    public String tofinish(Model model,HttpServletRequest request) {
        Date date = new Date();
        String account = (String) request.getSession().getAttribute(WebMvcConfg.SESSION_KEY);
        Collection<orderinfo> order = orderinfo_server.get_order_finish(account,date);

//        model.addAttribute("Nursefinish",orderinfo2);
        nurse the_nurse = nurse_service.get(account);
        model.addAttribute("the_nurse",the_nurse);
        model.addAttribute("orders",order);
        return "NurseBack/finished.html";
    }

    @RequestMapping("/nurseback/edit")
    public String toedit(Model model,HttpServletRequest request) {
        String account = (String) request.getSession().getAttribute(WebMvcConfg.SESSION_KEY);
        nurse the_nurse = nurse_service.get(account);
        model.addAttribute("nurseedit",the_nurse);

        return "NurseBack/edit.html";
    }
    //员工提交修改申请以后进行响应
    @PutMapping("/nurseedit")
    public String updateEmployee(nurse nurse1){

        nurse_service.save(nurse1);
        return "redirect:/nurseback/index";
    }

}
