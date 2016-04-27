package com.hsx.exception;

/**
 * 若Dao层抛出运行时异常，则使用这个异常
 * @author hsx
 *
 */
public class UserDaoException extends RuntimeException {

	public UserDaoException() {
	}

	public UserDaoException(String message) {
		super(message);
	}

	public UserDaoException(Throwable cause) {
		super(cause);
	}

	public UserDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserDaoException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
