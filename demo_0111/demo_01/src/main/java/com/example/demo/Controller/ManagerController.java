package com.example.demo.Controller;

        import com.example.demo.configer.WebMvcConfg;
        import com.example.demo.mapper.DepartmentDao;
        import com.example.demo.mapper.ManageMapper;
        import com.example.demo.model.Department;
        import com.example.demo.model.manager;
        import com.example.demo.service.ManagerService;
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
public class ManagerController{
    //查询所有员工返回列表页面
    @Autowired
    ManagerService managerService;

    //跳转到员工列表页面
    @GetMapping("/managers")
    public String list(Model model,HttpServletRequest request){
        String account = (String) request.getSession().getAttribute(WebMvcConfg.SESSION_KEY);
        System.out.println(account);
        manager employees = managerService.get(account);

        model.addAttribute("managers", employees);
        return "/manager/list.html";
    }
    //    //跳转到添加页面
//    @GetMapping("/manager")
//    public String toAddPage(Model model){
//        //来到添加页面,查出所有的部门
//        Collection<Department> departments = departmentDao.getDepartments();
//        model.addAttribute("depts", departments);
//        return "manager/add.html";
//    }
//    //员工添加
//
    @GetMapping("/manager/{manager_account}")
    public String toEditPage(@PathVariable("manager_account") String manager_account,Model model){
        //System.out.println(manager_account);
        manager manage = managerService.get(manager_account);
        System.out.println(manage.toString());
        model.addAttribute("manager", manage);
        return "manager/update.html";
    }
    //员工提交修改申请以后进行响应
    @PutMapping("/manager")
    public String updateEmployee(manager employee){
//        System.out.println("Hello");
//        System.out.println(employee);
        managerService.save(employee);
        return "redirect:/managers";
    }
//    //员工进行删除
//    @DeleteMapping("/nurse/{nurse_account}")
//    public String deleteEmployee(@PathVariable("nurse_account") String nurse_account){
//        employeeDao.delete(nurse_account);
//        return "redirect:/nurses";
//    }
}
