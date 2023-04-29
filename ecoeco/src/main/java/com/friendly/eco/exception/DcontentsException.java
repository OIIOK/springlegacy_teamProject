package com.friendly.eco.exception;

public class DcontentsException extends RuntimeException{
	
	public DcontentsException(String msg) {
		super(msg);
	}
	
	public DcontentsException(String msg, Throwable e) {
		super(msg, e);
	}
}
