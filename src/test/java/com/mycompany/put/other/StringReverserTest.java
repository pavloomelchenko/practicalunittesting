package com.mycompany.put.other;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.mycompany.put.other.StringReverser;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class StringReverserTest {

	@Test
	@Parameters(method = "validParams")
	public void stringReverserShouldWorkFineWhenParamsIsValid(String expected, String inputSt) {
		assertEquals(expected, StringReverser.reverse(inputSt));
	}

	private Object validParams() {
		return new Object[] { new Object[] { "fdsa", "asdf" }, new Object[] { "", "" } };
	}

	@Test(expected = NullPointerException.class)
	public void stringReverserShouldThrowNPEWhenInputIsNull() {
		StringReverser.reverse(null);
	}
}
