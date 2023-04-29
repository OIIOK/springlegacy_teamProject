package com.friendly.eco.exception;

public class ChatterException extends RuntimeException {
	public ChatterException(String msg) {
		super(msg);
	}

	public ChatterException(String msg, Throwable e) {
		super(msg, e);
	}
}