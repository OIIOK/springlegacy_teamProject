package com.friendly.eco.exception;

public class EcoMapCategoryException extends RuntimeException {
	public EcoMapCategoryException(String msg) {
		super(msg);
	}

	public EcoMapCategoryException(String msg, Throwable e) {
		super(msg, e);
	}
}
