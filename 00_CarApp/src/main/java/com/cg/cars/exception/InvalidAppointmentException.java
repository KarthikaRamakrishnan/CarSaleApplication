package com.cg.cars.exception;

public class InvalidAppointmentException extends Exception{
	private static final long serialVersionUID = 1L;
	public InvalidAppointmentException(String message)
	{
		super(message);
	}
}
