package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.ProtossAirUnit;
import com.skilldistillery.jets.entities.StarCraft;
import com.skilldistillery.jets.entities.StarCraftImpl;
import com.skilldistillery.jets.entities.TerranAirUnit;
import com.skilldistillery.jets.entities.ZergAirUnit;

public class StarCraftApp {
	private final String filename = "starcraft.txt";

	public static void main(String[] args) {
		StarCraftApp myApp = new StarCraftApp();
		myApp.run();
	}

	public void run() {
		boolean isRunning = true;
		Scanner userInput = new Scanner(System.in);
		int choice = 0;
		AirField myAirField = new AirField();

		populateAirField(myAirField);

		while (isRunning) {
			printMenu();
			try {
				choice = userInput.nextInt();
			} catch (InputMismatchException e) {
				userInput.nextLine();
				System.out.println("!!! Please enter a number!");
				continue;
			}

			switch (choice) {
			case 1:
				System.out.println();
				System.out.println("Listing fleet...");
				myAirField.listFleet();
				break;
			case 2:
				myAirField.flyAll();
				break;
			case 3:
				myAirField.viewFastest();
				break;
			case 4:
				myAirField.viewLongestRange();
				break;
			case 5:
				myAirField.healAllZerg();
				break;
			case 6:
				myAirField.firePowerfulWeapons();
				break;
			case 7:
				myAirField.teleportProtoss();
				break;
			case 8:
				userInput.nextLine();
				createUnit(userInput, myAirField);
				break;
			case 9:
				removeUnit(userInput, myAirField);
				break;
			case 10:
				isRunning = false;
				System.out.println("Program exiting.");
				userInput.close();
				myAirField = null;
				break;
			default:
				System.out.println("!!! Invalid menu option.");
				break;
			}
		}

	}

	private List<StarCraft> parseFileIntoStarCraftUnits(String filename) {
		List<StarCraft> listOfStarCraftUnits = new ArrayList<>();

		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				listOfStarCraftUnits.add(buildStarCraftObject(line));
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
			return null;
		} catch (IOException e) {
			System.err.println("Problem while reading " + filename + ": " + e.getMessage());
			return null;
		}

		return listOfStarCraftUnits;
	}

	private void populateAirField(AirField newAirField) {
		newAirField.addToFleet(parseFileIntoStarCraftUnits(filename));
	}

	private StarCraft buildStarCraftObject(String string) {
		String[] splitElements = new String[5];
		String model;
		double speed;
		int range;
		double price;

		if (string.startsWith("TerranAirUnit")) {
			// split first line into regular array
			splitElements = string.split(",");
			// put those array elements into variable (except 0 element)
			// TODO try/catch each assignment from wrapper class
			// TODO put into separate method
			model = splitElements[1];
			speed = Double.parseDouble(splitElements[2]);
			range = Integer.parseInt(splitElements[3]);
			price = Double.parseDouble(splitElements[4]);
			// instantiate appropriate subclass and stick it into listOfStarCraftUnits
			StarCraft newTerran = new TerranAirUnit(model, speed, range, price);
			return newTerran;
		} else if (string.startsWith("ZergAirUnit")) {
			// split first line into regular array
			splitElements = string.split(",");
			// put those array elements into variable (except 0 element)
			// TODO try/catch each assignment from wrapper class
			// TODO put into separate method
			model = splitElements[1];
			speed = Double.parseDouble(splitElements[2]);
			range = Integer.parseInt(splitElements[3]);
			price = Double.parseDouble(splitElements[4]);
			// instantiate appropriate subclass and stick it into listOfStarCraftUnits
			StarCraft newZerg = new ZergAirUnit(model, speed, range, price);
			return newZerg;
		} else if (string.startsWith("ProtossAirUnit")) {
			// split first line into regular array
			splitElements = string.split(",");
			// put those array elements into variable (except 0 element)
			// TODO try/catch each assignment from wrapper class
			// TODO put into separate method
			model = splitElements[1];
			speed = Double.parseDouble(splitElements[2]);
			range = Integer.parseInt(splitElements[3]);
			price = Double.parseDouble(splitElements[4]);
			// instantiate appropriate subclass and stick it into listOfStarCraftUnits
			StarCraft newProtoss = new ProtossAirUnit(model, speed, range, price);
			return newProtoss;
		} else if (string.startsWith("StarCraftImpl")) {
			splitElements = string.split(",");
			model = splitElements[1];
			speed = Double.parseDouble(splitElements[2]);
			range = Integer.parseInt(splitElements[3]);
			price = Double.parseDouble(splitElements[4]);
			StarCraft newBasicUnit = new StarCraftImpl(model, speed, range, price);
			return newBasicUnit;
		} else {
			return null;
		}
	}

	private void printMenu() {
		System.out.println();
		System.out.println("Please enter a number from the menu.");
		System.out.println("***");
		System.out.println("[1]  List fleet");
		System.out.println("[2]  Fly all StarCraft air units");
		System.out.println("[3]  View fastest StarCraft air unit");
		System.out.println("[4]  View StarCraft air unit with longest range");
		System.out.println("[5]  Heal all Zerg air units");
		System.out.println("[6]  Fire powerful weapons from all Terran air units");
		System.out.println("[7]  Teleport all Protoss air units");
		System.out.println("[8]  Add a StarCraft unit to fleet");
		System.out.println("[9]  Remove a StarCraft unit from fleet");
		System.out.println("[10] Quit");
		System.out.println("");
		System.out.print("Enter choice: ");

	}

	private void createUnit(Scanner userInput, AirField thisAirField) {
		int choice = 0;
		String name;
		double speed;
		int range;
		double price;
		boolean isRunning = true;
		StarCraft tempObj;

		while (isRunning) {
			System.out.println("Please enter a number from the menu.");
			System.out.println("------------------------------------");
			System.out.println("[1] Add new Zerg air unit to fleet");
			System.out.println("[2] Add new Terran air unit to fleet");
			System.out.println("[3] Add new Protoss air unit");
			System.out.println("[4] Add new generic StarCraft unit to fleet");
			System.out.println();
			System.out.println("Enter choice: ");
			try {
				choice = userInput.nextInt();
			} catch (InputMismatchException e) {
				userInput.nextLine();
				System.out.println("!!! Please enter a number!");
			}

			userInput.nextLine();
			switch (choice) {
			case 1:
				System.out.println();
				System.out.print("Enter name of unit: ");
				name = userInput.nextLine();

				System.out.print("Enter speed of " + name + ": ");
				if (userInput.hasNextDouble()) {
					speed = userInput.nextDouble();
				} else {
					System.out.println("!!! Invalid entry. Starting over.");
					System.out.println();
					continue;
				}

				System.out.print("Enter range of " + name + ": ");
				if (userInput.hasNextInt()) {
					range = userInput.nextInt();
				} else {
					System.out.println("!!! Invalid entry. Starting over.");
					System.out.println();
					continue;
				}

				System.out.print("Enter price of " + name + ": ");
				if (userInput.hasNextDouble()) {
					price = userInput.nextDouble();
				} else {
					System.out.println("!!! Invalid entry. Starting over.");
					System.out.println();
					continue;
				}

				tempObj = new ZergAirUnit(name, speed, range, price);
				thisAirField.addToFleet(tempObj);
				tempObj = null;
				isRunning = false;
				break;
			case 2:
				System.out.println();
				System.out.print("Enter name of unit: ");
				name = userInput.nextLine();

				System.out.print("Enter speed of " + name + ": ");
				if (userInput.hasNextDouble()) {
					speed = userInput.nextDouble();
				} else {
					System.out.println("!!! Invalid entry. Starting over.");
					System.out.println();
					continue;
				}

				System.out.print("Enter range of " + name + ": ");
				if (userInput.hasNextInt()) {
					range = userInput.nextInt();
				} else {
					System.out.println("!!! Invalid entry. Starting over.");
					System.out.println();
					continue;
				}

				System.out.print("Enter price of " + name + ": ");
				if (userInput.hasNextDouble()) {
					price = userInput.nextDouble();
				} else {
					System.out.println("!!! Invalid entry. Starting over.");
					System.out.println();
					continue;
				}

				tempObj = new TerranAirUnit(name, speed, range, price);
				thisAirField.addToFleet(tempObj);
				tempObj = null;
				isRunning = false;
				break;
			case 3:
				System.out.println();
				System.out.print("Enter name of unit: ");
				name = userInput.nextLine();

				System.out.print("Enter speed of " + name + ": ");
				if (userInput.hasNextDouble()) {
					speed = userInput.nextDouble();
				} else {
					System.out.println("!!! Invalid entry. Starting over.");
					System.out.println();
					continue;
				}

				System.out.print("Enter range of " + name + ": ");
				if (userInput.hasNextInt()) {
					range = userInput.nextInt();
				} else {
					System.out.println("!!! Invalid entry. Starting over.");
					System.out.println();
					continue;
				}

				System.out.print("Enter price of " + name + ": ");
				if (userInput.hasNextDouble()) {
					price = userInput.nextDouble();
				} else {
					System.out.println("!!! Invalid entry. Starting over.");
					System.out.println();
					continue;
				}

				tempObj = new ProtossAirUnit(name, speed, range, price);
				thisAirField.addToFleet(tempObj);
				tempObj = null;
				isRunning = false;
				break;
			case 4:
				System.out.println();
				System.out.print("Enter name of unit: ");
				name = userInput.nextLine();

				System.out.print("Enter speed of " + name + ": ");
				if (userInput.hasNextDouble()) {
					speed = userInput.nextDouble();
				} else {
					System.out.println("!!! Invalid entry. Starting over.");
					System.out.println();
					continue;
				}

				System.out.print("Enter range of " + name + ": ");
				if (userInput.hasNextInt()) {
					range = userInput.nextInt();
				} else {
					System.out.println("!!! Invalid entry. Starting over.");
					System.out.println();
					continue;
				}

				System.out.print("Enter price of " + name + ": ");
				if (userInput.hasNextDouble()) {
					price = userInput.nextDouble();
				} else {
					System.out.println("!!! Invalid entry. Starting over.");
					System.out.println();
					continue;
				}

				tempObj = new StarCraftImpl(name, speed, range, price);
				thisAirField.addToFleet(tempObj);
				tempObj = null;
				isRunning = false;
				break;
			default:
				System.out.println("!!! Invalid menu option.");
				break;
			}

		}
	}

	public void removeUnit(Scanner userInput, AirField thisAirField) {
		userInput.nextLine();
		boolean isRunning = true;
		int choice = 0;
		String input;

		while (isRunning) {
			System.out.println();
			System.out.println("Please enter model name or number of unit to remove from fleet.");
			System.out.println("***************************************************************");
			if (thisAirField.listFleet() == 0) {
				System.out.println("!!! Fleet is empty! No units to remove.");
				break;
			}
			System.out.println();
			System.out.print("Enter choice: ");
			input = userInput.nextLine();
			try {
				choice = Integer.parseInt(input);
				thisAirField.removeFromFleet(choice);
				isRunning = false;
			} catch (NumberFormatException e) {
				if (!thisAirField.removeFromFleet(input)) {
					continue;
				} else {
					isRunning = false;
				}
			}
		}
	}

}
