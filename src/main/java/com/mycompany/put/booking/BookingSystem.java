package com.mycompany.put.booking;

/**
 * Simplified booking system
 * 
 * @author Pavlo Omelchenko
 *
 */
public class BookingSystem {

	private boolean[] bookedHours = new boolean[24];

	public void book(int sampleHour) {
		if (sampleHour < 0 || sampleHour > 24)
			throw new RuntimeException("Invalid input");
		if (bookedHours[sampleHour])
			throw new RuntimeException("Not allowed a particular hour to be double-booked");
		bookedHours[sampleHour] = true;
	}

	public boolean[] listOfBookedHours() {
		return bookedHours;
	}

}
