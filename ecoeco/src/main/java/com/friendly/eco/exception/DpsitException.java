package com.friendly.eco.exception;

public class DpsitException extends RuntimeException{
	
	public DpsitException(String msg) {
		super(msg);
	}
	
	public DpsitException(String msg, Throwable e) {
		super(msg, e);
	}
}
