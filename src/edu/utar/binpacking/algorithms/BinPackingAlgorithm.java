package edu.utar.binpacking.algorithms;

import java.util.*;

import edu.utar.binpacking.dataStructures.Parcel;
import edu.utar.binpacking.dataStructures.Truck;

public interface BinPackingAlgorithm {
	void Pack(Queue<Parcel> parcels, double loadLimit);
	String getName();
	long getExecutionTime();
	List<Truck> getTruckList();
}
