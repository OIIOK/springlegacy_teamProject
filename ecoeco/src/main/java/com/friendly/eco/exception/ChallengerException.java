package com.friendly.eco.exception;

public class ChallengerException extends RuntimeException{
	
	public ChallengerException(String msg) {
		super(msg);
	}
	
	public ChallengerException(String msg, Throwable e) {
		super(msg, e);
	}
}
