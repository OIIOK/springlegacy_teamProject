package com.friendly.eco.exception;

public class SponsorException extends RuntimeException {
	public SponsorException(String msg) {
		super(msg);
	}

	public SponsorException(String msg, Throwable e) {
		super(msg, e);
	}
}