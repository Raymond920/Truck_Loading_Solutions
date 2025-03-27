package edu.utar.binpacking;
import java.util.*;

public class Truck {
	private double loadLimit;
	private double currentLoad;
	private boolean isFull;
	private List<Parcel> packedParcels;	// To record the parcels packed into a truck
	
	public double getLoadLimit() {
		return loadLimit;
	}

	public void setLoadLimit(double loadLimit) {
		this.loadLimit = loadLimit;
	}

	public double getCurrentLoad() {
		return currentLoad;
	}

	public void setCurrentLoad(double currentLoad) {
		this.currentLoad = currentLoad;
	}

	public boolean getIsFull() {
		return isFull;
	}

	public void setIsFull(boolean isFull) {
		this.isFull = isFull;
	}

	public List<Parcel> getPackedParcels() {
		return packedParcels;
	}

	// initialize the attribute of a new Truck
	public Truck(double loadLimit) {
		this.loadLimit = loadLimit;
		this.currentLoad = 0.0;
		this.isFull = false;
		this.packedParcels = new ArrayList<Parcel>();
	}
	
	
}
