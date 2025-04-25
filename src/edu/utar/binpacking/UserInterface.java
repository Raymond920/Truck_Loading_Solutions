package edu.utar.binpacking;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import edu.utar.binpacking.algorithms.*;
import edu.utar.binpacking.dataStructures.*;

import java.util.ArrayList;

public class UserInterface {
    private BinPackingAlgorithm algorithm;
    private double truckLoadLimit;
    private Scanner scanner;
    
    public UserInterface() {
        scanner = new Scanner(System.in);
    }
    
    public void selectAlgorithm(BinPackingAlgorithm algorithm) {
        this.algorithm = algorithm;
    }
    
    public void displayResults(List<Truck> trucks) {
        System.out.println("Total trucks needed: " + trucks.size());
        double allParcelWeight = 0.0;
        // display parcels in each truck
        for(int i = 0; i < trucks.size(); i++) {
            System.out.println("=============================================");
            System.out.println("Truck No." + (i+1));
            System.out.println("=============================================");
            double totalWeight = 0.0;
            for(int j = 0; j < trucks.get(i).getItems().size(); j++) {
                System.out.println(trucks.get(i).getItems().get(j).getName());
                allParcelWeight += trucks.get(i).getItems().get(j).getWeight();
                totalWeight += trucks.get(i).getItems().get(j).getWeight();
            }
            System.out.println("=============================================");
            System.out.println("Total Weight of Truck No." + (i+1) + ": " + totalWeight);
            System.out.println("=============================================");
        }
        System.out.println("=============================================");
        System.out.println("Total parcels weight: " + allParcelWeight);
    }
    
    public void start() {
        System.out.println("=== Bin Packing System ===");

        // Get user choice for algorithm
        System.out.println("Select Packing Algorithm:");
        System.out.println("1. First Fit");
        System.out.println("2. Best Fit");
        int choice = scanner.nextInt();

        // Initialize selected algorithm
        switch (choice) {
            case 1:
                algorithm = new FirstFitAlgorithm();
                break;
            case 2:
                algorithm = new BestFitAlgorithm();
                break;
            default:
                System.out.println("Invalid choice! Defaulting to First Fit.");
                algorithm = new FirstFitAlgorithm();
        }
        
        Queue<Parcel> parcels = ParcelController.getAllParcels();

        if (parcels.isEmpty()) {
            System.out.println("No parcels loaded. Loading from CSV...");
        }
        
        System.out.print("Enter truck load limit: ");
        truckLoadLimit = scanner.nextDouble();
        
        while (truckLoadLimit < ParcelController.getLargestWeight()) {
            System.out.println("The minimum load limit must larger than " + ParcelController.getLargestWeight());
            System.out.print("Enter truck load limit: ");
            truckLoadLimit = scanner.nextDouble();
        }
        
        
        List<Truck> resultList = algorithm.pack(parcels, truckLoadLimit);
        displayResults(resultList);
    }
    
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.start();
    }
}
