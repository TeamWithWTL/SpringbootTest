package com.springboot.service.ex;

public class UsernameErrorException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8337875181222053968L;

	public UsernameErrorException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsernameErrorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UsernameErrorException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UsernameErrorException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UsernameErrorException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
