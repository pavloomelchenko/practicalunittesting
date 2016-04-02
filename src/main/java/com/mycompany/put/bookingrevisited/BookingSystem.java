package com.mycompany.put.bookingrevisited;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.mycompany.put.raceresults.LogService;

public class BookingSystem {

	private Map<Long, NavigableSet<BookingEntry>> bookingMap = new HashMap<>();
	Map<Long, Classroom> classrooms = new HashMap<>();
	LogService log;

	public BookingSystem(List<Classroom> list, LogService log) {
		this.classrooms = list.stream().collect(Collectors.toMap(Classroom::getId, Function.identity()));
		this.log = log;
		list.forEach(classroom -> {
			bookingMap.put(classroom.id, new TreeSet<BookingEntry>());
		});
	}

	public Collection<Classroom> existingClassroomList() {
		return classrooms.values();
	}

	public void book(Date sampleDate, long classroom, int hours) {
		removeOldBookings();
		if (!classrooms.containsKey(classroom)) {
			throw new BookingException("Invalid classroom");
		}
		if (!canBook(sampleDate, classroom, hours)) {
			throw new BookingException("Date is booked or not enough range (before next booking) ");
		}
		bookingMap.get(classroom).add(new BookingEntry(sampleDate, hours));
		log.log("Booked " + sampleDate + " classroom" + classroom);
	}

	public boolean canBook(Date sampleDate, long classroom, int hours) {
		// validate round minutes
		validateDate(sampleDate);
		// validate classroom
		if (!classrooms.containsKey(classroom)) {
			throw new BookingException("Invalid classroom");
		}
		// validate hours
		validateHours(hours);
		// if no bookings for this classroom at all
		if (bookingMap.get(classroom).isEmpty()) {
			return true;
		}
		// else iterate over existing bookings
		Iterator<BookingEntry> itr = bookingMap.get(classroom).iterator();
		while (itr.hasNext()) {
			BookingEntry iterBooking = itr.next();
			// if booking under iteration is now
			if (current(iterBooking)) {
				return false;
			}
			// if booking under iteration is in future
			if (future(iterBooking)) {
				// and enough time to book
				Calendar cal = Calendar.getInstance();
				cal.setTime(sampleDate);
				cal.add(Calendar.HOUR, hours);
				if (cal.getTime().before(iterBooking.getStartTime())) {
					return true;
				} else {
					return false;
				}

			}
		}
		return true;
	}

	public boolean isBooked(Date date, long classroomId) {
		validateDate(date);
		if (!classrooms.containsKey(classroomId)) {
			throw new BookingException("Invalid classroom");
		}
		Iterator<BookingEntry> itr = bookingMap.get(classroomId).iterator();
		while (itr.hasNext()) {
			BookingEntry iterBooking = itr.next();
			if (date.equals(iterBooking.getStartTime())){
				return true;
			}
		}
		return false;
	}

	private void validateHours(int hours) {
		if (hours > 24 || hours < 1) {
			throw new BookingException("Can book only from 1 to 24 hours");
		}
	}

	private boolean current(BookingEntry be) {
		Date now = new Date();
		if (be.getStartTime().before(now) && be.getEndTime().after(now)) {
			return true;
		}
		return false;
	}

	private boolean future(BookingEntry be) {
		if (be.getStartTime().after(new Date())) {
			return true;
		}
		return false;
	}

	public void removeOldBookings() {
		Date dateNow = DateUtilsExt.truncate(new Date());
		bookingMap.keySet().forEach(classroomId -> {
			Set<BookingEntry> set = bookingMap.get(classroomId);
			Iterator<BookingEntry> itr = set.iterator();
			while (itr.hasNext()) {
				BookingEntry itrBooking = itr.next();
				if (itrBooking.getEndTime().before(dateNow)) {
					itr.remove();
				}
			}
		});
	}

	public void validateDate(Date date) {
		if (!DateUtilsExt.isStartOfHour(date)) {
			throw new BookingException("Given invalid date, only start an hour is acceptable");
		}
	}

}
