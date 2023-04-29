package com.friendly.eco.exception;

public class MemPhoneException extends RuntimeException{
	public MemPhoneException(String msg) {
		super(msg);
	}
	
	public MemPhoneException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
