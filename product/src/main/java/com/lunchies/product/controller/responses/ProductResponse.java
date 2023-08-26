package com.lunchies.product.controller.responses;

import com.lunchies.product.entity.Product;
import com.lunchies.product.entity.enums.ProductType;

/**
 * @author Pedro Caleia
 */
public final class ProductResponse {
	
	private final String name;
	private final String description;
	private final ProductType type;
	private final int calorieCount;
	
	public ProductResponse(String name, String description, ProductType type, int calorieCount) {
		this.name = name;
		this.description = description;
		this.type = type;
		this.calorieCount = calorieCount;
	}
	
	public ProductResponse(Product product) {
		this.name = product.getName();
		this.description = product.getDescription();
		this.type = product.getType();
		this.calorieCount = product.getCalorieCount();
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
