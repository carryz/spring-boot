//package com.example.demo.Controller;
//
//import com.example.demo.mapper.DepartmentDao;
//import com.example.demo.mapper.EmployeeDao;
//import com.example.demo.mapper.NurseMapper;
//import com.example.demo.mapper.NurseReturn_TestDao;
//import com.example.demo.model.*;
//import com.example.demo.service.Customer_server;
//import com.example.demo.service.ReturnService;
//import com.example.demo.service.UploadImageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
////import sun.security.util.Length;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.io.File;
//import java.io.IOException;
//import java.util.*;
//
//@Controller
//public class Cus_returnController {
//    //查询所有员工返回列表页面
//    @Autowired
//    ReturnService returnService;
//    //NurseReturn_TestDao nurseDao;
//
//    //@Autowired
//    //UploadImageService uploadImageService;
//    //跳转到员工列表页面
////    @GetMapping("/cus_return")
////    public String list(Model model) {
////        //     System.out.println("1111111111111");
////        List<cusreturnrecord> cus_record = returnService.get_cus_record();
////        model.addAttribute("cus_record", cus_record);
////        return "/cus_return/list.html";
////    }
//    @GetMapping("/cus_return")
//    public String list(Model model) {
//        //     System.out.println("1111111111111");
//        Map<cusreturn,cusreturnrecord> map = new HashMap<>();
//        List<cusreturn> cus_return = returnService.get_cus_return();
//        List<cusreturnrecord> cus_record = returnService.get_cus_record();
//
//        for (int i = 0;i< cus_record.size();i++)
//        {
//            map.put(cus_return.get(i),cus_record.get(i));
//            System.out.println(cus_record.get(i).getCusreturn_id()+"/"+cus_return.get(i).getCusreturn_id());
//        }
//
//        //   model.addAttribute("cus_return",cus_return);
//        model.addAttribute("cus_record", map);
//        return "cus_return/list.html";
//    }
//
//    //跳转到添加页面
//    @GetMapping("/cus_record")
//    public String toAddPage() {
//        //来到添加页面,查出所有的部门
//        // Collection<Department> departments = departmentDao.getDepartments();
//        // model.addAttribute("depts", departments);
//        System.out.println("1");
//        return "cus_return/add.html";
//    }
//    //员工添加
//    @PostMapping("/cus_record")
//    public String addEmp(String content)
//    {
//        cusreturnrecord record = new cusreturnrecord();
//        List<cusreturnrecord> cus_record = returnService.get_cus_record();
//        record.setCusreturn_id(cus_record.size());
//        record.setCusreturn_content(content);
//        returnService.insert_cus_record(record);
//        return "redirect:/cus_return";
//    }
//
//    //员工添加
////    @PostMapping("/empp")
////    //spring mvc会自动将请求对象和入参对象一一对应，要求请求参数和JAVABean里面属性参数名一致即可
////    public String addEmp(nursereturnrecord record, Model model,HttpSession session, HttpServletRequest request)throws IOException {
////        System.out.println("2");
//////        //来到员工列表页面
//////        if(record==null){
//////            System.out.println("false");
//////        }
//////        else{
//////            System.out.println("true");
//////        }
//////        System.out.println(record.toString());
//////        String str;
//////        StringBuffer url = request.getRequestURL();
//////        System.out.println("URL:"+url.toString());
////        /*try{
////            if(file!=null){
////                //获取当前项目的路径
////                String pathRoot=request.getSession().getServletContext().getRealPath("");
////                System.out.println("当前项目的路径为:"+pathRoot);
////                //生成UUID作为文件夹名称
////                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
////                System.out.println("文件名称："+uuid);
////                //获取上传文件类型
////                String contentType = file.getContentType();
////                System.out.println("文件类型为:"+contentType);
////                //获得文件后缀名称
////                String imageName=contentType.substring(contentType.indexOf("/")+1);
////                System.out.println("文件后缀名称："+imageName);
//////                if (!"BMP".equals(imageName) || !"JPG".equals(imageName)
//////                        || !"JPEG".equals(imageName) ||! "bmp".equals(imageName)
//////                        || !"jpg".equals(imageName) || !"jpeg".equals(imageName)){
//////                    //file.transferTo(new File(tmpFilePath));
//////                    model.addAttribute("status", "0");
//////                    model.addAttribute("message", "文件格式不正确");
//////                    return "emp/add.html";
//////                }
////
////                String filepath = "E:/demo_01/src/main/resources/static/image/";
////                //获取项目路径
//////                String path = ResourceUtils.getURL("classpath:").getPath();
//////                System.out.println("path"+path);
////
////                String imagename=employee.getLastName()+"/";
////                System.out.println("imagename:"+imagename);
////                String path = filepath+imagename;
////                System.out.println("path:"+path);
////
////                //如果不存在，则创建新文件夹
////                File f=new File(path);
////                if(!f.exists()){
////                    f.mkdirs();
////                }
////                //新生成的文件名称
////                String fileName=uuid+"."+imageName;
////                System.out.println("新生成的文件名称："+fileName);
////                session.setAttribute("fileName",fileName);
////                //图片保存的完整路径
////                String pathName=path+fileName;
////                System.out.println(pathName);
////                //图片的静态资源路径
////                String staticPath="/upload/images/"+employee.getLastName()+"/"+fileName;
////                System.out.println("静态资源路径："+staticPath);
////
////                //复制操作
////                //将图片从源位置复制到目标位置
////                file.transferTo(new File(pathName));
////                model.addAttribute("location", pathName);
//////                //根据日期来创建对应的文件夹
//////                String datePath=new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
//////                System.out.println("日期："+datePath);
////            }
////        }catch(Exception e){
////
////        }
//////        if(uploadImageService.uploadImage(file)){
//////            model.addAttribute("status", 0);
//////        }
//////        else{
//////            model.addAttribute("status", 1);
//////        }
////*/
////        nurseDao.save(record);
////        return "redirect:/nurse_return";
////    }
//    //员工修改
//    //来到修改页面，先查询员工信息并进行回显，再提交进行修改
////    @GetMapping("/cus_record/{id}")
////    public String toEditPage(@PathVariable("id") Integer id, Model model){
////        cusreturnrecord record = returnService.get_a_record(id);
////        System.out.println(id);
////        model.addAttribute("cus_record", record);
////        System.out.println(record.getCusreturn_content());
////        System.out.println("3");
//////        //来到添加页面,查出所有的部门
//////        Collection<Department> departments = departmentDao.getDepartments();
//////        model.addAttribute("depts", departments);
////        return "cus_return/update.html";
////    }
//    //员工修改
//    //来到修改页面，先查询员工信息并进行回显，再提交进行修改
//    @GetMapping("/cus_record/{id}")
//    public String toEditPage(@PathVariable("id") Integer id, Model model){
//        cusreturnrecord record = returnService.get_a_record(id);
//        cusreturn cus_return = returnService.get_acus_return(id);
//        System.out.println(id);
//        model.addAttribute("cus_return",cus_return);
//        model.addAttribute("cus_record", record);
//        System.out.println(record.getCusreturn_content());
//        System.out.println("3");
////        //来到添加页面,查出所有的部门
////        Collection<Department> departments = departmentDao.getDepartments();
////        model.addAttribute("depts", departments);
//        return "cus_return/update.html";
//    }
//    //员工提交修改申请以后进行响应
//    @PutMapping("/cus_record")
//    public String updateEmployee(String method,Integer id,String content){
//        System.out.println("4");
//        cusreturnrecord record = new cusreturnrecord();
//        record.setCusreturn_id(id);
//        record.setCusreturn_content(content);
//        System.out.println(method);
//        System.out.println(record);
//        returnService.update_cus_record(record);
//        return "redirect:/cus_return";
//    }
//    //员工进行删除
//    @DeleteMapping("/cus_record/{id}")
//    public String deleteEmployee(@PathVariable("id") Integer id){
//        returnService.delete_cus_record(id);
//        System.out.println("5");
//        return "redirect:/cus_return";
//    }
//}
package com.example.demo.Controller;

import com.example.demo.mapper.DepartmentDao;
import com.example.demo.mapper.EmployeeDao;
import com.example.demo.mapper.NurseMapper;
import com.example.demo.mapper.NurseReturn_TestDao;
import com.example.demo.model.*;
import com.example.demo.service.Customer_server;
import com.example.demo.service.ReturnService;
import com.example.demo.service.UploadImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
//import sun.security.util.Length;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class Cus_returnController {
    //查询所有员工返回列表页面
    @Autowired
    ReturnService returnService;
    //NurseReturn_TestDao nurseDao;

    //@Autowired
    //UploadImageService uploadImageService;
    //跳转到员工列表页面
    @GetMapping("/cus_return")
    public String list(Model model) {
        //     System.out.println("1111111111111");
        Map<cusreturn,cusreturnrecord> map = new HashMap<>();
        List<cusreturn> cus_return = returnService.get_cus_return();
        List<cusreturnrecord> cus_record = returnService.get_cus_record();

        for (int i = 0;i< cus_record.size();i++)
        {
            map.put(cus_return.get(i),cus_record.get(i));
            System.out.println(cus_record.get(i).getCusreturn_id()+"/"+cus_return.get(i).getCusreturn_id());
        }

        //   model.addAttribute("cus_return",cus_return);
        model.addAttribute("cus_record", map);
        return "cus_return/list.html";
    }

    //跳转到添加页面
    @GetMapping("/cus_record")
    public String toAddPage() {
        //来到添加页面,查出所有的部门
        // Collection<Department> departments = departmentDao.getDepartments();
        // model.addAttribute("depts", departments);
        System.out.println("1");
        return "cus_return/add.html";
    }
    //员工添加
    @PostMapping("/cus_record")
    public String addEmp(String content)
    {
        cusreturnrecord record = new cusreturnrecord();
        List<cusreturnrecord> cus_record = returnService.get_cus_record();
        record.setCusreturn_id(cus_record.size());
        record.setCusreturn_content(content);
        returnService.insert_cus_record(record);
        return "redirect:/cus_return";
    }


    //员工修改
    //来到修改页面，先查询员工信息并进行回显，再提交进行修改
    @GetMapping("/cus_record/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        cusreturnrecord record = returnService.get_a_record(id);
        cusreturn cus_return = returnService.get_acus_return(id);
        System.out.println(id);
        model.addAttribute("cus_return",cus_return);
        model.addAttribute("cus_record", record);
        System.out.println(record.getCusreturn_content());
        System.out.println("3");
//        //来到添加页面,查出所有的部门
//        Collection<Department> departments = departmentDao.getDepartments();
//        model.addAttribute("depts", departments);
        return "cus_return/update.html";
    }
    //员工提交修改申请以后进行响应
    @PutMapping("/cus_record")
    public String updateEmployee(String method,Integer id,String content){
        System.out.println("4");
        cusreturnrecord record = new cusreturnrecord();
        record.setCusreturn_id(id);
        record.setCusreturn_content(content);
        System.out.println(method);
        System.out.println(record);
        returnService.update_cus_record(record);
        return "redirect:/cus_return";
    }
    //员工进行删除
    @DeleteMapping("/cus_record/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        returnService.delete_cus_record(id);
        System.out.println("5");
        return "redirect:/cus_return";
    }
}
