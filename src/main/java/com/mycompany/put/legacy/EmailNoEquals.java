package com.mycompany.put.legacy;

public class EmailNoEquals extends Email {
	public EmailNoEquals(String address, String title, String body) {
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
