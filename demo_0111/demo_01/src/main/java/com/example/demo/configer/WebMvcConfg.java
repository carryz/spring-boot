package com.example.demo.configer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Configuration
public class WebMvcConfg implements WebMvcConfigurer {

    private static final List<String> EXCLUDE_PATH= Arrays.asList("/userRegister/verifty","/","/css/**","/js/**","/images/**","/Login","/Login_test","/index","/userLogin/submit","/userRegister/submit");
    public final static String SESSION_KEY = "user";
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(EXCLUDE_PATH);
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        System.out.println("picutre");
//        registry.addResourceHandler("/image/**").addResourceLocations("classpath:/image/");
//        WebMvcConfigurer.super.addResourceHandlers(registry);
//    }
}
