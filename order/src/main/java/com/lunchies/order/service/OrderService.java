package com.lunchies.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunchies.order.entity.Order;
import com.lunchies.order.formulas.CaloriesCalculationFormula;
import com.lunchies.order.repository.OrderRepository;

/**
 * @author Pedro Caleia
 */
@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CaloriesCalculationFormula formula;

	public Order saveOrder(Order order, int entryCalorieCount, int mainCourseCalorieCount, int beverageCalorieCount) {
		order.setCalories(this.formula.calculate(entryCalorieCount, mainCourseCalorieCount, beverageCalorieCount));
		return this.orderRepository.save(order);
	}
	    
	public Optional<Order> getOrderById(int id) {
		Optional<Order> order = this.orderRepository.findById(id);
		return order;
	}
	
	public List<Order> listOrders() {
		return this.orderRepository.findAll();
	}
	
	public List<Order> listOrders(String employee) {
		return this.orderRepository.findByEmployee(employee);
	}
	
	public void deleteOrder(int id) {
		this.orderRepository.deleteById(id);
	}

}
