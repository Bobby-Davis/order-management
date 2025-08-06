package com.order_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.order_management.entity.Cart;
import com.order_management.entity.CartItem;
import com.order_management.entity.Item;
import com.order_management.repository.CartItemRepository;
import com.order_management.repository.CartRepository;
import com.order_management.repository.ItemRepository;


@Service
@Transactional
public class CartItemService {
    
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    // Add or update item in the cart
    public CartItem addOrUpdateCartItem(Long cartId, Long itemId, int quantity) {
        Cart cart = cartRepository.findById(cartId)
            .orElseThrow(() -> new RuntimeException("Cart not found"));

        Item item = itemRepository.findById(itemId)
            .orElseThrow(() -> new RuntimeException("Item not found"));

        Optional<CartItem> existingCartItem = cartItemRepository.findByCartAndItem(cart, item);

        if (existingCartItem.isPresent()) {
            CartItem cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity()+ quantity);
            return cartItemRepository.save(cartItem);
        } else {
            CartItem newCartItem = new CartItem(cart, item, quantity);
            return cartItemRepository.save(newCartItem);
        }
    }

    // Get all items in a cart
    @Transactional(readOnly = true)
    public List<CartItem> getCartItemsByCartId(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
            .orElseThrow(() -> new RuntimeException("Cart not found"));
        return cartItemRepository.findByCart(cart);
    }

    // Remove item from cart
    public void removeCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    // Clear all items in a cart
    public void clearCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
            .orElseThrow(() -> new RuntimeException("Cart not found"));
        cartItemRepository.deleteByCart(cart);
    }
}
