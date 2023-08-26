package com.lunchies.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunchies.product.entity.Product;
import com.lunchies.product.repository.ProductRepository;

/**
 * @author Pedro Caleia
 */
@Service
public final class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
  
    public Optional<Product> getProductById(int id) {
		Optional<Product> product = this.productRepository.findById(id);
		return product;
	}

}
