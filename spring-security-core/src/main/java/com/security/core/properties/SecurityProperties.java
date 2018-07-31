package com.security.core.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: 计国栋
 * @Date: 2018-07-30
 * @Time: 19:32
 */
@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "com.security")
public class SecurityProperties {
    private BrowserProperties browser = new BrowserProperties();
    private ValidateCodeProperties validateCode = new ValidateCodeProperties();
}
