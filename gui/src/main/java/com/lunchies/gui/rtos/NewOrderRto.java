package com.lunchies.gui.rtos;

/**
 * @author Pedro Caleia
 */
public final class NewOrderRto {
	
	private String employee;
	private int entry;
	private int entryCalorieCount;
	private int mainCourse;
	private int mainCourseCalorieCount;
	private int beverage;
	private int beverageCalorieCount;
	
	public NewOrderRto(String employee, int entry, int entryCalorieCount, int mainCourse, int mainCourseCalorieCount, int beverage, int beverageCalorieCount) {
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
	
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	
	public int getEntry() {
		return this.entry;
	}
	
	public void setEntry(int entry) {
		this.entry = entry;
	}
	
	public int getEntryCalorieCount() {
		return this.entryCalorieCount;
	}

	public void setEntryCalorieCount(int entryCalorieCount) {
		this.entryCalorieCount = entryCalorieCount;
	}
	
	public int getMainCourse() {
		return this.mainCourse;
	}
	
	public void setMainCourse(int mainCourse) {
		this.mainCourse = mainCourse;
	}
	
	public int getMainCourseCalorieCount() {
		return this.mainCourseCalorieCount;
	}

	public void setMainCourseCalorieCount(int mainCourseCalorieCount) {
		this.mainCourseCalorieCount = mainCourseCalorieCount;
	}
	
	public int getBeverage() {
		return this.beverage;
	}
	
	public void setBeverage(int beverage) {
		this.beverage = beverage;
	}

	public int getBeverageCalorieCount() {
		return this.beverageCalorieCount;
	}

	public void setBeverageCalorieCount(int beverageCalorieCount) {
		this.beverageCalorieCount = beverageCalorieCount;
	}
	
}
