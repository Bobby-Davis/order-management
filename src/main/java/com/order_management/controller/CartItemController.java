package com.order_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.order_management.entity.CartItem;
import com.order_management.service.CartItemService;

@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    // Add or update item in cart
    @PostMapping("/add")
    public ResponseEntity<CartItem> addOrUpdateCartItem(
        @RequestParam Long cartId,
        @RequestParam Long itemId,
        @RequestParam int quantity
    ) {
        CartItem cartItem = cartItemService.addOrUpdateCartItem(cartId, itemId, quantity);
        return ResponseEntity.ok(cartItem);
    }

    // Get all items in a cart
    @GetMapping("/cart/{cartId}")
    public ResponseEntity<List<CartItem>> getItemsInCart(@PathVariable Long cartId) {
        List<CartItem> items = cartItemService.getCartItemsByCartId(cartId);
        return ResponseEntity.ok(items);
    }

    // Delete a specific cart item
    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long cartItemId) {
        cartItemService.removeCartItem(cartItemId);
        return ResponseEntity.noContent().build();
    }

    // Clear entire cart
    @DeleteMapping("/cart/{cartId}")
    public ResponseEntity<Void> clearCart(@PathVariable Long cartId) {
        cartItemService.clearCart(cartId);
        return ResponseEntity.noContent().build();
    }
    
}
