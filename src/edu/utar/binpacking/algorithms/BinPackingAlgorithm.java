package edu.utar.binpacking.algorithms;

import java.util.*;

import edu.utar.binpacking.dataStructures.Parcel;
import edu.utar.binpacking.dataStructures.Truck;

public interface BinPackingAlgorithm {
	List<Truck> pack(Queue<Parcel> parcels, double loadLimit);
}
