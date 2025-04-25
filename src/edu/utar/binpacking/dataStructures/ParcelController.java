package edu.utar.binpacking.dataStructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;

public class ParcelController {
    private static Queue<Parcel> allParcels = null; // Singleton pattern
    
    public static double getLargestWeight() {
        double largest = 0.0;
        Iterator<Parcel> iterator = allParcels.iterator();
        while (iterator.hasNext()) {
            Parcel parcel = iterator.next();
            if (Double.compare(parcel.getWeight(), largest) >= 0) {
                largest = parcel.getWeight();
            }
        }
        return largest;
    }
    
    // return allParcels queue if exists, singleton pattern
    public static Queue<Parcel> getAllParcels(){
        // Check if no parcel inside the queue
        if (allParcels == null) {
            // If null create new queue
            allParcels = new ArrayDeque<Parcel>();
            loadFromCSV();
        }
        
        // return existing or newly created queue
        return allParcels;
    }
    
    // To retrieve data from .csv file
    public static void loadFromCSV() {
        try {
            File file = new File("src/parcels.csv");
            Scanner scanner = new Scanner(file);
            boolean firstLine = true;
            
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                if(firstLine) {
                    firstLine = false;
                    continue;
                }
                
                String[] values = line.split(",");
                
                if(values.length == 3) {    // To ensure both name and weight are recorded
                    String name = values[0].trim();
                    double weight = Double.parseDouble(values[1].trim());
                    String type = values[2].trim();
                    
                    // add new parcel to the queue
                    allParcels.offer(new Parcel(name, weight, type));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
    
    // Display all parcels
    public static void displayAllParcels() {
        System.out.println("=== Parcel List ===");
        Iterator<Parcel> iterator = allParcels.iterator();
        while (iterator.hasNext()) {
            Parcel parcel = iterator.next();
            System.out.println("Parcel Name: " + parcel.getName() + ", Weight: " + parcel.getWeight() + " kg, "
                    + "Type: " + parcel.getType());
        }
    }
    
    public static void main(String[] args) {
        getAllParcels();
        displayAllParcels();
        System.out.println(allParcels.size());
    }
}
