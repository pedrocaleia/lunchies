package com.lunchies.gui.rtos;

/**
 * @author Pedro Caleia
 */
public final class NewOrderRto {
	
	private String employee;
	private int entry;
	private int mainCourse;
	private int beverage;
	
	public NewOrderRto(String employee, int entry, int mainCourse, int beverage) {
		this.employee = employee;
		this.entry = entry;
		this.mainCourse = mainCourse;
		this.beverage = beverage;
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

}
