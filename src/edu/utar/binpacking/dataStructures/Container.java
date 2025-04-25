package edu.utar.binpacking.dataStructures;

import java.util.List;

public interface Container {
	double getLoadLimit();
	double getCurrentLoad();
	double getRemainingLoad();
	boolean getIsFull();
	List<Item> getItems();
	void addItem(Item item);
}
