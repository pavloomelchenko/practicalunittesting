package com.mycompany.put.bookingrevisited;

import java.util.Calendar;
import java.util.Date;

public class BookingEntry implements Comparable<BookingEntry>{
	Date startTime;
	Date endTime;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public BookingEntry(Date startTime, Date endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public BookingEntry(Date startTime, int hours) {
		super();
		this.startTime = startTime;
		Calendar cal = Calendar.getInstance();
		cal.setTime(startTime);
		cal.add(Calendar.HOUR, hours);
		cal.add(Calendar.MINUTE, -1);
		this.endTime = cal.getTime();
	}

	@Override
	public int compareTo(BookingEntry o) {
		if (this.startTime.before(o.getStartTime())){
			return -1;
		}
		if (this.startTime.after(o.getStartTime())){
			return 1;
		}
		return 0;
	}

}

