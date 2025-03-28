package edu.utar.binpacking;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Parcel {
	private String name;
	private double weight;
	private String type;
	public static List<Parcel> allParcels;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Parcel(String name, double weight, String type) {
		this.name = name;
		this.weight = weight;
		this.type = type;
	}
	
	public static double getLargestWeight() {
		double largest = 0.0;
		for(int i = 0; i < allParcels.size(); i++) {
			if(Double.compare(allParcels.get(i).getWeight(), largest) >= 0) {
				largest = allParcels.get(i).getWeight();
			}
		}
		return largest;
	}
	
	// return allParcels list if exists, singleton pattern
	public static List<Parcel> getAllParcels(){
		// Check if no parcel inside the list
		if (allParcels == null) {
			// If null create new arrayList
			allParcels = new ArrayList<Parcel>();
			loadFromCSV();
		}
		
		// return existing or newly created list
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
				
				if(values.length == 3) {	// To ensure both name and weight are recorded
					String name = values[0].trim();
					double weight = Double.parseDouble(values[1].trim());
					String type = values[2].trim();
					
					// add new parcel to the list
					allParcels.add(new Parcel(name, weight, type));
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		}
	}
	
	// Just for testing purpose
    // Display all parcels
    public static void displayAllParcels() {
        System.out.println("=== Parcel List ===");
        for (Parcel p : allParcels) {
            System.out.println("Parcel Name: " + p.getName() + ", Weight: " + p.getWeight() + " kg, "
            		+ "Type: " + p.getType());
        }
    }
    
    // Just for testing purpose
    public static void main(String[] args) {
    	getAllParcels();
    	displayAllParcels();
    	System.out.println(allParcels.size());
    	// testing
    }
}
