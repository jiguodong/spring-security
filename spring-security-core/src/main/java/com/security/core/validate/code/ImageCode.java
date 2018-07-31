package com.security.core.validate.code;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @Author: 计国栋
 * @Date: 2018-07-31
 * @Time: 13:46
 */
@Getter
@Setter
@ToString
public class ImageCode {
    private String code;
    private BufferedImage image;
    private LocalDateTime expireTime;
    public ImageCode(BufferedImage image,String code,int expireIn){
        this.code = code;
        this.image = image;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);//过期时间=当前时间+多长时间过期
    }
    public boolean isExpired(){
        return LocalDateTime.now().isAfter(expireTime);
    }
}
