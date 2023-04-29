package com.friendly.eco.exception;

public class ChallengeException extends RuntimeException{
	
	public ChallengeException(String msg) {
		super(msg);
	}
	
	public ChallengeException(String msg, Throwable e) {
		super(msg, e);
	}
}
