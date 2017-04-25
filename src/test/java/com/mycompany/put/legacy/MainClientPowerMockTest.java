package com.mycompany.put.legacy;

import static org.mockito.Mockito.times;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/*
 * This class relies on unchangable legacy code. Besides other classes in this package use redesign, refactor and subclass or mockito partial mocking.
 */
@PrepareForTest({ EmailServer.class })
@RunWith(PowerMockRunner.class)
public class MainClientPowerMockTest {
	MailClient sut = new MailClient();

	Email email = new Email("address", "title", "body");

	/*
	 * This test uses equals on verify. It also uses powermock features to
	 * verify static method call.
	 */
	@Test
	public void verifyMailClientSendsEmailUsingEquals() throws Exception {
		PowerMockito.mockStatic(EmailServer.class);
		sut.sendEmail("address", "title", "body");
		PowerMockito.verifyStatic(times(1));
		EmailServer.sendEmail(email);
	}

}
