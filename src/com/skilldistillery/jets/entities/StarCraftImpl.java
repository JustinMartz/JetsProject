package com.skilldistillery.jets.entities;

public class StarCraftImpl extends StarCraft {

	public StarCraftImpl() {

	}

	public StarCraftImpl(String model, double speed, int range, double price) {
		super(model, speed, range, price);
	}

	public void fly() {
		System.out.println("Flying generic implementation [" + this.getModel() + "] of a StarCraft unit. Weee.");
		System.out.println(this);
		System.out.println(this.getModel() + " has " + (this.getRange() / this.getSpeed())
				+ " space hours until running out of fuel.");
		System.out.println();
	}
}
