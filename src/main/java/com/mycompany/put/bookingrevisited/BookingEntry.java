package com.mycompany.put.bookingrevisited;

import java.util.Calendar;
import java.util.Date;

public class BookingEntry implements Comparable<BookingEntry> {
	private Long id;
	private Date startTime;
	private Date endTime;

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
		if (this.startTime.before(o.getStartTime())) {
			return -1;
		}
		if (this.startTime.after(o.getStartTime())) {
			return 1;
		}
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingEntry other = (BookingEntry) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
