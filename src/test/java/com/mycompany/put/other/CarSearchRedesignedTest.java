package com.mycompany.put.other;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

public class CarSearchRedesignedTest {
	private CarSearchRedesigned sut = new CarSearchRedesigned();
	private List<Car> carList = new ArrayList<Car>();

	private Car nonSportCar() {
		Car car = mock(Car.class);
		when(car.isSportCar()).thenReturn(false);
		return car;
	}

	private Car sportCar() {
		Car car = mock(Car.class);
		when(car.isSportCar()).thenReturn(true);
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
