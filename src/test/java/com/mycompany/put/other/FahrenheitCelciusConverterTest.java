package com.mycompany.put.other;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.mycompany.put.other.FahrenheitCelciusConverter;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class FahrenheitCelciusConverterTest {
	@Test
	@Parameters(method = "validParams")
	public void shouldConvertCelciusToFahrenheit(int c, int f) {
		assertEquals(f, FahrenheitCelciusConverter.toFahrenheit(c));
	}

	@Test
	@Parameters(method = "validParams")
	public void shouldConvertFahrenheitToCelcius(int c, int f) {
		assertEquals(c, FahrenheitCelciusConverter.toCelcius(f));
	}
	
	private Object validParams() {
		return new Object[] { new Object[] { 0,32 }, new Object[] { 35,95 }, new Object[] { 100,212 } };
	}
}