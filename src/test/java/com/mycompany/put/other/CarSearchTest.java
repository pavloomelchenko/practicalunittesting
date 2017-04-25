package com.mycompany.put.other;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

public class CarSearchTest {

	private CarSearch sut = new CarSearch();
	private List<Car> carList = new ArrayList<Car>();

	private Car nonSportCar() {
		Engine engine = mock(Engine.class);
		Color color = Color.WHITE;
		Manufacturer manufacturer = mock(Manufacturer.class);
		when(engine.getNbOfCylinders()).thenReturn(8);
		when(manufacturer.getName()).thenReturn("Ferrari");

		return new CarImpl(engine, color, manufacturer);
	}

	private Car sportCar() {
		Engine engine = mock(Engine.class);
		Color color = Color.RED;
		Manufacturer manufacturer = mock(Manufacturer.class);
		when(engine.getNbOfCylinders()).thenReturn(8);
		when(manufacturer.getName()).thenReturn("Ferrari");

		Car car = new CarImpl(engine, color, manufacturer);
		return car;
	}

	@Test
	public void searchShouldReturnSportCarWhenOneAdded() {
		Car sportCar = sportCar();
		sut.addCar(sportCar);
		assertEquals(sportCar, sut.findSportCars().get(0));
	}

	@Test
	public void searchShouldReturnZeroSportCarsWhenNoCarsAdded() {
		assertTrue(CollectionUtils.isEqualCollection(carList, sut.findSportCars()));
	}

	@Test
	public void searchShouldReturnZeroSportCarsWhenOnlyNonSportCarsAdded() {
		Car c = nonSportCar();
		sut.addCar(c);
		assertTrue(CollectionUtils.isEqualCollection(carList, sut.findSportCars()));
	}

}
