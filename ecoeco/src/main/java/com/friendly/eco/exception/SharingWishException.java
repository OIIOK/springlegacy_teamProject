package com.friendly.eco.exception;

public class SharingWishException extends RuntimeException {
	public SharingWishException(String msg) {
		super(msg);
	}

	public SharingWishException(String msg, Throwable e) {
		super(msg, e);
	}
}
