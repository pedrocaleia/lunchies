package com.lunchies.gui;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.lunchies.gui.clients.OrderClient;

/**
 * @author Pedro Caleia
 */
@Configuration
public class BeansConfiguration {
	
	@Bean
	public OrderClient orderClient(WebClient webClient) {
		return new OrderClient(webClient, "http://127.0.0.1:9092/order");
	}

}
