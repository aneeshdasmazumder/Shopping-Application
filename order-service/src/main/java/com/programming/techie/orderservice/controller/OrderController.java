/**
 * 
 */
package com.programming.techie.orderservice.controller;

import java.util.UUID;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programming.techie.orderservice.client.InventoryClient;
import com.programming.techie.orderservice.dto.OrderDto;
import com.programming.techie.orderservice.model.Order;
import com.programming.techie.orderservice.repository.OrderRepository;


/**
 * @author anees
 *
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	private final OrderRepository orderRepo;
	private final InventoryClient inventoryclient;
	private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;
	
	private OrderController(OrderRepository orderRepo, InventoryClient inventoryclient, Resilience4JCircuitBreakerFactory circuitBreakerFactory) {
		this.orderRepo = orderRepo;
		this.inventoryclient = inventoryclient;
		this.circuitBreakerFactory = circuitBreakerFactory;
	}
	
	@PostMapping
	public String placeOrder(@RequestBody OrderDto orderDto) {
		logger.info("<-----------------------Inside Post Method-------------------------->");
		logger.info(orderDto.toString());
		Resilience4JCircuitBreaker circuitBreaker = circuitBreakerFactory.create("inventory");
		Supplier<Boolean> booleanSupplier = () -> orderDto.getOrderLineItemsList().stream().allMatch(orderLineItems ->inventoryclient.checkStock(orderLineItems.getSkuCode()));
		boolean allProductsInStock = circuitBreaker.run(booleanSupplier, throwable -> handleErrorCase());
		
		if(allProductsInStock) {
			logger.info("---------------Inside If-Else--------------------");
			Order order = new Order();
			order.setOrderLineItems(orderDto.getOrderLineItemsList());
			order.setOrderNumber(UUID.randomUUID().toString());
			
			orderRepo.save(order);
			return "Order placed successfully!!";
		} else {
			return "Order failed!! Out of stock.";
		}
	}
	
	private Boolean handleErrorCase() {
        return false;
    }
}
