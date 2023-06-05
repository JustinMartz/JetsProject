package com.skilldistillery.jets.entities;

import java.util.Objects;

public abstract class StarCraft {

	private String model;
	private double speed;
	private int range;
	private double price;

	public StarCraft() {

	}

	public StarCraft(String model, double speed, int range, double price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public abstract void fly();

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, price, range, speed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StarCraft other = (StarCraft) obj;
		return Objects.equals(model, other.model)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Double.doubleToLongBits(range) == Double.doubleToLongBits(other.range) && speed == other.speed;
	}

	@Override
	public String toString() {
		return "StarCraft [model=" + model + ", speed=" + speed + ", range=" + range + ", price=" + price + "]";
	}

}
