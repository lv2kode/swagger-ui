package com.lv2code.exceptions;

public class NoSuchCustomerException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	public NoSuchCustomerException() {
		super();
	}
	
	public NoSuchCustomerException(String errors) {
		super(errors);
	}
}
