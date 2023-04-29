package com.friendly.eco.exception;

public class MemEmailException extends RuntimeException{
	public MemEmailException(String msg) {
		super(msg);
	}
	
	public MemEmailException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
