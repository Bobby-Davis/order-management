package com.order_management.dto;

import java.math.BigDecimal;


public class ItemDTO {
    
    private Long itemId;
    private String itemName;
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private Integer availableQuantity;
    private String sku;

    // Default Constructor
    public ItemDTO() {
    }

    // Constructor with essential fields
    public ItemDTO(Long itemId, String itemName, String description, String imageUrl, BigDecimal price, Integer availableQuantity, String sku) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.sku = sku;
    }

        // Getters and Setters
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId){
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity){
        this.availableQuantity = availableQuantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku){
        this.sku = sku;
    }
    
}
