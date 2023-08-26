package com.lunchies.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lunchies.product.entity.Product;

/**
 * @author Pedro Caleia
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
