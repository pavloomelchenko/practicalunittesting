package com.mycompany.put.other;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class CarImplTest {

	private CarImpl sportCar() {
		Engine engine = mock(Engine.class);
		Color color = Color.RED;
		Manufacturer manufacturer = mock(Manufacturer.class);
		when(engine.getNbOfCylinders()).thenReturn(8);
		when(manufacturer.getName()).thenReturn("Ferrari");
		return new CarImpl(engine, color, manufacturer);
	}

	@Test
	public void shouldBeSportWhenManufacturerIsFerrariAndHasMoreThanSixCylindersAndColorIsRed() {
		assertTrue(sportCar().isSportCar());
	}

	@Test
	public void shouldNotBeSportWhenManufacturerIsNotFerrari() {
		CarImpl car = sportCar();
		Manufacturer manufacturer = mock(Manufacturer.class);
		when(manufacturer.getName()).thenReturn("Audi");
		car.setManufacturer(manufacturer);
		assertFalse(car.isSportCar());
	}

	@Test
	public void shouldNotBeSportWhenHasLessOrEqualSixCylinders() {
		CarImpl car = sportCar();
		Engine engine = mock(Engine.class);
		when(engine.getNbOfCylinders()).thenReturn(6);
		car.setEngine(engine);
		assertFalse(car.isSportCar());
	}

	@Test
	public void shouldNotBeSportWhenColorIsNotRed() {
		CarImpl car = sportCar();
		car.setColor(Color.WHITE);
		assertFalse(car.isSportCar());
	}
}
