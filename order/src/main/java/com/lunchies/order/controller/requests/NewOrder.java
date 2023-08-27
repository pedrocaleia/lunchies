package com.lunchies.order.controller.requests;

/**
 * @author Pedro Caleia
 */
public class NewOrder {
	
	private final String employee;
	private final int entry;
	private final int mainCourse;
	private final int beverage;
	
	public NewOrder(String employee, int entry, int mainCourse, int beverage) {
		this.employee = employee;
		this.entry = entry;
		this.mainCourse = mainCourse;
		this.beverage = beverage;
	}

	public String getEmployee() {
		return this.employee;
	}

	public int getEntry() {
		return this.entry;
	}

	public int getMainCourse() {
		return this.mainCourse;
	}

	public int getBeverage() {
		return this.beverage;
	}	

}
