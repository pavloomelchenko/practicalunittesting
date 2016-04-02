package com.mycompany.put.other;

import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;


public class PasswordValidator {

	public final static int REQUIRED_LENGTH = 6;
	public final static int REQUIRED_DIGITS = 2;
	
	public static boolean validate(String passwordToValidate) {
		if (passwordToValidate.length() < REQUIRED_LENGTH){
			throw new IllegalArgumentException("Doesnt match required length");
		}
		if (getDigitsNumber(passwordToValidate) < REQUIRED_DIGITS){
			throw new IllegalArgumentException("Doesnt have enough digits");
		}
		if (!containsUnderscore(passwordToValidate)){
			throw new IllegalArgumentException("Doesnt contain underscore");
		}
		return false;
	}
	
	private static int getDigitsNumber(String s){
		int count = 0;
		for (int i = 0, len = s.length(); i < len; i++) {
		    if (Character.isDigit(s.charAt(i))) {
				count++;
		    }
		}
		return count;
	}
	
	private static boolean containsUnderscore(String s){
		return s.indexOf('_') != -1;
	}
	
}
