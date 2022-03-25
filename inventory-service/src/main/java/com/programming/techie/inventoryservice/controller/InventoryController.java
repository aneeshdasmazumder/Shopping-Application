/**
 * 
 */
package com.programming.techie.inventoryservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programming.techie.inventoryservice.model.Inventory;
import com.programming.techie.inventoryservice.repository.InventoryRepository;

/**
 * @author anees
 *
 */
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	
	private final InventoryRepository inventoryRepo;
	
	private InventoryController(InventoryRepository inventoryRepo) {
		this.inventoryRepo = inventoryRepo;
	}
	
	@GetMapping("/{skuCode}")
	Boolean isInStock(@PathVariable String skuCode) {
		Inventory inventory = inventoryRepo.findBySkuCode(skuCode)
				.orElseThrow(() -> new RuntimeException("Cannot find Product with SKU Code " + skuCode));
				
				return inventory.getStock() > 0;
	}
	
}
