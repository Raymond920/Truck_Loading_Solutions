package edu.utar.binpacking.algorithms;

import java.util.*;
import edu.utar.binpacking.dataStructures.Parcel;
import edu.utar.binpacking.dataStructures.Truck;

public class FirstFitDecreasingAlgorithm extends FirstFitAlgorithm implements DecreasingSort {
    @Override
    public List<Truck> pack(Queue<Parcel> parcels, double loadLimit) {
        Queue<Parcel> sortedParcels = sortDecreasing(parcels);
        return super.pack(sortedParcels, loadLimit);
    }
}
