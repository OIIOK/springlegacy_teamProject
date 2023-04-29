package com.friendly.eco.exception;

public class MemException extends RuntimeException{
	public MemException(String msg) {
		super(msg);
	}
	
	public MemException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
