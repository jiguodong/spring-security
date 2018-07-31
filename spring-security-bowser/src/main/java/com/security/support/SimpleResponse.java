/**
 * 
 */
package com.security.support;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhailiang
 *
 */
@Getter
@Setter
@ToString
public class SimpleResponse {
	
	public SimpleResponse(Object content){
		this.content = content;
	}
	
	private Object content;


	
}
