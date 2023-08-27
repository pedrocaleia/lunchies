package com.lunchies.gui.rtos;

/**
 * @author Pedro Caleia
 */
public final class ProductRto {
	
	private int id;
	private String name;
	private String description;
	private String type;
	private int calorieCount;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCalorieCount() {
		return this.calorieCount;
	}

	public void setCalorieCount(int calorieCount) {
		this.calorieCount = calorieCount;
	}

}
