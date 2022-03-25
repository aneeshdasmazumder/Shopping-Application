/**
 * 
 */
package com.programming.techie.orderservice.dto;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.programming.techie.orderservice.model.OrderLineItems;



/**
 * @author anees
 *
 */

public class OrderDto {
	
	private List<OrderLineItems> orderLineItemsList;
	private static final Logger logger = LoggerFactory.getLogger(OrderDto.class);

	/**
	 * @return the orderLineItemsList
	 */
	public List<OrderLineItems> getOrderLineItemsList() {
		logger.info("---orderLineItemsList---- "+ orderLineItemsList);
		return orderLineItemsList;
	}

	/**
	 * @param orderLineItemsList the orderLineItemsList to set
	 */
	public void setOrderLineItemsList(List<OrderLineItems> orderLineItemsList) {
		
		this.orderLineItemsList = orderLineItemsList;
		logger.info("orderLineItemsList" + orderLineItemsList);
	}

	/**
	 * @param orderLineItemsList
	 */
	public OrderDto(List<OrderLineItems> orderLineItemsList) {
		super();
		this.orderLineItemsList = orderLineItemsList;
	}

	/**
	 * 
	 */
	public OrderDto() {
		super();
	}

	@Override
	public String toString() {
		return "OrderDto [orderLineItemsList=" + orderLineItemsList + "]";
	}	
	
	
}
