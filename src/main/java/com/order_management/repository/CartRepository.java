package com.order_management.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.order_management.entity.Cart;
import com.order_management.entity.User;

import java.util.List;


public interface CartRepository extends JpaRepository<Cart, Long> {
    
    // Find cat by unique session identifier (for quest checkotu or saved sessions)
    Optional<Cart> findByUniqueIdentifier(String uniqueIdentifier);

    // Find all carts belinong to a user (for saved carts or history)
    List<Cart> findByUser(User user);

    // Find active cart for a user
    Optional<Cart> findByUserAndTotalQuantityGreaterThan(User user, int quantity);

    // Check if cart exists for session ID
    boolean existsByUniqueIdentifier(String uniqueIdentifier);

    
}
