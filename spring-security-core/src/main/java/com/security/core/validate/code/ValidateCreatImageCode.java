package com.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCreatImageCode {
    //图片生成器
    ImageCode CreatImageCode(ServletWebRequest request);
}
