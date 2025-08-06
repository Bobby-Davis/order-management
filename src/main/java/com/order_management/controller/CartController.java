package com.order_management.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.order_management.dto.CartDTO;
import com.order_management.entity.Cart;
import com.order_management.mapper.EntityMapper;
import com.order_management.service.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    // Inject CartService to use methods
    @Autowired
    private CartService cartService;

    @Autowired
    private EntityMapper entityMapper;

    // Create a new cart
    @PostMapping("/create")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        try {
            Cart newCart = cartService.createCart(cart);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCart);
        } catch (Exception e) {
            logger.error("Error creating cart", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    // Get cart by ID
    @GetMapping("/{id}")
    public ResponseEntity<CartDTO> getCartById(@PathVariable long id) {
        try {
            Optional<Cart> cart = cartService.getCartById(id);
            return cart.map(value -> ResponseEntity.ok(entityMapper.toCartDTO(value)))
                        .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            logger.error("Error fetching cart with ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get all carts
    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts() {
        try {
            List<Cart> carts = cartService.getAllCarts();
            return ResponseEntity.ok(carts);
        } catch (Exception e) {
            logger.error("Error fetching carts", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete Cart
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        try {
            cartService.deleteCart(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            logger.warn("Cart not found for deletion: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            logger.error("Error deleting cart with ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
