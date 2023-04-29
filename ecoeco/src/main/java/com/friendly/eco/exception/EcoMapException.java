package com.friendly.eco.exception;

public class EcoMapException extends RuntimeException {
	public EcoMapException(String msg) {
		super(msg);
	}

	public EcoMapException(String msg, Throwable e) {
		super(msg, e);
	}
}