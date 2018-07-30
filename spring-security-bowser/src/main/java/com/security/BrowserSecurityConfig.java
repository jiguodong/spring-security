package com.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author: 计国栋
 * @Date: 2018-07-27
 * @Time: 10:36
 * Web 安全应用适配器
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new  BCryptPasswordEncoder();
//    }
    /**
     * 安全管理
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
          http.formLogin() //配置表单登录
                  .loginPage("/imooc-signIn.html")
            .and()
            .authorizeRequests()  //对请求做授权。
                  .antMatchers("/imooc-signIn.html").permitAll()
            .anyRequest()//任何请求
            .authenticated();//都需要身份认证
    }
}
