package com.lunchies.product.controller;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.lunchies.product.entity.Product;
import com.lunchies.product.entity.enums.ProductType;
import com.lunchies.product.service.ProductService;

/**
 * @author Pedro Caleia
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = ProductController.class)
public class ProductControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductService productService;
	
	@Test
	public void createNewProduct() throws Exception  {
		Product product = new Product("Bread", "Some bread", ProductType.ENTRY, 150);
		product.setId(1);
		String productJson = "{\"name\": \"Bread\",\"description\": \"Some bread\",\"type\": \"ENTRY\",\"calorieCount\": 150}";
		
		Mockito.when(this.productService.saveProduct(Mockito.any(Product.class))).thenReturn(product);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/product")
				.accept(MediaType.APPLICATION_JSON).content(productJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String expectedResponse = "{\"id\": 1}";
		Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		JSONAssert.assertEquals(expectedResponse, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void getProduct() throws Exception  {
		Product product = new Product("Bread", "Some bread", ProductType.ENTRY, 150);
		product.setId(1);
		
		Mockito.when(this.productService.getProductById(1)).thenReturn(Optional.of(product));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/product/1")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String expectedResponse = "{\"name\": \"Bread\",\"description\": \"Some bread\",\"type\": \"ENTRY\",\"calorieCount\": 150}";
		Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
		JSONAssert.assertEquals(expectedResponse, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void listProducts() throws Exception  {
		Product bread = new Product("Bread", "Some bread", ProductType.ENTRY, 150);
		bread.setId(1);
		Product salad = new Product("Salad", "Some salad", ProductType.MAIN_COURSE, 250);
		salad.setId(2);
		
		Mockito.when(this.productService.listProducts()).thenReturn(List.of(bread, salad));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/product")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String expectedResponse = "[{\"name\": \"Bread\",\"description\": \"Some bread\",\"type\": \"ENTRY\",\"calorieCount\": 150},"
				+ "{\"name\": \"Salad\",\"description\": \"Some salad\",\"type\": \"MAIN_COURSE\",\"calorieCount\": 250}]";
		Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
		JSONAssert.assertEquals(expectedResponse, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void listProductsByType() throws Exception  {
		Product bread = new Product("Bread", "Some bread", ProductType.ENTRY, 150);
		bread.setId(1);
		Product soap = new Product("Soap", "Some soap", ProductType.ENTRY, 225);
		soap.setId(2);
		
		Mockito.when(this.productService.listProducts(ProductType.ENTRY)).thenReturn(List.of(bread, soap));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/product?type=ENTRY")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String expectedResponse = "[{\"name\": \"Bread\",\"description\": \"Some bread\",\"type\": \"ENTRY\",\"calorieCount\": 150},"
				+ "{\"name\": \"Soap\",\"description\": \"Some soap\",\"type\": \"ENTRY\",\"calorieCount\": 225}]";
		Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
		JSONAssert.assertEquals(expectedResponse, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void deleteProduct() throws Exception  {
		Product bread = new Product("Bread", "Some bread", ProductType.ENTRY, 150);
		bread.setId(1);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.delete("/product/1")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String expectedResponse = "";
		Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
		Assertions.assertEquals(expectedResponse, result.getResponse().getContentAsString());
	}

}
