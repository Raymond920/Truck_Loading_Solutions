package edu.utar.binpacking;

import java.util.List;

public interface BinPackingAlgorithm {
	List<Truck> pack(List<Parcel> parcels, double loadLimit);
}
