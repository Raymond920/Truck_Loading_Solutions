package edu.utar.binpacking.dataStructures;

import java.util.Stack;
import java.util.List;

public abstract class AbstractContainer implements Container {
	private double loadLimit;
	private double currentLoad;
	private double remainingLoad;
	private boolean isFull;
	private List<Item> items;

	public AbstractContainer(double loadLimit) {
		this.loadLimit = loadLimit;
		this.currentLoad = 0.0;
		// a container's instance is empty when created, thus it can loaded with
		// loadLimit
		this.remainingLoad = loadLimit;
		this.isFull = false;
		this.items = new Stack<>();
	}

	@Override
	public double getLoadLimit() {
		return loadLimit;
	}

	@Override
	public double getCurrentLoad() {
		return currentLoad;
	}

	@Override
	public double getRemainingLoad() {
		return remainingLoad;
	}

	@Override
	public boolean getIsFull() {
		return isFull;
	}

	@Override
	public List<Item> getItems() {
		return items;
	}

	@Override
	public void addItem(Item item) {
		items.add(item);
		currentLoad += item.getWeight();
		remainingLoad -= item.getWeight();
		if (remainingLoad == 0) {
			isFull = true;
		}
	}
}
