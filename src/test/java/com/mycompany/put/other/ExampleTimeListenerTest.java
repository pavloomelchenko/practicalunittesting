package com.mycompany.put.other;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

public class ExampleTimeListenerTest {

	@ClassRule
	public static TimeSuiteListener timeListenerAll = new TimeSuiteListener();

	@Rule
	public TimeTestListener timeListenerTest = new TimeTestListener();

	@Test
	public void tenMillis() throws InterruptedException {
		Thread.sleep(10);
	}

	@Test
	public void twentyMillis() throws InterruptedException {
		Thread.sleep(20);
	}

	@Test
	public void failAfterTenMillis() throws InterruptedException {
		Thread.sleep(10);
		// fail(); //commented this to pass all tests, but this line is to test
		// listener result line string in case of failure
	}
}