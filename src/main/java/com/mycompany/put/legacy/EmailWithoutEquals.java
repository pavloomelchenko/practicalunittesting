package com.mycompany.put.legacy;

/**
 * Legacy-like implementation to test code with ArgumentCaptors
 * 
 * @author Pavlo Omelchenko
 *
 */
public class EmailWithoutEquals extends Email {
	public EmailWithoutEquals(String address, String title, String body) {
		super(address, title, body);
	}

	@Override
	public int hashCode() {
		throw new RuntimeException("Not implemented or behaves differently");
	}

	@Override
	public boolean equals(Object obj) {
		throw new RuntimeException("Not implemented or behaves differently");
	}

}
