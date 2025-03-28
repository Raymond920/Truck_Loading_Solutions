package edu.utar.binpacking;
import java.util.*;

public class Truck {
	private double loadLimit;
	private double currentLoad;
	private double remainingLoad;
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
	
	public double getRemainingLoad() {
		return remainingLoad;
	}

	public void setRemainingLoad(double remainingLoad) {
		this.remainingLoad = remainingLoad;
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
	
	public double countRemainingLoad() {
		// to check the parcels list is not empty
		if(!packedParcels.isEmpty()) {
			for(int i = 0; i < packedParcels.size(); i++) {
				remainingLoad = remainingLoad - packedParcels.get(i).getWeight();
			}
		}
		return remainingLoad;
	}
	
	public void addParcel(Parcel p) {
		packedParcels.add(p);
		// count and set the new remaining load
		setRemainingLoad(countRemainingLoad());
	}

	// initialize the attribute of a new Truck
	public Truck(double loadLimit) {
		this.loadLimit = loadLimit;
		this.currentLoad = 0.0;
		// a truck's instance is empty when created, thus it can loaded with loadLimit
		this.remainingLoad = loadLimit;
		this.isFull = false;
		this.packedParcels = new ArrayList<Parcel>();
	}
	
	
}
