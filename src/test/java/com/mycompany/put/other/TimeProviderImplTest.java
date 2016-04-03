package com.mycompany.put.other;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.Calendar;

import org.junit.Test;

public class TimeProviderImplTest {
	TimeProvider provider = mock(TimeProviderImpl.class);

	@Test
	public void shouldAnswerThatItIsMorningIfHourOfDayIsLessThan12Hours() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 11);
		doReturn(cal).when(provider).getTime();
		doCallRealMethod().when(provider).isItMorning();
		assertTrue(provider.isItMorning());
	}

	@Test
	public void shouldAnswerThatItIsNotMorningIfHourOfDayIsMoreThan12Hours() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 12);
		doReturn(cal).when(provider).getTime();
		doCallRealMethod().when(provider).isItMorning();
		assertFalse(provider.isItMorning());
	}
}
