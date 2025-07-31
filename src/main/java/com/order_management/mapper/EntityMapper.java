package com.order_management.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.order_management.dto.ItemDTO;
import com.order_management.dto.UserDTO;
import com.order_management.entity.Item;
import com.order_management.entity.User;

@Component
public class EntityMapper {
    
    /**
     * Convert User entity to UserDTO
     */
    public UserDTO toUserDTO(User user) {
        if (user == null) {
            return null;
        }
        
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setFullName(user.getFullName());
        dto.setAddress(user.getAddress());
        dto.setEmail(user.getEmail());
        
        return dto;
    }

    /*
     * Convert Item entity to ItemDTO
    */
    public ItemDTO toItemDTO(Item item) {
        if (item == null) {
            return null;
        }
        
        ItemDTO dto = new ItemDTO();
        dto.setItemId(item.getItemId());
        dto.setName(item.getName());
        dto.setDescription(item.getDescription());
        dto.setImageUrl(item.getImageUrl());
        dto.setPrice(item.getPrice());
        dto.setSku(item.getSku());
        
        return dto;
    }

       /**
     * Convert UserDTO to User entity
     */
    public User toUserEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setFullName(dto.getFullName());
        user.setAddress(dto.getAddress());
        user.setEmail(dto.getEmail());
        
        return user;
    }

    /*
     * Convert ItemDTO to Item entity 
    */
    public Item toItemEntity(ItemDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Item item = new Item();
        item.setItemId(dto.getItemId());
        item.setName(dto.getName());
        item.setDescription(dto.getDescription());
        item.setImageUrl(dto.getImageUrl());
        item.setPrice(dto.getPrice());
        item.setSku(dto.getSku());
        
        return item;
    }

        /**
     * Convert list of users to DTOs
     */
    public List<UserDTO> toUserDTOList(List<User> users) {
        return users.stream()
                .map(this::toUserDTO)
                .collect(Collectors.toList());
    }
    
    /**
     * Convert list of items to DTOs
     */
    public List<ItemDTO> toItemDTOList(List<Item> items) {
        return items.stream()
                .map(this::toItemDTO)
                .collect(Collectors.toList());
    }
}
