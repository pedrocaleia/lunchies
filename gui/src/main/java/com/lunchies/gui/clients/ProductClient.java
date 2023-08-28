package com.lunchies.gui.clients;

import org.springframework.web.reactive.function.client.WebClient;

import com.lunchies.gui.rtos.ProductRto;

/**
 * @author Pedro Caleia
 */
public final class ProductClient {
	
	private final WebClient webClient;
	private final String url;
	
	public ProductClient(WebClient webClient, String url) {
		this.webClient = webClient;
		this.url = url;
	}
	
	public ProductRto getProduct(int id) {
		return this.doGet(ProductRto.class, this.url + "/" + id);
	}
	
	private <R> R doGet(Class<R> clazz, String uri) {
		R response = this.webClient
    			.get()
    			.uri(uri)
    			.retrieve()
    			.bodyToMono(clazz)
    			.block();
		
		return response;
	}

}
