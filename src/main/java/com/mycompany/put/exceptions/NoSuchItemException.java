package com.mycompany.put.exceptions;

public class NoSuchItemException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoSuchItemException(String string) {
		super(string);
	}

}
