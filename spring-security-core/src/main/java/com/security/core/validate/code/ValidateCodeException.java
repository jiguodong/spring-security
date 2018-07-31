package com.security.core.validate.code;


import org.springframework.security.core.AuthenticationException;

/**
 * @Author: 计国栋
 * @Date: 2018-07-31
 * @Time: 14:52
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -7889376983125229775L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
