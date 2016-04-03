package com.mycompany.put.other;

import java.util.Calendar;

public class TimeProviderImpl implements TimeProvider {

	@Override
	public Calendar getTime() {
		return Calendar.getInstance();
	}

	@Override
	public boolean isItMorning() {
		if (getTime().get(Calendar.HOUR_OF_DAY) < 12) {
			return true;
		}
		return false;
	}

}
