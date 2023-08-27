package com.lunchies.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Pedro Caleia
 */
@Entity
@Table(name = "order")
public final class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "employee")
	private String employee;
	
	@Column(name = "entry")
	private int entry;
	
	@Column(name = "maincourse")
	private int mainCourse;
	
	@Column(name = "beverage")
	private int beverage;
	
	public Order() {
	}

	public Order(String employee, int entry, int mainCourse, int beverage) {
		this.employee = employee;
		this.entry = entry;
		this.mainCourse = mainCourse;
		this.beverage = beverage;
	}

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

}
