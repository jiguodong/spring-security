package com.security.core.validate.code;

import com.security.core.properties.SecurityProperties;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Author: 计国栋
 * @Date: 2018-07-31
 * @Time: 13:56
 */
@RestController
public class ValidateCodeController {
    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private ValidateCreatImageCode validateCreatImageCode;
    @GetMapping("/code/image")
    public void creatCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode = validateCreatImageCode.CreatImageCode(new ServletWebRequest(request));
        //保存请求的request的对象
        ServletRequestAttributes servletRequestAttributes =new ServletWebRequest(request);
        sessionStrategy.setAttribute(servletRequestAttributes,SESSION_KEY,imageCode);
        ImageIO.write(imageCode.getImage(),"JPEG",response.getOutputStream());
    }



}
