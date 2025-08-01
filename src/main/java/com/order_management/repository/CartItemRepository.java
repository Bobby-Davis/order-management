package com.order_management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order_management.entity.CartItem;
import com.order_management.entity.Cart;
import com.order_management.entity.Item;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    
    // Find all items in a cart
    List<CartItem> findByCart(Cart cart);

    // Find a specific item in a cart
    Optional<CartItem> findByCartAndItem(Cart cart, Item item);

    // Delete all items in a cart
    void deleteByCart(Cart cart);
}
