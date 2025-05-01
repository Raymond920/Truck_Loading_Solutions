package edu.utar.binpacking.algorithms;

import java.util.*;

import edu.utar.binpacking.dataStructures.Parcel;
import edu.utar.binpacking.dataStructures.Truck;

import java.util.ArrayList;

public class BestFitAlgorithm extends AbstractBinPackingAlgorithm {

	public BestFitAlgorithm() {
		super("Best Fit Algorithm");
	}
	
	public BestFitAlgorithm(String name) {
		super(name);
	}
	
    @Override
    public List<Truck> pack(Queue<Parcel> parcels, double loadLimit) {
        List<Truck> truckList = new ArrayList<>();
        truckList.add(new Truck(loadLimit));

        // Use iterator instead of enhanced for loop
        Iterator<Parcel> iterator = parcels.iterator();
        while (iterator.hasNext()) {
            Parcel parcel = iterator.next();
            
            int bestFitIndex = -1;
            double minRemaining = Double.MAX_VALUE;

            // Try to find the best-fit truck
            for (int i = 0; i < truckList.size(); i++) {
                Truck truck = truckList.get(i);
                double remaining = truck.getRemainingLoad();

                if (parcel.getWeight() <= remaining && (remaining - parcel.getWeight() < minRemaining)) {
                    bestFitIndex = i;
                    minRemaining = remaining - parcel.getWeight();
                }
            }

            // If found a truck that fits best
            if (bestFitIndex != -1) {
                truckList.get(bestFitIndex).addItem(parcel);
            } else {
                // No suitable truck found, create a new one
                Truck newTruck = new Truck(loadLimit);
                newTruck.addItem(parcel);
                truckList.add(newTruck);
            }
        }

        return truckList;
    }
}
