package com.lunchies.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunchies.product.entity.Product;
import com.lunchies.product.repository.ProductRepository;

/**
 * @author Pedro Caleia
 */
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public Product saveProduct(Product product) {
		return this.productRepository.save(product);
	}
	    
	public Optional<Product> getProductById(int id) {
		Optional<Product> product = this.productRepository.findById(id);
		return product;
	}
	
	public List<Product> listProducts() {
		return this.productRepository.findAll();
	}
	
	public void deleteProduct(int id) {
		this.productRepository.deleteById(id);
	}

}
