package com.order_management.dto;


public class CartItemDTO {
    
    private long cartItemId;
    private ItemDTO item;
    private Integer quantity;

    // Constructors
    public CartItemDTO() {
    }

    public CartItemDTO(ItemDTO item, Integer quantity) {
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

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
