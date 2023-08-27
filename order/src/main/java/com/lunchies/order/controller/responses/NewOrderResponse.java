package com.lunchies.order.controller.responses;

/**
 * @author Pedro Caleia
 */
public final class NewOrderResponse {
	
	private final int id;

	public NewOrderResponse(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

}
