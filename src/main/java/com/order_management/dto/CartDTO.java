package com.order_management.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartDTO {
    
    private Long cartId;
    private UserDTO user;
    private String uniqueIdentifier;
    private Integer totalQuantity;
    private BigDecimal totalPrice;

    private List<CartItemDTO> cartItems = new ArrayList<>();

    // Constructor
    public CartDTO() {
    }

    public CartDTO(Long cartId, String uniqueIdentifier, Integer totalQuantity, BigDecimal totalPrice) {
        this.cartId = cartId;
        this.uniqueIdentifier = uniqueIdentifier;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
    }
    
    // Getters and Setters
    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartItemDTO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDTO> cartItems) {
        this.cartItems = cartItems;
    }

}
