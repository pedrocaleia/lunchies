package com.lunchies.order.controller;

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

import com.lunchies.order.entity.Order;
import com.lunchies.order.service.OrderService;

/**
 * @author Pedro Caleia
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = OrderController.class)
public class OrderControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private OrderService orderService;
	
	@Test
	public void createNewOrder() throws Exception  {
		Order order = new Order("pedrocaleia", 1, 2, 3);
		order.setId(1);
		String orderJson = "{\"employee\": \"pedrocaleia\",\"entry\": 1,\"mainCourse\": 2,\"beverage\": 3}";
		
		Mockito.when(this.orderService.saveOrder(Mockito.any(Order.class))).thenReturn(order);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/order")
				.accept(MediaType.APPLICATION_JSON).content(orderJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String expectedResponse = "{\"id\": 1}";
		Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		JSONAssert.assertEquals(expectedResponse, result.getResponse().getContentAsString(), false);
	}

}
