/**
 * 
 */
package com.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhailiang
 *
 */
@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(UserNotExistException.class)
	@ResponseBody
	@ResponseStatus()
	public Map<String, Object> handleUserNotExistException(UserNotExistException ex) {
		Map<String, Object> result = new HashMap<>();
		result.put("code", ex.getId());
		result.put("message", ex.getDesc());
		return result;
	}

}
