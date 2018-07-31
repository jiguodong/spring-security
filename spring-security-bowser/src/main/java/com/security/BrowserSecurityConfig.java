package com.security;

import com.security.authentication.AuthenticationFailureHandle;
import com.security.authentication.AuthenticationSuccess;
import com.security.core.properties.SecurityProperties;
import com.security.core.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author: 计国栋
 * @Date: 2018-07-27
 * @Time: 10:36
 * Web 安全应用适配器
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private AuthenticationSuccess authenticationSuccess;
    @Autowired
    private AuthenticationFailureHandle authenticationFailureHandle;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 安全管理
     *启动时加载，求请时也会访问。
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //自定义的图形验证过滤器
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        //添加登陆错误handler
        validateCodeFilter.setAuthenticationFailureHandler(authenticationFailureHandle);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        http.addFilterBefore(validateCodeFilter,UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                //配置表单登录页面
                .loginPage("/authentication/require")
                //配置表单登录url
                .loginProcessingUrl("/authentication/form")
                .successHandler(authenticationSuccess)
                .failureHandler(authenticationFailureHandle)
                .and()
                .authorizeRequests()  //对请求做授权。
                .antMatchers("/authentication/require", securityProperties.getBrowser().getLoginPage(),"/code/image").permitAll()
                .anyRequest()//任何请求
                .authenticated()//都需要身份认证
                .and()
                .csrf().disable();//关闭跨站请求防护
    }
}
