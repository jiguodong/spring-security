package com.security.core.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: 计国栋
 * @Date: 2018-07-31
 * @Time: 16:59
 */
@Getter
@Setter
public class ImageCodeProperties {
    private int length = 6;
    private int expireIn = 60;
    private int width = 67;
    private int height = 23;
}
