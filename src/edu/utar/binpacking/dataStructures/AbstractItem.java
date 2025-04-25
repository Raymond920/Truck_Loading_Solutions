package edu.utar.binpacking.dataStructures;

public abstract class AbstractItem implements Item {
	private String name;
	private double weight;
	private String type;

	public AbstractItem(String name, double weight, String type) {
		this.name = name;
		this.weight = weight;
		this.type = type;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public String getType() {
		return type;
	}
}
