package com.friendly.eco.exception;

public class DonatorException extends RuntimeException{
	
	public DonatorException(String msg) {
		super(msg);
	}
	
	public DonatorException(String msg, Throwable e) {
		super(msg, e);
	}
}
