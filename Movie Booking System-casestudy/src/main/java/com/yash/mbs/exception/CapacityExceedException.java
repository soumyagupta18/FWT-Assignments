package com.yash.mbs.exception;

@SuppressWarnings("serial")
public class CapacityExceedException extends RuntimeException {

	public CapacityExceedException(String message) {
		super(message);
	}

}
