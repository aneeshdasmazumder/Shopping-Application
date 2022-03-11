/**
 * 
 */
package com.programming.techie.productservice.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author anees
 *
 */

@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class Product {
	
	@Id
	private String id;
	private String name;
	private String description;
	private BigDecimal price;
	
}
