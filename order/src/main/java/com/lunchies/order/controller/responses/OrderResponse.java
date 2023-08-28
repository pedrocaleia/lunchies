package com.lunchies.order.controller.responses;

import com.lunchies.order.entity.Order;

/**
 * @author Pedro Caleia
 */
public final class OrderResponse {
	
	private final int id;
	private final String employee;
	private final int entry;
	private final int mainCourse;
	private final int beverage;
	private final int calories;
	
	public OrderResponse(Order order) {
		this.id = order.getId();
		this.employee = order.getEmployee();
		this.entry = order.getEntry();
		this.mainCourse = order.getMainCourse();
		this.beverage = order.getBeverage();
		this.calories = order.getCalories();
	}

	public int getId() {
		return this.id;
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

	public int getCalories() {
		return this.calories;
	}
	
}
