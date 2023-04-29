package com.friendly.eco.exception;

public class MemNameException extends RuntimeException{
	public MemNameException(String msg) {
		super(msg);
	}
	
	public MemNameException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
