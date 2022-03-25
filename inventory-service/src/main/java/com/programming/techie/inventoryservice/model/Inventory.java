/**
 * 
 */
package com.programming.techie.inventoryservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id; 


/**
 * @author anees
 *
 */
@Entity
@Table(name="inventory")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String skuCode;
	private Integer stock;
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
	 * @return the skuCode
	 */
	public String getSkuCode() {
		return skuCode;
	}
	/**
	 * @param skuCode the skuCode to set
	 */
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	/**
	 * @return the stock
	 */
	public Integer getStock() {
		return stock;
	}
	/**
	 * @param stock the stock to set
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	/**
	 * @param id
	 * @param skuCode
	 * @param stock
	 */
	public Inventory(Long id, String skuCode, Integer stock) {
		super();
		this.id = id;
		this.skuCode = skuCode;
		this.stock = stock;
	}
	/**
	 * 
	 */
	public Inventory() {
		super();
	}
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", skuCode=" + skuCode + ", stock=" + stock + "]";
	}
	
}
