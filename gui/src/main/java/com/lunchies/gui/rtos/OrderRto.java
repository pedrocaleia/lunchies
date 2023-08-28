package com.lunchies.gui.rtos;

/**
 * @author Pedro Caleia
 */
public final class OrderRto {
	
	private int id;
	private String employee;
	private int entry;
	private int mainCourse;
	private int beverage;
	private int calories;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmployee() {
		return this.employee;
	}
	
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	
	public int getEntry() {
		return this.entry;
	}
	
	public void setEntry(int entry) {
		this.entry = entry;
	}
	
	public int getMainCourse() {
		return this.mainCourse;
	}
	
	public void setMainCourse(int mainCourse) {
		this.mainCourse = mainCourse;
	}
	
	public int getBeverage() {
		return this.beverage;
	}
	
	public void setBeverage(int beverage) {
		this.beverage = beverage;
	}

	public int getCalories() {
		return this.calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

}
