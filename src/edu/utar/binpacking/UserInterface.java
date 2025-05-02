package edu.utar.binpacking;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import edu.utar.binpacking.algorithms.*;
import edu.utar.binpacking.dataStructures.*;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class UserInterface {
	private Scanner scanner;

	public UserInterface() {
		scanner = new Scanner(System.in);
	}

	public void displayResults(List<Truck> trucks) {
		System.out.println("Total trucks needed: " + trucks.size());
		double allParcelWeight = 0.0;
		// display parcels in each truck
		for (int i = 0; i < trucks.size(); i++) {
			System.out.println("=============================================");
			System.out.println("Truck No." + (i + 1));
			System.out.println("=============================================");
			double totalWeight = 0.0;
			for (int j = 0; j < trucks.get(i).getItems().size(); j++) {
				System.out.println(trucks.get(i).getItems().get(j).getName());
				allParcelWeight += trucks.get(i).getItems().get(j).getWeight();
				totalWeight += trucks.get(i).getItems().get(j).getWeight();
			}
			System.out.println("=============================================");
			System.out.println("Total Weight of Truck No." + (i + 1) + ": " + totalWeight);
			System.out.println("=============================================");
		}
		System.out.println("=============================================");
		System.out.println("Total parcels weight: " + Math.round(allParcelWeight * 100.0) / 100.0);
	}

	public void start() {
		BinPackingAlgorithm algorithm;
		double truckLoadLimit=0;
		
		System.out.println("=== Bin Packing System ===");

		List<BinPackingAlgorithm> algorithms = new ArrayList<>();
		algorithms.add(new FirstFitAlgorithm());
		algorithms.add(new FirstFitDecreasingAlgorithm());
		algorithms.add(new BestFitAlgorithm());
		algorithms.add(new BestFitDecreasingAlgorithm());
		algorithms.add(new NextFitAlgorithm());

		Queue<Parcel> parcels = ParcelController.getAllParcels();

		if (parcels.isEmpty()) {
			System.out.println("No parcels loaded. Loading from CSV...");
		}

		boolean isValid = false;
		while(!isValid) {
			System.out.print("Enter truck load limit (kg): ");
			try {
				truckLoadLimit = scanner.nextDouble();
				isValid = true;
			}catch(InputMismatchException e) {
				System.out.println("Invalid input.");
				scanner.nextLine();
			}
		}

		while (truckLoadLimit < ParcelController.getLargestWeight()) {
			System.out.println("The minimum load limit must larger than " + ParcelController.getLargestWeight());
			System.out.print("Enter truck load limit: ");
			truckLoadLimit = scanner.nextDouble();
		}

		System.out.println("Comparison of Algorithms");
		System.out.println("=============================================\n");
		for (int i = 0; i < algorithms.size(); i++) {
			algorithm = algorithms.get(i);
			algorithm.Pack(parcels, truckLoadLimit);
			System.out.println("Algorithm: " + algorithm.getName());
			System.out.println("Execution Time (nano seconds): " + algorithm.getExecutionTime());
			System.out.println("Total trucks needed: " + algorithm.getTruckList().size());
			System.out.println("=============================================\n");
		}

		boolean exit = false;
		while (!exit) {
			// Display results for the selected algorithm
			System.out.println("\n=============================================");
			System.out.println("View truck list for the selected algorithm");
			System.out.println("=============================================");
			System.out.println("0. Exit");
			for (int i = 0; i < algorithms.size(); i++) {
				System.out.println((i + 1) + ". " + algorithms.get(i).getName());
			}
			int selectedAlgorithm = -1;
			isValid = false;
			while(!isValid) {
				System.out.print("Select Algorithm: ");
				try {
					selectedAlgorithm = scanner.nextInt();
					isValid = true;
				}catch(InputMismatchException e) {
					System.out.println("Invalid input.");
					scanner.nextLine();
				}
			}
			if (selectedAlgorithm != 0) {
				displayResults(algorithms.get(selectedAlgorithm - 1).getTruckList());
			} else {
				exit = true;
			}
		}
	}

	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		ui.start();
	}
}
