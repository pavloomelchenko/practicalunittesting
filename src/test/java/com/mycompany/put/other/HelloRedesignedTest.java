package com.mycompany.put.other;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class HelloRedesignedTest {
	private HelloRedesigned hello;
	private TimeProvider timeProvider;

	@Before
	public void setUp() {
		timeProvider = mock(TimeProvider.class);
		hello = new HelloRedesigned(timeProvider);
	}

	@Test
	public void shouldSayGoodMorningInTheMorning() {
		when(timeProvider.isItMorning()).thenReturn(true);
		assertEquals("Good Morning!", hello.sayHello());
	}

	@Test
	public void shouldSayGoodAfternoonInTheAfternoon() {
		when(timeProvider.isItMorning()).thenReturn(false);
		assertEquals("Good Afternoon!", hello.sayHello());
	}

}