package edu.utar.binpacking;

import java.util.List;
import java.util.ArrayList;

public class FirstFitAlgorithm implements BinPackingAlgorithm{

	@Override
	public List<Truck> pack(List<Parcel> parcels, double loadLimit) {
		// Initialize the result
		List<Truck> truckList = new ArrayList<Truck>();
		// Add the first truck into the list
		truckList.add(new Truck(loadLimit));
		
		// Pack the item one by one
		// Loop each parcel from parcels list
		for(int i = 0; i < parcels.size(); i++) {
			
			// Find the first that can accommodate
			int j;
			for(j = 0; j < truckList.size(); j++) {
				// To check if a parcel has smaller weight than a truck remaining loadlimit
				if(Double.compare(truckList.get(j).getRemainingLoad(), parcels.get(i).getWeight())>= 0) {
					// add the parcel to the truck
					truckList.get(j).addParcel(parcels.get(i));
					break;
				}
			}
			
			// If no truck could accommodate the remaining parcel
			if(j == truckList.size()) {
				// Add new truck to the truck list
				truckList.add(new Truck(loadLimit));
				
				// Add current parcel to this truck, which cannot fit into the previous trucks
				truckList.get(truckList.size()-1).addParcel(parcels.get(i));
			}
		}
		return truckList;
	}

}
