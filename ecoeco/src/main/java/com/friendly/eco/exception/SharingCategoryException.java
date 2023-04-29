package com.friendly.eco.exception;

public class SharingCategoryException extends RuntimeException {
	public SharingCategoryException(String msg) {
		super(msg);
	}

	public SharingCategoryException(String msg, Throwable e) {
		super(msg, e);
	}
}
