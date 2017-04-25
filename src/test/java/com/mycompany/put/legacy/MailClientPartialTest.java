package com.mycompany.put.legacy;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class MailClientPartialTest {
	EmailServerRedesigned emailServer = mock(EmailServerRedesigned.class);
	MailClientPartial sut = spy(MailClientPartial.class);

	Email email = new Email("address", "title", "body");


	// verify send method called

	@Test
	public void verifyMailClientSendsEmail() throws Exception {
		doReturn(emailServer).when(sut).createEmailServer();
		sut.sendEmail(email);
		verify(emailServer).sendEmail(email);
	}
}
