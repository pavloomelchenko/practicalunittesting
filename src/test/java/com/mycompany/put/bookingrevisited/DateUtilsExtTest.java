package com.mycompany.put.bookingrevisited;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class DateUtilsExtTest {
	@Test
	public void givenNotStartOfHourIsStartOfHourShouldReturnFalse(){
		assertFalse(DateUtilsExt.isStartOfHour(new Date()));
	}
	
	@Test
	public void givenStartOfHourIsStartOfHourShouldReturnTrue(){
		assertTrue(DateUtilsExt.isStartOfHour(DateUtilsExt.truncate(new Date())));
	}
}
