package edu.utar.binpacking.algorithms;

import java.util.*;

import edu.utar.binpacking.dataStructures.Parcel;
import edu.utar.binpacking.dataStructures.Truck;

public class NextFitAlgorithm implements BinPackingAlgorithm{
	 @Override
	    public List<Truck> pack(Queue<Parcel> parcels, double loadLimit) {
		 	List<Truck> truckList = new ArrayList<>();
		 	Truck newTruck = new Truck(loadLimit);
            truckList.add(newTruck);
	        
	        Iterator<Parcel> iterator = parcels.iterator();
	        while (iterator.hasNext()) {
	        	Parcel parcel = iterator.next();
	        	double remaining = newTruck.getRemainingLoad();
	        	if(parcel.getWeight() <= remaining) {
	        		newTruck.addItem(parcel);
	        	}
	        	else {
	        		newTruck = new Truck(loadLimit);
	                newTruck.addItem(parcel);
	                truckList.add(newTruck);
	        	}
	        	
	        }
	        
	        return truckList;
	 }
}
