package com.hsx.exception;

/**
 * 注册时判断用户是否存在
 * @author hsx
 *
 */
public class UserExistsException extends Exception {

	public UserExistsException() {
	}

	public UserExistsException(String message) {
		super(message);
	}

	public UserExistsException(Throwable cause) {
		super(cause);
	}

	public UserExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserExistsException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
