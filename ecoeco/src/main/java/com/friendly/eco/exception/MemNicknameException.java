package com.friendly.eco.exception;

public class MemNicknameException extends RuntimeException{
	public MemNicknameException(String msg) {
		super(msg);
	}
	
	public MemNicknameException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
