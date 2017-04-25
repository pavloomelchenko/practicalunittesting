package com.mycompany.put.bookingrevisited;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.mycompany.put.raceresults.LogService;

public class BookingSystemRevisitedTest {
	private List<Classroom> existingClassrooms = new ArrayList<>();
	private BookingSystem bookingSystem;
	private Date sampleDate;
	private long classroomId = 1;
	private Classroom classroom = new Classroom(classroomId);
	private LogService log = mock(LogService.class);
	private int hoursAmount = 1;

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Before
	public void before() {
		existingClassrooms.add(classroom);
		bookingSystem = new BookingSystem(existingClassrooms, log);
		sampleDate = DateUtilsExt.truncate(new Date());
	}

	@Test
	public void shouldAllowListAllExistingClassrooms() {
		assertTrue(CollectionUtils.isEqualCollection(existingClassrooms,
				bookingSystem.existingClassroomList()));
	}

	@Test
	public void shouldAllowBookClassroom() {
		bookingSystem.book(sampleDate, classroomId, hoursAmount);
		assertTrue(bookingSystem.isBooked(sampleDate, classroomId));
	}

	@Test
	public void shouldNotAllowBookTwice() {
		expectedEx.expect(BookingException.class);
		expectedEx.expectMessage(
				"Date is booked or not enough range (before next booking) ");
		bookingSystem.book(sampleDate, classroomId, hoursAmount);
		bookingSystem.book(sampleDate, classroomId, hoursAmount);
	}

	@Test
	public void whenBookClassroomRemoveOldBookings() {
		Date outdatedDateNotTruncated = new Date();
		Date outdatedDate = DateUtilsExt.truncate(
				new Date(outdatedDateNotTruncated.getTime() - 3600000));
		bookingSystem.book(outdatedDate, classroomId, hoursAmount);
		bookingSystem.book(sampleDate, classroomId, hoursAmount);
		assertFalse(bookingSystem.isBooked(outdatedDate, classroomId));
	}

	@Test
	public void shouldAllowBookOnlyForStartOfHour() {
		expectedEx.expect(BookingException.class);
		expectedEx.expectMessage(
				"Given invalid date, only start an hour is acceptable");
		bookingSystem.book(new Date(), classroomId, hoursAmount);
	}

	@Test
	public void shouldAllowBookOnlyAvailClassrooms() {
		long notExistingClassroomId = -1;
		expectedEx.expect(BookingException.class);
		expectedEx.expectMessage("Invalid classroom");
		bookingSystem.book(sampleDate, notExistingClassroomId,
				hoursAmount);
	}

	@Test
	public void shouldAllowToBookSeparateClassroomsForSameDate() {
		existingClassrooms = new ArrayList<>();
		existingClassrooms.add(classroom);
		Classroom classroom2 = new Classroom(2);
		existingClassrooms.add(classroom2);
		bookingSystem = new BookingSystem(existingClassrooms, log);
		bookingSystem.book(sampleDate, classroomId, hoursAmount);
		bookingSystem.book(sampleDate, 2, hoursAmount);
		assertTrue(bookingSystem.isBooked(sampleDate, classroomId));
		assertTrue(bookingSystem.isBooked(sampleDate, classroomId));
	}

	@Test
	public void eachBookingOperationShouldBeWrittenToLogs() {
		bookingSystem.book(sampleDate, classroomId, hoursAmount);
		verify(log).log(
				"Booked " + sampleDate + " classroom" + classroomId);
	}

}
