package com.friendly.eco.exception;

public class MemTypeException extends RuntimeException{
	public MemTypeException(String msg) {
		super(msg);
	}
	
	public MemTypeException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
