package com.friendly.eco.exception;

public class SharingApplicantException extends RuntimeException {
	public SharingApplicantException(String msg) {
		super(msg);
	}

	public SharingApplicantException(String msg, Throwable e) {
		super(msg, e);
	}
}
