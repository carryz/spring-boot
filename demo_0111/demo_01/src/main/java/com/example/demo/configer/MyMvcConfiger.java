package com.example.demo.configer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;

//使用WebMvcConfigurerAdapter来扩展Spring Mvc
@Configuration
//不能加EnableWebMvc,否则禁止掉SpringMvc的自动装配
//Ctrl+O可以打开可以继承或者重写的方法
public class MyMvcConfiger extends WebMvcConfigurerAdapter {
    //视图映射
    public static final String separator= File.separator;
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        //接收到什么连接(urlpath)到什么页面(setViewName()),用于不请求数据直接访问页面的
        registry.addViewController("/").setViewName("login.html");
    }
    //shift+F6给文件改名
    @Bean //将组件注册在容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login.html");
                registry.addViewController("/index.html").setViewName("login.html");
            }
        };
        return adapter;
    }



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //和页面有关的静态目录都放在项目的static目录下
        registry.addResourceHandler("/static/image/**").addResourceLocations("classpath:/static/image/");
        //上传的图片在D盘下的OTA目录下，访问路径如：http://localhost:8081/OTA/d3cf0281-bb7f-40e0-ab77-406db95ccf2c.jpg
        //其中OTA表示访问的前缀。"file:D:/OTA/"是文件真实的存储路径
        registry.addResourceHandler("/image/**").addResourceLocations("file:D:/暑假实习资料/demo_2019_7_11/demo_0111/demo_01/picture/");
        registry.addResourceHandler("/single/image/**").addResourceLocations("file:D:/暑假实习资料/demo_2019_7_11/demo_0111/demo_01/picture/");
        registry.addResourceHandler("/static/images/**").addResourceLocations("classpath:/static/images/");
        registry.addResourceHandler("/single/images/**").addResourceLocations("file:D:/暑假实习资料/demo_2019_7_11/demo_0111/demo_01/src/main/resources/static/images/");
        registry.addResourceHandler("/static/demo_img/**").addResourceLocations("classpath:/static/demo_img/");
        registry.addResourceHandler("/shop_demo/demo_img/**").addResourceLocations("file:/暑假实习资料/demo_2019_7_11/demo_0111/demo_01/src/main/resources/static/demo_img/");


    }
}
