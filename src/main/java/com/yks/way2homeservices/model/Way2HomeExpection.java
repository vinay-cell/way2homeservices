package com.yks.way2homeservices.model;

public class Way2HomeExpection extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String PURPOSE_GENERAL = null;

	public static Object status;

	public Way2HomeExpection() {
		super();
	}

	public Way2HomeExpection(String msg, Throwable cause) {
		super(msg, cause);
	}

	public Way2HomeExpection(String msg) {
		super(msg);
	}

	public Way2HomeExpection(Throwable cause) {
		super(cause);
	}

}
