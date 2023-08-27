package com.lunchies.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lunchies.product.entity.Product;
import com.lunchies.product.entity.enums.ProductType;

/**
 * @author Pedro Caleia
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public List<Product> findByType(ProductType type);

}
