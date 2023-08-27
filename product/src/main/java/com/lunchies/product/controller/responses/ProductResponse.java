package com.lunchies.product.controller.responses;

import com.lunchies.product.entity.Product;
import com.lunchies.product.entity.enums.ProductType;

/**
 * @author Pedro Caleia
 */
public final class ProductResponse {
	
	private final int id;
	private final String name;
	private final String description;
	private final ProductType type;
	private final int calorieCount;
	
	public ProductResponse(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.type = product.getType();
		this.calorieCount = product.getCalorieCount();
	}

	public int getId() {
		return this.id;
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
