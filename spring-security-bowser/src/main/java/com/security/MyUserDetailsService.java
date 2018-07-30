package com.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


/**
 * @Author: 计国栋
 * @Date: 2018-07-27
 * @Time: 11:01
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private PasswordEncoder passwordEncoder;
    //可以直接引入Dao,进行数据查询。
    @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("用户名:"+username);
        return new User(username,"123456",AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
