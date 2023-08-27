package com.lunchies.order.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lunchies.order.controller.requests.NewOrder;
import com.lunchies.order.controller.responses.NewOrderResponse;
import com.lunchies.order.controller.responses.OrderResponse;
import com.lunchies.order.entity.Order;
import com.lunchies.order.service.OrderService;

/**
 * @author Pedro Caleia
 */
@RestController
public final class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order")
	private ResponseEntity<NewOrderResponse> newOrder(@RequestBody NewOrder newOrder) {
		Order order = new Order(newOrder.getEmployee(), newOrder.getEntry(), newOrder.getMainCourse(), newOrder.getBeverage());
		
		try {
			order = this.orderService.saveOrder(order);
			NewOrderResponse newOrderResponse = new NewOrderResponse(order.getId());
			return ResponseEntity.status(HttpStatus.CREATED).body(newOrderResponse);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/order/{id}")
	private ResponseEntity<OrderResponse> getOrder(@PathVariable("id") int id) {
		Optional<Order> order = this.orderService.getOrderById(id);
		
		if(order.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			OrderResponse orderResponse = new OrderResponse(order.get());
			return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
		}
	}
	
	@GetMapping("/order")
	private ResponseEntity<List<OrderResponse>> getOrders() {
		List<Order> orders = this.orderService.listOrders();
		
		List<OrderResponse> orderResponses = orders.stream().map(OrderResponse::new).toList();
		
		return ResponseEntity.status(HttpStatus.OK).body(orderResponses);
	}
	
	@DeleteMapping("/order/{id}")
	private ResponseEntity<Void> deleteOrder(@PathVariable("id") int id) {
		this.orderService.deleteOrder(id);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
