package com.friendly.eco.exception;

public class SharingException extends RuntimeException {
	public SharingException(String msg) {
		super(msg);
	}

	public SharingException(String msg, Throwable e) {
		super(msg, e);
	}
}
