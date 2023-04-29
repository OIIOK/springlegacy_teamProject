package com.friendly.eco.exception;

public class MemBirthException extends RuntimeException{
	public MemBirthException(String msg) {
		super(msg);
	}
	
	public MemBirthException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
