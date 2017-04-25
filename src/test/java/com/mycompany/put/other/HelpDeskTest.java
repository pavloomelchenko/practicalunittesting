package com.mycompany.put.other;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class HelpDeskTest {
	private TimeProvider provider = mock(TimeProvider.class);
	private HelpDesk helpDesk = new HelpDesk(provider);
	private Issue issue = mock(Issue.class);
	private int SAMPLE_WORKING_HOUR = 10;

	private static final Object[] weekends() {
		return new Object[] { Calendar.SATURDAY, Calendar.SUNDAY };
	}

	private static final Object[] workdays() {
		return new Object[] { Calendar.MONDAY, Calendar.TUESDAY, Calendar.FRIDAY };
	}

	private static final Object[] fridayWorkingHours() {
		return new Object[] { 9, 10, 11, 12, 13, 14, 15, 16, 17 };
	}

	@Test
	@Parameters(method = "weekends")
	public void shouldNotHandleIssueInWeekends(int dayOfWeek) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
		doReturn(cal).when(provider).getTime();
		assertFalse(helpDesk.willHandleIssue(issue));
	}

	@Test
	public void shouldNotHandleIssueAfterEOBHourInFriday() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		cal.set(Calendar.HOUR_OF_DAY, 18);
		doReturn(cal).when(provider).getTime();
		assertFalse(helpDesk.willHandleIssue(issue));
	}

	@Test
	@Parameters(method = "fridayWorkingHours")
	public void shouldHandleIssueBeforeEOBHourInFriday(int workingHour) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		cal.set(Calendar.HOUR_OF_DAY, workingHour);
		doReturn(cal).when(provider).getTime();
		assertTrue(helpDesk.willHandleIssue(issue));
	}

	@Test
	@Parameters(method = "workdays")
	public void shouldHandleIssueInWorkDay(int dayOfWeek) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
		cal.set(Calendar.HOUR_OF_DAY, SAMPLE_WORKING_HOUR);
		doReturn(cal).when(provider).getTime();
		assertTrue(helpDesk.willHandleIssue(issue));
	}
}
