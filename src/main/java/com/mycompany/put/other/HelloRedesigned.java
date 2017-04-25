package com.mycompany.put.other;

public class HelloRedesigned {
	private TimeProvider timeProvider;

	public HelloRedesigned(TimeProvider timeProvider) {
		this.timeProvider = timeProvider;
	}

	public String sayHello() {
		if (timeProvider.isItMorning()) {
			return "Good Morning!";
		} else {
			return "Good Afternoon!";
		}
	}
}