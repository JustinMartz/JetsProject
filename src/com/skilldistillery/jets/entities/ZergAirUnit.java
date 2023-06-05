package com.skilldistillery.jets.entities;

public class ZergAirUnit extends StarCraft implements TissueRegeneration {

	public ZergAirUnit() {

	}

	public ZergAirUnit(String model, double speed, int range, double price) {
		super(model, speed, range, price);
	}

	public void fly() {
		System.out.println("Flying Zerg Air Unit: " + this.getModel());
		System.out.println(this);
		System.out.println(this.getModel() + " has " + (this.getRange() / this.getSpeed())
				+ " space hours until running out of fuel.");
		System.out.println();
	}

	public void heal() {
		System.out.println("Tissue regeneration underway for " + this.getModel() + ".");
	}

}
