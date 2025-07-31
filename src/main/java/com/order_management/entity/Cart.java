package com.order_management.entity;

import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    // User who owns cart
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    // unique session ID
    @Column(name= "uniqueIdentifier", unique = true)
    private String uniqueIdentifier;

    @Column(name = "totalQuantity")
    private Integer totalQuantity;

    @Column(name = "total_price", precision = 10, scale = 2)
    private BigDecimal totalPrice;

    // Constructor
    public Cart() {
    }

    public Cart(Long cartId, String uniqueIdentifier, Integer totalQuantity, BigDecimal totalPrice) {
        this.cartId = cartId;
        this.uniqueIdentifier = uniqueIdentifier;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
    }





    
}
