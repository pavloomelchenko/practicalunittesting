package com.mycompany.put.bookingrevisited;

import java.util.Calendar;
import java.util.Date;

public class DateUtilsExt {
	public static Date truncate(Date date) {
		Calendar cal = Calendar.getInstance(); // locale-specific
		cal.setTime(date);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static boolean isStartOfHour(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if (cal.get(Calendar.MINUTE) == 0 && cal.get(Calendar.SECOND) == 0
				&& cal.get(Calendar.MILLISECOND) == 0)
			return true;
		return false;
	}
}
