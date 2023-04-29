package com.friendly.eco.exception;

public class NewsCommentsException extends RuntimeException {
	public NewsCommentsException(String msg) {
		super(msg);
	}

	public NewsCommentsException(String msg, Throwable e) {
		super(msg, e);
	}
}