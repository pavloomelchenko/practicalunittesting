package com.mycompany.put.legacy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class MailClientRefactoredTest {
	EmailServerRedesigned emailServer = mock(EmailServerRedesigned.class);
	MailClientRefactored sut = new MailClientRefactoredSubclassed();

	Email email = new Email("address", "title", "body");

	class MailClientRefactoredSubclassed extends MailClientRefactored {

		@Override
		protected EmailServerRedesigned createEmailServer() {
			return emailServer;
		}

	}

	// verify send method called

	@Test
	public void verifyMailClientSendsEmailPowerMock() throws Exception {
		sut.sendEmail(email);

		verify(emailServer).sendEmail(email);
	}
}
