package com.cg.cars.exception;

public class AppointmentIdNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	public AppointmentIdNotFoundException(String message) {
		super(message);
	}
}
