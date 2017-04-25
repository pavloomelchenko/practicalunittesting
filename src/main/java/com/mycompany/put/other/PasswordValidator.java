package com.mycompany.put.other;

public class PasswordValidator {

	public final static int REQUIRED_LENGTH = 6;
	public final static int REQUIRED_DIGITS = 2;

	public boolean validate(String passwordToValidate) {
		if (passwordToValidate.length() < REQUIRED_LENGTH) {
			throw new IllegalArgumentException(
					"Password doesn't match required length");
		}
		if (getDigitsNumber(passwordToValidate) < REQUIRED_DIGITS) {
			throw new IllegalArgumentException(
					"Password doesn't have enough digits");
		}
		if (!containsUnderscore(passwordToValidate)) {
			throw new IllegalArgumentException(
					"Password doesn't contain underscore");
		}
		return false;
	}

	private int getDigitsNumber(String s) {
		int count = 0;
		for (int i = 0, len = s.length(); i < len; i++) {
			if (Character.isDigit(s.charAt(i))) {
				count++;
			}
		}
		return count;
	}

	private boolean containsUnderscore(String s) {
		return s.indexOf('_') != -1;
	}

}
