package com.order_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.order_management.entity.Item;
import com.order_management.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/items")
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    // Get all items
    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    // Get item by ID
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Optional<Item> itemOpt = itemService.getItemById(id);
        return itemOpt.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // Create new item
    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item saved = itemService.saveItem(item);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    
    // Update existing item
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        Optional<Item> existing = itemService.getItemById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        item.setItemId(id);
        return ResponseEntity.ok(itemService.saveItem(item));
    }

    // Delete item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

    // Update available quantity
    @PatchMapping("/{id}/quantity")
    public ResponseEntity<Void> updateItemQuantity(@PathVariable Long id, @RequestParam int delta) {
        try {
            itemService.updateAvailableQuantity(id, delta);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
