package com.skilldistillery.jets.entities;

public class ProtossAirUnit extends StarCraft implements Teleportation {

	public ProtossAirUnit() {

	}

	public ProtossAirUnit(String model, double speed, int range, double price) {
		super(model, speed, range, price);
	}

	public void fly() {
		System.out.println("Flying Protoss Air Unit: " + this.getModel());
		System.out.println(this);
		System.out.println(this.getModel() + " has " + (this.getRange() / this.getSpeed())
				+ " space hours until running out of fuel.");
		System.out.println();
	}

	public void teleport() {
		System.out.println("Our enemies are legion! Teleporting " + this.getModel() + " away from here.");
	}
}
