package com.order_management.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.order_management.entity.User;
import java.util.List;



public interface UserRepository extends JpaRepository<User, Long> {
    
    // Find user by email
    Optional<User> findByEmail(String email);

    // Find users by name
    List<User> findByFullName(String fullName);

    // Check if user exists by email
    boolean existsByEmail(String email);

    // find users by address
    List<User> findByAddress(String address);


}
