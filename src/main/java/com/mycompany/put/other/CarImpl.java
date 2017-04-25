package com.mycompany.put.other;

public class CarImpl implements Car {
	private Engine engine;
	private Color color;
	private Manufacturer manufacturer;

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
		return "CarImpl [engine=" + engine + ", color=" + color + ", manufacturer=" + manufacturer
				+ "]";
	}

	@Override
	public boolean isSportCar() {
		if (getEngine().getNbOfCylinders() > 6 && Color.RED == getColor()
				&& "Ferrari".equals(getManufacturer().getName())) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((engine == null) ? 0 : engine.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarImpl other = (CarImpl) obj;
		if (color != other.color)
			return false;
		if (engine == null) {
			if (other.engine != null)
				return false;
		} else if (!engine.equals(other.engine))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		return true;
	}

}
