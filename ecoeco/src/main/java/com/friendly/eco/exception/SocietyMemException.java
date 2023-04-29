package com.friendly.eco.exception;

public class SocietyMemException extends RuntimeException{
	public SocietyMemException(String msg) {
		super(msg);
	}
	
	public SocietyMemException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
