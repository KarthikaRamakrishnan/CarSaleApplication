package com.cg.cars.exception;

public class InvalidPasswordOrUserIdException extends Exception{
	private static final long serialVersionUID = 1L;

		public InvalidPasswordOrUserIdException() {
			super();
		}
	public InvalidPasswordOrUserIdException(String exception) {
		super(exception);
	}


}
