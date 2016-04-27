package com.mycompany.put.test.utils;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class EnhancedRetryTest {
	@Rule
	public RetryTestEnhancedRule retryTestRule = new RetryTestEnhancedRule();
	static int firstTestCounter = 0;
	static int secondTestCounter = 0;
	static int thirdTestCounter = 0;

	@RetryTest(retryNb = 2)
	@Test
	public void shouldFailOnSecondAttempt() {
		firstTestCounter++;
		assertEquals(2, firstTestCounter);
	}

	@Test
	@RetryTest(retryNb = 3)
	public void shouldFailOnThirdAttempt() {
		secondTestCounter++;
		assertEquals(3, secondTestCounter);
	}

	@Test
	public void shouldNotBeRerun() {
		thirdTestCounter++;
		assertEquals(1, thirdTestCounter);
	}
}