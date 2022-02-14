package com.flightapp.booking.exception;

public class RecordAlreadyPresentException extends RuntimeException {
	public RecordAlreadyPresentException(String s) {
		super(s);
	}
}
