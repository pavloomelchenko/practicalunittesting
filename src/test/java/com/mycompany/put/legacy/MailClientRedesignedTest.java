package com.mycompany.put.legacy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class MailClientRedesignedTest {
	EmailServerRedesigned emailServer = mock(EmailServerRedesigned.class);
	MailClientRedesigned sut = new MailClientRedesigned(emailServer);

	Email email = new Email("address", "title", "body");

	// verify send method called

	@Test
	public void verifyMailClientSendsEmailPowerMock() throws Exception {
		sut.sendEmail(email);

		verify(emailServer).sendEmail(email);
	}
}
