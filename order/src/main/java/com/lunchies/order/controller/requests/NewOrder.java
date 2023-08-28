package com.lunchies.order.controller.requests;

/**
 * @author Pedro Caleia
 */
public class NewOrder {
	
	private final String employee;
	private final int entry;
	private final int entryCalorieCount;
	private final int mainCourse;
	private final int mainCourseCalorieCount;
	private final int beverage;
	private final int beverageCalorieCount;
	
	public NewOrder(String employee, int entry, int entryCalorieCount, int mainCourse, int mainCourseCalorieCount, int beverage, int beverageCalorieCount) {
		this.employee = employee;
		this.entry = entry;
		this.entryCalorieCount = entryCalorieCount;
		this.mainCourse = mainCourse;
		this.mainCourseCalorieCount = mainCourseCalorieCount;
		this.beverage = beverage;
		this.beverageCalorieCount = beverageCalorieCount;
	}

	public String getEmployee() {
		return this.employee;
	}

	public int getEntry() {
		return this.entry;
	}
	
	public int getEntryCalorieCount() {
		return this.entryCalorieCount;
	}

	public int getMainCourse() {
		return this.mainCourse;
	}
	
	public int getMainCourseCalorieCount() {
		return this.mainCourseCalorieCount;
	}

	public int getBeverage() {
		return this.beverage;
	}

	public int getBeverageCalorieCount() {
		return this.beverageCalorieCount;
	}

}
