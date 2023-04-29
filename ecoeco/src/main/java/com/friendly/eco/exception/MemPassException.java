package com.friendly.eco.exception;

public class MemPassException extends RuntimeException{
	public MemPassException(String msg) {
		super(msg);
	}
	
	public MemPassException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
