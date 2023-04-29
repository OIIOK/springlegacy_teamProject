package com.friendly.eco.exception;

public class DpostscriptException extends RuntimeException{
	
	public DpostscriptException(String msg) {
		super(msg);
	}
	
	public DpostscriptException(String msg, Throwable e) {
		super(msg, e);
	}
}
