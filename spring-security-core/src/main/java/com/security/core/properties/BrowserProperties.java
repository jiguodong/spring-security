package com.security.core.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: 计国栋
 * @Date: 2018-07-30
 * @Time: 19:35
 */
@Getter
@Setter
@ToString
public class BrowserProperties {
    private String loginPage = "/imooc-signIn.html";
    private LoginType loginType = LoginType.JSON;
}
