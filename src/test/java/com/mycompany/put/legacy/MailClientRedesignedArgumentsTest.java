package com.mycompany.put.legacy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class MailClientRedesignedArgumentsTest {
	EmailServerRedesigned emailServer = mock(EmailServerRedesigned.class);
	MailClientRedesignedWoArguments sut = new MailClientRedesignedWoArguments(emailServer);

	Email email = new Email("address", "title", "body");
	EmailNoEquals emailNoEquals = new EmailNoEquals("address", "title", "body");
	// verify send method called

	@Test
	public void verifyMailClientSendsEmailEquals() throws Exception {
		sut.sendEmail("address", "title", "body");
		verify(emailServer).sendEmail(email);
	}

	@Test
	public void verifyMailClientSendsEmailArgumentCaptor() throws Exception {
		sut.sendEmail("address", "title", "body");
		ArgumentCaptor<EmailNoEquals> arg = ArgumentCaptor.forClass(EmailNoEquals.class);
		verify(emailServer).sendEmail(arg.capture());
		Email argEmail = arg.getValue();
		assertEquals("address", argEmail.getAddress());
		assertEquals("title", argEmail.getTitle());
		assertEquals("body", argEmail.getBody());
	}
}
