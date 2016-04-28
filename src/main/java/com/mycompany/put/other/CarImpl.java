package com.mycompany.put.other;

public class CarImpl implements Car {
	Engine engine;
	Color color;
	Manufacturer manufacturer;

	public CarImpl(Engine engine, Color color, Manufacturer manufacturer) {
		super();
		this.engine = engine;
		this.color = color;
		this.manufacturer = manufacturer;
	}

	@Override
	public Engine getEngine() {
		return engine;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "CarImpl [engine=" + engine + ", color=" + color + ", manufacturer=" + manufacturer + "]";
	}

	@Override
	public boolean isSportCar() {
		if (getEngine().getNbOfCylinders() > 6 && Color.RED == getColor()
				&& "Ferrari".equals(getManufacturer().getName())) {
			return true;
		}
		return false;
	}

}
