package edu.utar.binpacking;

import java.util.List;
import java.util.ArrayList;

public class BestFitAlgorithm implements BinPackingAlgorithm {

    @Override
    public List<Truck> pack(List<Parcel> parcels, double loadLimit) {
        List<Truck> truckList = new ArrayList<>();
        truckList.add(new Truck(loadLimit));

        for (Parcel parcel : parcels) {
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
                truckList.get(bestFitIndex).addParcel(parcel);
            } else {
                // No suitable truck found, create a new one
                Truck newTruck = new Truck(loadLimit);
                newTruck.addParcel(parcel);
                truckList.add(newTruck);
            }
        }

        return truckList;
    }
}