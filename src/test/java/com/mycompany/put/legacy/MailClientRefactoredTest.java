package com.mycompany.put.legacy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class MailClientRefactoredTest {
	private EmailServerRedesigned emailServer = mock(EmailServerRedesigned.class);
	private MailClientRefactored sut = new MailClientRefactoredSubclassed();

	private Email email = new Email("address", "title", "body");

	class MailClientRefactoredSubclassed extends MailClientRefactored {
		@Override
		protected EmailServerRedesigned createEmailServer() {
			return emailServer;
		}
	}

	@Test
	public void verifyMailClientSendsEmail() throws Exception {
		sut.sendEmail(email);
		verify(emailServer).sendEmail(email);
	}
}
