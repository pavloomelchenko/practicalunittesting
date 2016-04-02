package com.mycompany.put.booking;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import com.mycompany.put.booking.BookingSystem;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;



@RunWith(JUnitParamsRunner.class)
public class BookingSystemTest {
	private static final int sample_hour = 16;
	
	BookingSystem system = new BookingSystem();
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void shouldReturnAListOfBookedHours(){
		system.book(sample_hour);
		boolean[] bookedHoursArray = new boolean[24];
		bookedHoursArray[sample_hour] = true;
		assertArrayEquals(bookedHoursArray, system.listOfBookedHours());
	}
	
	
	@Test
	public void shouldNotAllowAParticularHourToBeDoubleBooked(){
		expectedEx.expect(RuntimeException.class);
	    expectedEx.expectMessage("Not allowed a particular hour to be double-booked");
		system.book(sample_hour);
		system.book(sample_hour);
	}
	
	@Test
	@Parameters(method="illegalValues")
	public void shouldDealInASensibleMannerWithIllegalValues(int illegalValue){
		expectedEx.expect(RuntimeException.class);
	    expectedEx.expectMessage("Invalid input");
	    system.book(illegalValue);
	}
	
	
	protected Object illegalValues() {
        return new Object[]{new Object[]{-1},
        		new Object[]{25}};
    }
	//TODO unbook test
}
