package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 计国栋
 * @Date: 2018-07-25
 * @Time: 9:14
 */
@SpringBootApplication
@RestController
@ComponentScan("com")
public class DemoApplication {
    public static void main(String[] args){
        SpringApplication.run(DemoApplication.class,args);
    }
    @GetMapping("/hello")
    public String hello(){
        return "Spring security  Hello";
    }
}
