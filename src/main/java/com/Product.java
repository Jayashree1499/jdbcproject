package com;

public class Product {
	private int id;
	private String name;
	private String type;
	private double cost;

	public Product(int id, String name, String type, double cost) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.cost = cost;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public double getCost() {
		return cost;
	}

	@Override
	public String toString() {
		return "id=" + id + "\nname=" + name + "\ntype=" + type + "\ncost=" + cost;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
