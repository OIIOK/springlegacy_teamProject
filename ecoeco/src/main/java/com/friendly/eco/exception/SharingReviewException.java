package com.friendly.eco.exception;

public class SharingReviewException extends RuntimeException {
	public SharingReviewException(String msg) {
		super(msg);
	}

	public SharingReviewException(String msg, Throwable e) {
		super(msg, e);
	}
}
