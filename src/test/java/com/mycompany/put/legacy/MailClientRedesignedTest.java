package com.mycompany.put.legacy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class MailClientRedesignedTest {
	private EmailServerRedesigned emailServer = mock(EmailServerRedesigned.class);
	private MailClientRedesigned sut = new MailClientRedesigned(emailServer);

	private Email email = new Email("address", "title", "body");

	@Test
	public void verifyMailClientSendsEmailPowerMock() throws Exception {
		sut.sendEmail(email);

		verify(emailServer).sendEmail(email);
	}
}
