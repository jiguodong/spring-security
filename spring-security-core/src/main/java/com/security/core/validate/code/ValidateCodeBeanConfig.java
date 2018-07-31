package com.security.core.validate.code;

import com.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidateCodeBeanConfig {
    @Autowired
    private SecurityProperties securityProperties;
    @Bean
    @ConditionalOnMissingBean(name = "creatImageCode")
    public ValidateCreatImageCode creatImageCode(){
        CreatImageCode creatImageCode = new CreatImageCode();
        creatImageCode.setSecurityProperties(securityProperties);
        return creatImageCode;
    }
}
