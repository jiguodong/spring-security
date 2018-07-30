/**
 * 
 */
package com.spring.exception;

/**
 * @author zhailiang
 *
 */
public class UserNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6112780192479692859L;
	
	private String id;
	private String desc;
	public UserNotExistException(String Code,String desc) {
		this.desc=desc;
		this.id = Code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
