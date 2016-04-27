package com.mycompany.put.legacy;

public class MailClientRedesignedWoArguments {
	private EmailServerRedesigned emailServer;

	public MailClientRedesignedWoArguments(EmailServerRedesigned emailServer) {
		super();
		this.emailServer = emailServer;
	}

	public void sendEmail(String address, String title, String body) {
		Email email = new Email(address, title, body);
		emailServer.sendEmail(email);
	}
}