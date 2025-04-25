package edu.utar.binpacking.algorithms;

import java.util.*;
import edu.utar.binpacking.dataStructures.Parcel;

public interface DecreasingSort {
    default Queue<Parcel> sortDecreasing(Queue<Parcel> parcels) {
        // Convert queue to list for sorting
        List<Parcel> parcelList = new ArrayList<>();
        Iterator<Parcel> queueIterator = parcels.iterator();
        while (queueIterator.hasNext()) {
            parcelList.add(queueIterator.next());
        }

        // Sort parcels by weight in descending order
        Collections.sort(parcelList, (p1, p2) -> Double.compare(p2.getWeight(), p1.getWeight()));

        // Create a new queue with the sorted parcels
        return new LinkedList<>(parcelList);
    }
}
