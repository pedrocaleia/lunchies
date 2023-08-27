package com.lunchies.product.controller.responses;

/**
 * @author Pedro Caleia
 */
public final class NewProductResponse {
	
	private final int id;

	public NewProductResponse(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

}
