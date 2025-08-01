package com.order_management.dto;

import com.order_management.entity.Cart;
import com.order_management.entity.Item;

public class CartItemDTO {
    
    private long cartItemId;
    private Cart cart;
    private Item item;
    private Integer quantity;

    // Constructors
    public CartItemDTO() {
    }

    public CartItemDTO(Cart cart, Item item, Integer quantity) {
        this.cart = cart;
        this.item = item;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
