package com.friendly.eco.exception;

public class ChatterCommentsException extends RuntimeException {
	public ChatterCommentsException(String msg) {
		super(msg);
	}

	public ChatterCommentsException(String msg, Throwable e) {
		super(msg, e);
	}
}
