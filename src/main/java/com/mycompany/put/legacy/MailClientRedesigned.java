package com.mycompany.put.legacy;

public class MailClientRedesigned {
	private EmailServerRedesigned emailServer;

	public MailClientRedesigned(EmailServerRedesigned emailServer) {
		this.emailServer = emailServer;
	}

	public void sendEmail(Email email) {
		emailServer.sendEmail(email);
	}

}