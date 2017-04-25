package com.mycompany.put.raceresults;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class RaceResultsServiceTest {
	private LogService logService = mock(LogService.class);
	private RaceResultsService raceResultsService = new RaceResultsService(
			logService);
	private Client sampleClient = mock(Client.class);
	private Message sampleMessage = mock(Message.class);
	private Categories sampleCategory = Categories.General;

	@Before
	public void before() {
		doReturn(sampleCategory).when(sampleMessage).getCategory();
	}

	@Test
	public void shouldAllowClientsToSubscribe() {
		raceResultsService.subscribe(sampleClient, sampleCategory);
	}

	@Test
	public void shouldAllowClientsToUnsubscribe() {
		raceResultsService.unsubscribe(sampleClient, sampleCategory);
	}

	@Test
	public void shouldReceiveMessagesIfSubscribed() {
		raceResultsService.subscribe(sampleClient, sampleCategory);
		raceResultsService.send(sampleMessage);
		verify(sampleClient).receive(sampleMessage);
	}

	@Test
	public void shouldNotReceiveMessagesIfUnsubscribed() {
		raceResultsService.subscribe(sampleClient, sampleCategory);
		raceResultsService.unsubscribe(sampleClient, sampleCategory);
		raceResultsService.send(sampleMessage);
		verify(sampleClient, never()).receive(sampleMessage);
	}

	@Test
	public void everyTimeANewMessageComesItShouldBeSentToAllSubscribers() {
		raceResultsService.subscribe(sampleClient, sampleCategory);
		Client otherClient = mock(Client.class);
		raceResultsService.subscribe(otherClient, sampleCategory);
		raceResultsService.send(sampleMessage);
		verify(sampleClient).receive(sampleMessage);
		verify(otherClient).receive(sampleMessage);
	}

	@Test
	public void ifTheClientIsNotSubscribedItShouldNotReceiveAnyMessages() {
		raceResultsService.send(sampleMessage);
		verify(sampleClient, never()).receive(sampleMessage);
	}

	@Test
	public void verifyThatConsecutiveSubscribeRequestsIssuedByTheSameClientWillBeIgnored() {
		raceResultsService.subscribe(sampleClient, sampleCategory);
		raceResultsService.subscribe(sampleClient, sampleCategory);
		raceResultsService.send(sampleMessage);
		verify(sampleClient).receive(sampleMessage);
	}

	@Test
	public void shouldSendMessagesWithTheResultsOfDifferentCategoriesOfRace() {
		sampleMessage.setCategory(Categories.HorseRaces);
		raceResultsService.send(sampleMessage);
	}

	@Test
	public void subscribersShouldBeAbleToSubscribeToSelectedCategories() {
		raceResultsService.subscribe(sampleClient, Categories.F1Races);
	}

	@Test
	public void clientShouldNotReceiveMessagesRelatedToTheCategoriesHeHasNotSignedUp() {
		raceResultsService.subscribe(sampleClient, Categories.F1Races);
		doReturn(Categories.HorseRaces).when(sampleMessage)
				.getCategory();
		raceResultsService.send(sampleMessage);
		verify(sampleClient, never()).receive(sampleMessage);
	}

	@Test
	public void eachMessageSentShouldBeLogged() {
		String sampleText = "123";
		Date sampleDate = new Date();

		doReturn(sampleText).when(sampleMessage).getText();
		doReturn(sampleDate).when(sampleMessage).getDate();
		raceResultsService.send(sampleMessage);
		verify(logService).log(sampleDate + sampleText);

	}
}
