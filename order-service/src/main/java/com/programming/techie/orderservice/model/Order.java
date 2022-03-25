/**
 * 
 */
package com.programming.techie.orderservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.hibernate.annotations.Cascade;

/**
 * @author anees
 *
 */
@Entity
@Table(name = "t_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String orderNumber;
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderLineItems> orderLineItems;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the orderNumber
	 */
	public String getOrderNumber() {
		return orderNumber;
	}
	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	/**
	 * @return the orderLineItems
	 */
	public List<OrderLineItems> getOrderLineItems() {
		return orderLineItems;
	}
	/**
	 * @param orderLineItems the orderLineItems to set
	 */
	public void setOrderLineItems(List<OrderLineItems> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", orderLineItems=" + orderLineItems + "]";
	}
	/**
	 * @param id
	 * @param orderNumber
	 * @param orderLineItems
	 */
	public Order(Long id, String orderNumber, List<OrderLineItems> orderLineItems) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.orderLineItems = orderLineItems;
	}
	/**
	 * 
	 */
	public Order() {
		super();
	}
	
	
}
