package edu.utar.binpacking.algorithms;

import java.util.*;
import edu.utar.binpacking.dataStructures.Parcel;
import edu.utar.binpacking.dataStructures.Truck;

public class BestFitDecreasingAlgorithm extends BestFitAlgorithm implements DecreasingSort {
    public BestFitDecreasingAlgorithm() {
		super("Best Fit Decreasing");
	}
	
	@Override
    public List<Truck> pack(Queue<Parcel> parcels, double loadLimit) {
        Queue<Parcel> sortedParcels = sortDecreasing(parcels);
        return super.pack(sortedParcels, loadLimit);
    }

}
