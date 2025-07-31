package com.order_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.order_management.entity.Item;
import java.util.List;
import java.util.Optional;



public interface ItemRepository extends JpaRepository<Item, Long>{

    // Find item by name
    List<Item> findByName(String name);

    // Find item by sku
    Optional<Item> findBySku(String sku);
    
}
