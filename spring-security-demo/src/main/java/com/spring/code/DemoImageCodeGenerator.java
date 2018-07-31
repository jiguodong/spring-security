/**
 * 
 */
package com.spring.code;

import com.security.core.validate.code.ImageCode;
import com.security.core.validate.code.ValidateCreatImageCode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author zhailiang
 *
 */
//@Component("creatImageCode")
public class DemoImageCodeGenerator implements ValidateCreatImageCode {

	@Override
	public ImageCode CreatImageCode(ServletWebRequest request) {
		System.out.print("更改级 的验证");
		return null;
	}
}
