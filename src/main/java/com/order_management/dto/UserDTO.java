package com.order_management.dto;

public class UserDTO {
    
    private Long userId;
    private String fullName;
    private String address;
    private String email;

    // Default constructor
    public UserDTO() {
    }

    // Constructor with essential fields
    public UserDTO(Long userId, String fullName, String address, String email){
        this.userId = userId;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
    }

    // Getters and setters
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

}
