package com.lunchies.gui.clients;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.reactive.function.client.WebClient;

import com.lunchies.gui.rtos.NewOrderRto;
import com.lunchies.gui.rtos.NewOrderRtoResponse;
import com.lunchies.gui.rtos.OrderRto;

/**
 * @author Pedro Caleia
 */
public final class OrderClient {
	
	private final WebClient webClient;
	private final String url;
	
	public OrderClient(WebClient webClient, String url) {
		this.webClient = webClient;
		this.url = url;
	}
	
	public int saveNewOrder(NewOrderRto newOrder) {
		NewOrderRtoResponse response = this.doPost(newOrder, NewOrderRtoResponse.class);
		return response.getId();
	}
	
	public List<OrderRto> getOrdersForEmployee(String employee) {
		OrderRto[] orders = webClient
				.get()
				.uri(this.url + "?employee=" + employee)
				.retrieve()
				.bodyToMono(OrderRto[].class)
				.block();
		
		return Arrays.asList(orders);
	}
	
	private <B, R> R doPost(B body, Class<R> clazz) {
		R response = this.webClient
    			.post()
    			.uri(this.url)
    			.bodyValue(body)
    			.retrieve()
    			.bodyToMono(clazz)
    			.block();
		
		return response;
	}

}
