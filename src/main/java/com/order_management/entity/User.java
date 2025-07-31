package com.order_management.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.*;                // @Entity, @Table, @Id, etc.
import jakarta.validation.constraints.*;



@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Email is required")
    private String email;

    // Constructor
    public User() {
    }

    public User(Long userId, String fullName, String address, String email) {
        this.userId = userId;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
    }

    // Getters and Setters
    public Long getUserId(){
        return userId;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }

    public String getFullName(){
        return fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String toString() {
        return "User{" + 
                "userId=" + userId +
                "fullName='" + fullName + '\'' +
                "address='" + address + '\'' +
                "email='" + email + '\'' +
                '}';

    }

}
