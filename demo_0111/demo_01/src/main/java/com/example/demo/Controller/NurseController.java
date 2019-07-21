package com.example.demo.Controller;

import com.example.demo.mapper.DepartmentDao;
import com.example.demo.model.Department;
import com.example.demo.model.nurse;
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
public class NurseController{
    //查询所有员工返回列表页面
    @Autowired
    NurseService nurseService;
    @Autowired
    UploadImageService uploadImageService;
    //跳转到员工列表页面
    @GetMapping("/nurses")
    public String list(Model model){
        Collection<nurse> employees = nurseService.getAll();

        model.addAttribute("nurses", employees);
        return "nurse/list.html";
    }
    //跳转到添加页面
    @GetMapping("/nurse")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的部门
        return "nurse/add.html";
    }
    //员工添加
    @PostMapping("/nurse")
    //spring mvc会自动将请求对象和入参对象一一对应，要求请求参数和JAVABean里面属性参数名一致即可
    public String addEmp(nurse employee, Model model, @RequestParam(value = "file", required = true) MultipartFile file,
                         HttpSession session, HttpServletRequest request)throws IOException {
//        System.out.println("Hello");
        //来到员工列表页面
//        if(employee==null){
//            System.out.println("false");
//        }
//        else{
//            System.out.println("true");
//        }
//        System.out.println(employee.toString());
        String str;
        StringBuffer url = request.getRequestURL();
        System.out.println("URL:"+url.toString());
        try{
            if(file!=null){
                //获取当前项目的路径
                String pathRoot=request.getSession().getServletContext().getRealPath("");
                System.out.println("当前项目的路径为:"+pathRoot);
                //生成UUID作为文件夹名称
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                System.out.println("文件名称："+uuid);
                //获取上传文件类型
                String contentType = file.getContentType();
                System.out.println("文件类型为:"+contentType);
                //获得文件后缀名称
                String imageName=contentType.substring(contentType.indexOf("/")+1);
                System.out.println("文件后缀名称："+imageName);
//                if (!"BMP".equals(imageName) || !"JPG".equals(imageName)
//                        || !"JPEG".equals(imageName) ||! "bmp".equals(imageName)
//                        || !"jpg".equals(imageName) || !"jpeg".equals(imageName)){
//                    //file.transferTo(new File(tmpFilePath));
//                    model.addAttribute("status", "0");
//                    model.addAttribute("message", "文件格式不正确");
//                    return "emp/add.html";
//                }

                String filepath = "D:/暑假实习资料/demo_2019_7_11/demo_0111/demo_01/picture/";
                //获取项目路径
                //E:\暑假实习\母婴信息管理系统\demo_0111\demo_01\
//                String path = ResourceUtils.getURL("classpath:").getPath();
//                System.out.println("path"+path);

                String imagename=employee.getNurse_account()+"/";
                System.out.println("imagename:"+imagename);
                String path = filepath+imagename;
                System.out.println("path:"+path);

                //如果不存在，则创建新文件夹
                File f=new File(path);
                if(!f.exists()){
                    f.mkdirs();
                }
                //新生成的文件名称
                String fileName=employee.getNurse_account()+"."+imageName;
                System.out.println("新生成的文件名称："+fileName);
                session.setAttribute("fileName",fileName);
                //图片保存的完整路径
                String pathName=path+fileName;
                System.out.println(pathName);
                //图片的静态资源路径
                String staticPath="/upload/image/"+employee.getNurse_account()+"/"+fileName;
                System.out.println("静态资源路径："+staticPath);

                //复制操作
                //将图片从源位置复制到目标位置
                file.transferTo(new File(pathName));
                model.addAttribute("location", pathName);
                //nurse_pictures
                String tmp="image/"+employee.getNurse_account()+"/"+fileName;
                employee.setNurse_picture(tmp);
            }
        }catch(Exception e){

        }
//        if(uploadImageService.uploadImage(file)){
//            model.addAttribute("status", 0);
//        }
//        else{
//            model.addAttribute("status", 1);
//        }
        nurseService.save(employee);
        return "redirect:/nurses";
    }
    //员工修改
    //来到修改页面，先查询员工信息并进行回显，再提交进行修改
    @GetMapping("/nurse/{nurse_account}")
    public String toEditPage(@PathVariable("nurse_account") String nurse_account,Model model){
        System.out.println(nurse_account);
        nurse nurse = nurseService.get(nurse_account);
        System.out.println(nurse.toString());
        model.addAttribute("nurse", nurse);

        //来到添加页面,查出所有的部门
        //Collection<Department> departments = departmentDao.getDepartments();
        //model.addAttribute("depts", departments);
        return "nurse/update.html";
    }
    //员工提交修改申请以后进行响应
    @PutMapping("/nurse")
    public String updateEmployee(nurse employee,@RequestParam(value = "file", required = true) MultipartFile file, HttpSession session, HttpServletRequest request){
//        System.out.println("Hello");
        //System.out.println("update");
//        System.out.println(employee);


        String str;
        StringBuffer url = request.getRequestURL();
        System.out.println("URL:"+url.toString());
        try{
            if(file!=null){
                //获取当前项目的路径
                String pathRoot=request.getSession().getServletContext().getRealPath("");
                System.out.println("当前项目的路径为:"+pathRoot);
                //生成UUID作为文件夹名称
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                System.out.println("文件名称："+uuid);
                //获取上传文件类型
                String contentType = file.getContentType();
                System.out.println("文件类型为:"+contentType);
                //获得文件后缀名称
                String imageName=contentType.substring(contentType.indexOf("/")+1);
                System.out.println("文件后缀名称："+imageName);
//                if (!"BMP".equals(imageName) || !"JPG".equals(imageName)
//                        || !"JPEG".equals(imageName) ||! "bmp".equals(imageName)
//                        || !"jpg".equals(imageName) || !"jpeg".equals(imageName)){
//                    //file.transferTo(new File(tmpFilePath));
//                    model.addAttribute("status", "0");
//                    model.addAttribute("message", "文件格式不正确");
//                    return "emp/add.html";
//                }

                String filepath = "D:/暑假实习资料/demo_2019_7_11/demo_0111/demo_01/picture/";
//                String deletepath = filepath+employee.getNurse_picture();
//
//                File deletefile = new File(deletepath);
//                System.out.println(deletepath);
//                if(deletefile.delete()) System.out.println(deletepath);
                //获取项目路径
//                String path = ResourceUtils.getURL("classpath:").getPath();
//                System.out.println("path"+path);

                String imagename=employee.getNurse_account()+"/";
                System.out.println("imagename:"+imagename);
                String path = filepath+imagename;
                System.out.println("path:"+path);

                //如果不存在，则创建新文件夹
                File f=new File(path);
                if(!f.exists()){
                    System.out.println("文件不存在");
                    f.mkdirs();
                }else{
                    System.out.println("文件存在");
                    //获取文件夹下所有图片并删除
                    File[] files = f.listFiles();
                    for(File image:files){
                        if(image.delete()){
                            System.out.println("删除图片成功");
                        }
                        else{
                            System.out.println("删除图片失败");
                        }
                    }
//                    if(f.delete()){
//                        System.out.println("删除 "+path+" 成功!");
//                    }
//                    else{
//                        System.out.println("删除 "+path+" 失败!");
//                    }
                }
                //新生成的文件名称
                String fileName=employee.getNurse_account()+"."+imageName;
                System.out.println("新生成的文件名称："+fileName);
                session.setAttribute("fileName",fileName);
                //图片保存的完整路径
                String pathName=path+fileName;
                System.out.println(pathName);

                //图片的静态资源路径
                String staticPath="/upload/image/"+employee.getNurse_account()+"/"+fileName;
                System.out.println("静态资源路径："+staticPath);

                //复制操作
                //将图片从源位置复制到目标位置
                file.transferTo(new File(pathName));
              //  model.addAttribute("location", pathName);
                //nurse_pictures
                String tmp="image/"+employee.getNurse_account()+"/"+fileName;
                System.out.println("tmp" + tmp);
                employee.setNurse_picture(tmp);

//                //根据日期来创建对应的文件夹
//                String datePath=new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
//                System.out.println("日期："+datePath);
            }
        }catch(Exception e){

        }


        nurseService.save(employee);
        return "redirect:/nurses";
    }
    //员工进行删除
    @DeleteMapping("/nurse/{nurse_account}")
    public String deleteEmployee(@PathVariable("nurse_account") String nurse_account){
        nurseService.delete(nurse_account);
        return "redirect:/nurses";
    }
}
