package com.order_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.order_management.entity.Item;
import com.order_management.repository.ItemRepository;

@Service
@Transactional
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // Create a new item in the database
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    // Get all items from the database
    @Transactional(readOnly = true)
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Get a single item by its ID
    @Transactional(readOnly = true)
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    // Delete item by ID
    public void deleteItem(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new RuntimeException("Item not found with ID: " + id);
        }

        itemRepository.deleteById(id);
    }

    // Find item by SKU
    @Transactional(readOnly = true)
    public Optional<Item> getItemBySku(String sku) {
        return itemRepository.findBySku(sku);
    }

    // Adjust quantity
    public void updateAvailableQuantity(Long itemId, int changeAmount) {
        Item item = itemRepository.findById(itemId)
                        .orElseThrow(() -> new RuntimeException("Item not found with ID: " + itemId));
        int updatedQuantity = item.getAvailableQuantity() + changeAmount;

        if (updatedQuantity < 0) {
            throw new IllegalArgumentException("Not enough inventory fo ritem ID: " + itemId);
        }

        item.setAvailableQuantity(updatedQuantity);
        itemRepository.save(item);
    }
}
