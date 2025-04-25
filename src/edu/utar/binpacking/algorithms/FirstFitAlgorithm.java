package edu.utar.binpacking.algorithms;

import java.util.*;
import edu.utar.binpacking.dataStructures.Parcel;
import edu.utar.binpacking.dataStructures.Truck;

public class FirstFitAlgorithm implements BinPackingAlgorithm {

	@Override
	public List<Truck> pack(Queue<Parcel> parcels, double loadLimit) {
		// Initialize the result
		List<Truck> truckList = new ArrayList<Truck>();
		// Add the first truck into the list
		truckList.add(new Truck(loadLimit));
		
		// Pack the item one by one
		// Use an iterator to go through the queue
		Iterator<Parcel> iterator = parcels.iterator();
		while (iterator.hasNext()) {
			Parcel currentParcel = iterator.next();
			
			// Find the first that can accommodate
			int j;
			for(j = 0; j < truckList.size(); j++) {
				// To check if a parcel has smaller weight than a truck remaining loadlimit
				if(Double.compare(truckList.get(j).getRemainingLoad(), currentParcel.getWeight()) >= 0) {
					// add the parcel to the truck
					truckList.get(j).addItem(currentParcel);
					break;
				}
			}
			
			// If no truck could accommodate the remaining parcel
			if(j == truckList.size()) {
				// Add new truck to the truck list
				truckList.add(new Truck(loadLimit));
				
				// Add current parcel to this truck, which cannot fit into the previous trucks
				truckList.get(truckList.size()-1).addItem(currentParcel);
			}
		}
		return truckList;
	}
}
