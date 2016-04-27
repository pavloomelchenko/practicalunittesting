package com.mycompany.put.other;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFixtureTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("before Class");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("after Class");
	}

	@Before
	public void before() {
		System.out.println("before");
	}

	@After
	public void after() {
		System.out.println("after");
	}

	@Test
	public void testMethodA() {
		System.out.println("method A");
	}

	@Test
	public void testMethodB() {
		System.out.println("method B");
	}
}