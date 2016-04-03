package com.mycompany.put.other;

import java.util.Calendar;

public interface TimeProvider {
	Calendar getTime();
	boolean isItMorning();
}
