package com.example.demo.Controller;

import com.example.demo.configer.WebMvcConfg;
import com.example.demo.model.cusreturn;
import com.example.demo.model.cusreturnrecord;
import com.example.demo.model.nurse;
import com.example.demo.model.orderinfo;
import com.example.demo.service.ManagerService;
import com.example.demo.service.Return_Service;
import com.example.demo.service.Shop_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Date;

@Controller
public class Shop_Controller {

    @Autowired
    Shop_Service shop_service;

    @Autowired
    Return_Service return_service;

    @RequestMapping("/shop")
    public String to_index(Model model){
        System.out.println("cmckadka");
        Collection<nurse> nurses = shop_service.get_Nurse();
        System.out.println(nurses);
        model.addAttribute("products",nurses);
        return "User/index.html";
    }

    @RequestMapping("/shop_contact/{nurse_account}")
    public String to_Contact(@PathVariable("nurse_account")String account,Model model){
        nurse the_nurse = shop_service.get_nurse(account);
        model.addAttribute("chose",the_nurse);
        return "User/contact.html";
    }
    @RequestMapping("/shop_demo/{nurse_account}")
    public String to_Demo(@PathVariable("nurse_account")String account,Model model) {
        System.out.println(account);

        model.addAttribute("talk_man",account);
        return "User/demo.html";
    }
    @GetMapping("/single/{nurse_account}")
    public String to_single(@PathVariable("nurse_account") String nurse_account, Model model){
        System.out.println(nurse_account);
        nurse   the_nurse = shop_service.get_nurse(nurse_account);

        model.addAttribute("the_product",the_nurse);
        return "User/single-product.html";
    }

    @PostMapping("/orderget")
    public String to_single(HttpServletRequest request, Date begin, Date end, String nurse_account){
        String cus_account = (String) request.getSession().getAttribute(WebMvcConfg.SESSION_KEY);
        orderinfo order = new orderinfo();
        order.setCus_account(cus_account);
        order.setNurse_account(nurse_account);
        order.setOrder_begintime(begin);
        order.setOrder_endtime(end);

        System.out.println(nurse_account + "\n"+ cus_account + "\n"+ begin.toString() +"\n"+ end.toString() );

        // order.setOrder_id(1);
        shop_service.add_order(order);
        return "redirect:/shop";
    }


    @RequestMapping("/talk")
    @ResponseBody
    public String  talk_nurse(HttpServletRequest request,String account,String content){
        String cus_account = (String) request.getSession().getAttribute(WebMvcConfg.SESSION_KEY);
        System.out.println(account+ cus_account + content);
        cusreturn cus_return = new cusreturn();
        cus_return.setCus_account(cus_account);
        cus_return.setNurse_account(account);
        int id = (return_service.get_cus_record()).size();
        cus_return.setCusreturn_id(id);
        Date date = new Date();
        cus_return.setCus_return_time(date);
        shop_service.add_return(cus_return);
        cusreturnrecord record = new cusreturnrecord();
        record.setCusreturn_content(content);
        record.setCusreturn_id(id);
        shop_service.add_content(record);
        return "  ";
    }

}
