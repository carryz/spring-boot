package com.example.demo.Controller;

import com.example.demo.configer.WebMvcConfg;
import com.example.demo.model.Login_guest;
import com.example.demo.model.User;
import com.example.demo.service.Login_Server;
import com.example.demo.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

//@RestController
@Controller
@EnableAutoConfiguration
//@Controller
public class User_Controller {
    @Resource
//    private Login_Server guest;
    //控制层不予许有任何实现逻辑
    private Login_Server guest;
    public String col;
    public String Value;
    //以下是登录
    @RequestMapping(value = "/userLogin/submit",method = RequestMethod.POST)
    public String userLogin(HttpServletRequest request,Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String select_login = request.getParameter("login_select");
        System.out.println(select_login);
        if(guest.ExistUser(username, password,select_login)){
            request.getSession().setAttribute(WebMvcConfg.SESSION_KEY,username);
            if(select_login.equals("管理员"))
                return "redirect:/houtai";
            else if(select_login.equals("客户"))
            {
                System.out.println("shop");
                return "redirect:/shop";
            }
            else{
                return "redirect:/nurseback/index";
            }
        }
        else{
            map.put("msg", "用户名或者密码错误");
            return "login.html";
        }
    }
    //注册验证
    @RequestMapping(value = "/userRegister/verifty",method = RequestMethod.POST)
    @ResponseBody
//    public String RegisterVeritfy(@RequestParam("index") String index, String name){
    public String RegisterVeritfy(String index,String name,String res_select){
        if(index.equals("0")){
            col   = "name";
        }
        else if(index.equals("1")){
            col   = "username";
        }
        System.out.println(col);
        System.out.println(name);
        System.out.println(res_select);
        if(guest.Vertify_guest(col, name,res_select)){
            return "true";
        }
        else{
            return "false";
        }

    }
    //以下是注册
    @RequestMapping(value = "/userRegister/submit",method = RequestMethod.POST)
    public String userRegister(HttpServletRequest request){
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String res_select = request.getParameter("res_select");
//        User u =new User(username,password);
        if(guest.Exist_Username(name,username,res_select)){
            return "用户已经存在,不允许注册";
        }else{
            int i = guest.RegisterUser(name,username, password,res_select);
            if(i==1){
                return "redirect:/";
            }
            else{
                return "redirect:/index";
            }
        }
    }
}
