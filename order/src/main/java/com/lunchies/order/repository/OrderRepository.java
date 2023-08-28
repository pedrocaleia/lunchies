package com.lunchies.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lunchies.order.entity.Order;

/**
 * @author Pedro Caleia
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	public List<Order> findByEmployee(String employee);

}
