/**
 * 
 */
package com.programming.techie.inventoryservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programming.techie.inventoryservice.model.Inventory;

/**
 * @author anees
 *
 */
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	Optional<Inventory> findBySkuCode(String skuCode);

}
