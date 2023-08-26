package com.lunchies.product.controller.requests;

import com.lunchies.product.entity.enums.ProductType;

/**
 * @author Pedro Caleia
 */
public class NewProduct {
	
	private final String name;
	private final String description;
	private final ProductType type;
	private final int calorieCount;
	
	public NewProduct(String name, String description, ProductType type, int calorieCount) {
		this.name = name;
		this.description = description;
		this.type = type;
		this.calorieCount = calorieCount;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public ProductType getType() {
		return this.type;
	}
	
	public int getCalorieCount() {
		return this.calorieCount;
	}

}
