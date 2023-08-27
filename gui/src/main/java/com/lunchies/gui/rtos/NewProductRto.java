package com.lunchies.gui.rtos;

/**
 * @author Pedro Caleia
 */
public final class NewProductRto {
	
	private String name;
	private String description;
	private String type;
	private int calorieCount;
	
	public NewProductRto(String name, String description, String type, int calorieCount) {
		this.name = name;
		this.description = description;
		this.type = type;
		this.calorieCount = calorieCount;
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
