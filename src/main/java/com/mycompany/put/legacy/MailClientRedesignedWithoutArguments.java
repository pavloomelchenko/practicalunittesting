package com.mycompany.put.legacy;

public class MailClientRedesignedWithoutArguments {
	private EmailServerRedesigned emailServer;

	public MailClientRedesignedWithoutArguments(EmailServerRedesigned emailServer) {
		super();
		this.emailServer = emailServer;
	}

	public void sendEmail(String address, String title, String body) {
		Email email = new Email(address, title, body);
		emailServer.sendEmail(email);
	}
}