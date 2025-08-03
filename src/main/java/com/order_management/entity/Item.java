package com.order_management.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @NotBlank(message = "Item name is required")
    @Size(max = 100, message = "Item name must not exceed 100 characters")
    private String itemName;

    @NotBlank(message = "")
    @Size(max = 500, message = "Item description must not exceed 500 characters")
    private String description;

    @Size(max = 255, message = "Image URL must not exceed 255 characters")
    private String imageUrl;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @NotNull(message = "Available quantity is required")
    @Min(value = 0, message = "Quantity cannot be negative")
    @Column(nullable = false)
    private Integer availableQuantity;

    @NotBlank(message = "Sku is required")
    @Size(max = 50, message = "SKU must not exceed 50 characters")
    @Column(nullable = false, unique = true, length = 50)
    private String sku;

    //Constructor
    public Item() {
    }

    public Item(Long itemId, String itemName, String description, String imageUrl, BigDecimal price, Integer availableQuantity, String sku) {
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

    @Override
    public String toString(){
        return "Item{" +
                "itemId=" + itemId + 
                ", itemName='" + itemName + '\'' +
                ", description'" + description + '\'' +
                ", imageUrl'" + imageUrl + '\'' +
                ", price" + price +
                ", availableQuantity" + availableQuantity +
                ", sku'" + sku + '\'' + 
                '}';

    }

}
