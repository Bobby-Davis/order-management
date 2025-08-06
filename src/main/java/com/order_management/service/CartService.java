package com.order_management.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.order_management.entity.Cart;
import com.order_management.entity.CartItem;
import com.order_management.entity.User;
import com.order_management.repository.CartRepository;
import com.order_management.repository.UserRepository;

@Service
@Transactional
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    // Saves new Cart to database
    public Cart createCart(Cart cart) {
        updateCartTotals(cart);
        return cartRepository.save(cart);
    }

    // Returns a specific cart by its ID
    @Transactional(readOnly = true)
    public Optional<Cart> getCartById(Long id) {
        return cartRepository.findById(id);
    }

    // Gets all carts
    @Transactional(readOnly = true)
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    // Get all carts by user ID
    public List<Cart> getCartsByUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(userObj -> cartRepository.findByUser(userObj))
                    .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Deletes a cart
    public void deleteCart(Long id) {
        if (!cartRepository.existsById(id)) {
            throw new RuntimeException("Cart not found with ID: " + id);
        }
        cartRepository.deleteById(id);
    }

    private void updateCartTotals(Cart cart) {
        int totalQuantity = 0;
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (CartItem item : cart.getCartItems()) {
            if (item.getQuantity() != null && item.getItem() != null && item.getItem().getPrice() != null) {
                totalQuantity += item.getQuantity();
                BigDecimal itemTotal = item.getItem().getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
                totalPrice = totalPrice.add(itemTotal);
            }
        }

        cart.setTotalQuantity(totalQuantity);
        cart.setTotalPrice(totalPrice);
    }

    
}
