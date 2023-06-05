package com.skilldistillery.jets.entities;

public class TerranAirUnit extends StarCraft implements PowerfulWeapons {

	public TerranAirUnit() {

	}

	public TerranAirUnit(String model, double speed, int range, double price) {
		super(model, speed, range, price);
	}

	public void fly() {
		System.out.println("Flying Terran Air Unit: " + this.getModel());
		System.out.println(this);
		System.out.println(this.getModel() + " has " + (this.getRange() / this.getSpeed())
				+ " space hours until running out of fuel.");
		System.out.println();
	}

	public void fireWeapons() {
		System.out.println("Firing powerful weapons from " + this.getModel() + ". Pew pew!");
	}
}
