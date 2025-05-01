package edu.utar.binpacking.algorithms;

import java.util.*;
import edu.utar.binpacking.dataStructures.*;

public abstract class AbstractBinPackingAlgorithm implements BinPackingAlgorithm {
	private long executionTime;
	private String name;
	private List<Truck> truckList;
	
	public AbstractBinPackingAlgorithm(String name) {
		this.name = name;
		this.executionTime = 0;
		this.truckList = new ArrayList<Truck>();
	}

	@Override
	public long getExecutionTime() {
		return executionTime;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<Truck> getTruckList() {
		return truckList;
	}
	
	@Override
	public final void Pack(Queue<Parcel> parcels, double loadLimit) {
		long startTime = System.nanoTime();
		truckList = pack(parcels, loadLimit);
		executionTime = System.nanoTime() - startTime;
	}
	
	protected abstract List<Truck> pack(Queue<Parcel> parcels, double loadLimit);
}
