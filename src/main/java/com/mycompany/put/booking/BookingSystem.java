package com.mycompany.put.booking;

public class BookingSystem {

	boolean[] bookedHours = new boolean[24];
	
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
