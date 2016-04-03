package com.mycompany.put.other;

import java.util.Calendar;

public class HelpDesk {
	public final static int EOB_HOUR = 17;
	TimeProvider provider;
	
	public HelpDesk(TimeProvider provider) {
		super();
		this.provider = provider;
	
	}
	
	public boolean willHandleIssue(Issue issue) {
		Calendar cal = provider.getTime();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (Calendar.SUNDAY == dayOfWeek || Calendar.SATURDAY == dayOfWeek) {
			return false;
		}
		if (Calendar.FRIDAY == dayOfWeek) {
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			if (hour > EOB_HOUR) {
				return false;
			}
		}
		return true;
	}
}