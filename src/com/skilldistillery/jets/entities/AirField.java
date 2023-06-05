package com.skilldistillery.jets.entities;

import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<StarCraft> fleet = new ArrayList<>();

	public AirField() {

	}

	public void addToFleet(StarCraft newUnit) {
		System.out.println();
		if (newUnit instanceof ZergAirUnit) {
			System.out.println("Adding new Zerg air unit to fleet.");
		}
		if (newUnit instanceof TerranAirUnit) {
			System.out.println("Adding new Terran air unit to fleet.");
		}
		if (newUnit instanceof ProtossAirUnit) {
			System.out.println("Adding new Protoss air unit to fleet.");
		}
		if (newUnit instanceof StarCraftImpl) {
			System.out.println("Adding new generic StarCraft air unit to fleet.");
		}
		fleet.add(newUnit);
		System.out.println(newUnit);
	}

	public void addToFleet(List<StarCraft> list) {
		for (int index = 0; index < list.size(); index++) {
			fleet.add(list.get(index));
		}
	}

	public int listFleet() {
		String type;
		String model;
		double speed;
		int range;
		double price;
		StarCraft tempObj;

		System.out.println();
		for (int index = 0; index < fleet.size(); index++) {
			tempObj = fleet.get(index);
			type = tempObj.getClass().getSimpleName();
			model = tempObj.getModel();
			speed = tempObj.getSpeed();
			range = tempObj.getRange();
			price = tempObj.getPrice();
			System.out.println("[" + (fleet.indexOf(tempObj) + 1) + "] Type: " + type + ", Model: " + model
					+ ", Speed: " + speed + " MPH, Range: " + range + " space miles, Price: " + price + " minerals");
		}

		return fleet.size();
	}

	public void flyAll() {
		for (StarCraft unit : fleet) {
			unit.fly();
		}
	}

	public void viewFastest() {
		double[] speedArray = new double[fleet.size()];
		StarCraft tempObj;
		double fastest = 0;
		int fastestUnitIndex = 0;

		for (int index = 0; index < fleet.size(); index++) {
			tempObj = fleet.get(index);
			speedArray[index] = tempObj.getSpeed();
		}

		for (int index = 0; index < speedArray.length; index++) {
			if (speedArray[index] > fastest) {
				fastest = speedArray[index];
				fastestUnitIndex = index;
			}
		}

		System.out.println("Fastest StarCraft air unit is " + fleet.get(fastestUnitIndex).getModel()
				+ " with a speed of " + fastest + " MPH.");

	}

	public void viewLongestRange() {
		int[] rangeArray = new int[fleet.size()];
		StarCraft tempObj;
		int longest = 0;
		int longestUnitIndex = 0;
		for (int index = 0; index < fleet.size(); index++) {
			tempObj = fleet.get(index);
			rangeArray[index] = tempObj.getRange();
		}

		for (int index = 0; index < rangeArray.length; index++) {
			if (rangeArray[index] > longest) {
				longest = rangeArray[index];
				longestUnitIndex = index;
			}
		}

		System.out.println("StarCraft air unit with longest range is " + fleet.get(longestUnitIndex).getModel()
				+ " with a range of " + longest);
	}

	public void healAllZerg() {
		int unitCount = 0;
		for (StarCraft unit : fleet) {
			if (unit instanceof ZergAirUnit) {
				((ZergAirUnit) unit).heal();
				unitCount++;
			}
		}
		if (unitCount == 0) {
			System.out.println("No Zerg air units in fleet.");
		}
	}

	public void firePowerfulWeapons() {
		int unitCount = 0;
		for (StarCraft unit : fleet) {
			if (unit instanceof TerranAirUnit) {
				((TerranAirUnit) unit).fireWeapons();
				unitCount++;
			}
		}
		if (unitCount == 0) {
			System.out.println("No Terran air units in fleet.");
		}
	}

	public void teleportProtoss() {
		int unitCount = 0;
		for (StarCraft unit : fleet) {
			if (unit instanceof ProtossAirUnit) {
				((ProtossAirUnit) unit).teleport();
				unitCount++;
			}
		}
		if (unitCount == 0) {
			System.out.println("No Protoss air units in fleet.");
		}
	}

	public boolean removeFromFleet(int index) {
		if (index > fleet.size()) {
			System.out.println("No StarCraft unit at postion " + index);
			return false;
		} else if (index <= 0) {
			System.out.println("No StarCraft unit at position " + index);
			return false;
		} else {
			System.out.println("Removing " + fleet.get(index - 1));
			fleet.remove(index - 1);
			return true;
		}

	}

	public boolean removeFromFleet(String name) {
		for (int index = 0; index < fleet.size(); index++) {
			if (fleet.get(index).getModel().toLowerCase().equals(name.toLowerCase())) {
				System.out.println("Removing " + fleet.get(index));
				fleet.remove(index);
				return true;
			}
		}
		System.out.println("!!! Invalid model name.");
		return false;
	}

	@Override
	public String toString() {
		return "AirField [fleet=" + fleet + "]";
	}

}
