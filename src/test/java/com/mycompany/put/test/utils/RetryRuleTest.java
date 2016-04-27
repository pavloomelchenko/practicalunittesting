package com.mycompany.put.test.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

public class RetryRuleTest {
	@Rule
	public RetryTestRule retryTestRule = new RetryTestRule();
	static int executionNumber = 0;

	@Test
	
	public void shouldBeRerun() {
		executionNumber++;
		System.out.println("execution: " + executionNumber);
		assertEquals(2, executionNumber);
	}
}