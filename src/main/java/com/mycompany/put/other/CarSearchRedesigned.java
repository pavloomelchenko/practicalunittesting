package com.mycompany.put.other;

import java.util.ArrayList;
import java.util.List;

public class CarSearchRedesigned {
	private List<Car> cars = new ArrayList<Car>();

	public void addCar(Car car) {
		cars.add(car);
	}

	public List<Car> findSportCars() {
		List<Car> sportCars = new ArrayList<Car>();
		for (Car car : cars) {
			if (car.isSportCar())
				sportCars.add(car);
		}
		return sportCars;
	}
}