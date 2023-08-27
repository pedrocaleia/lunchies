package com.lunchies.product.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lunchies.product.controller.requests.NewProduct;
import com.lunchies.product.controller.responses.NewProductResponse;
import com.lunchies.product.controller.responses.ProductResponse;
import com.lunchies.product.entity.Product;
import com.lunchies.product.service.ProductService;

/**
 * @author Pedro Caleia
 */
@RestController
public final class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	private ResponseEntity<NewProductResponse> newProduct(@RequestBody NewProduct newProduct) {
		Product product = new Product(newProduct.getName(), newProduct.getDescription(), newProduct.getType(), newProduct.getCalorieCount());
		
		try {
			product = this.productService.saveProduct(product);
			NewProductResponse newProductResponse = new NewProductResponse(product.getId());
			return ResponseEntity.status(HttpStatus.CREATED).body(newProductResponse);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/product/{id}")
	private ResponseEntity<ProductResponse> getProduct(@PathVariable("id") int id) {
		Optional<Product> product = this.productService.getProductById(id);
		
		if(product.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			ProductResponse productResponse = new ProductResponse(product.get());
			return ResponseEntity.status(HttpStatus.OK).body(productResponse);
		}
	}

}
