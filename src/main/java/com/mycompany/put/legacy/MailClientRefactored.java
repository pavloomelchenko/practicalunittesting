package com.mycompany.put.legacy;

public class MailClientRefactored  {
	public void sendEmail(Email email) {
		EmailServerRedesigned emailServerRedesigned = createEmailServer();
		emailServerRedesigned .sendEmail(email);
	}

	protected EmailServerRedesigned createEmailServer() {
		return new EmailServerRedesigned();
	}

}