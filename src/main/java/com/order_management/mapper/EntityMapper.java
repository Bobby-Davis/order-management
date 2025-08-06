package com.order_management.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.order_management.dto.CartDTO;
import com.order_management.dto.CartItemDTO;
import com.order_management.dto.ItemDTO;
import com.order_management.dto.UserDTO;
import com.order_management.entity.Cart;
import com.order_management.entity.CartItem;
import com.order_management.entity.Item;
import com.order_management.entity.User;

@Component
public class EntityMapper {
    
    /*
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
        dto.setItemName(item.getItemName());
        dto.setDescription(item.getDescription());
        dto.setImageUrl(item.getImageUrl());
        dto.setPrice(item.getPrice());
        dto.setSku(item.getSku());
        
        return dto;
    }

    /*
     * Convert CartItem entity to CartItemDTO
     */
    public CartItemDTO toCartItemDTO(CartItem cartItem) {
        if (cartItem == null) {
            return null;
        }
        
        CartItemDTO dto = new CartItemDTO();
        dto.setCartItemId(cartItem.getCartItemId());
        dto.setQuantity(cartItem.getQuantity());
        dto.setItem(toItemDTO(cartItem.getItem()));
        
        return dto;
    }

    /*
     * Convert Cart entity to CartDTO
     */
    public CartDTO toCartDTO(Cart cart) {
        if (cart == null) {
            return null;
        }
        
        CartDTO dto = new CartDTO();
        dto.setCartId(cart.getCartId());
        dto.setUser(toUserDTO(cart.getUser()));
        dto.setUniqueIdentifier(cart.getUniqueIdentifier());
        dto.setTotalQuantity(cart.getTotalQuantity());
        dto.setTotalPrice(cart.getTotalPrice());
        dto.setCartItems(toCartItemDTOList(cart.getCartItems()));  // include cart items
        
        return dto;
    }

    /*
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
        item.setItemName(dto.getItemName());
        item.setDescription(dto.getDescription());
        item.setImageUrl(dto.getImageUrl());
        item.setPrice(dto.getPrice());
        item.setSku(dto.getSku());
        
        return item;
    }

    /*
     * Convert CartItemDTO to CartItem entity 
     */
    public CartItem toCartItem(CartItemDTO dto) {
        if (dto == null) {
            return null;
        }
        
        CartItem cartItem = new CartItem();
        cartItem.setCartItemId(dto.getCartItemId());
        cartItem.setQuantity(dto.getQuantity());
        cartItem.setItem(toItemEntity(dto.getItem()));

        return cartItem;
    }

    /*
     * Convert CartDTO to Cart entity
     */
    public Cart toCart(CartDTO dto) {
        if (dto == null) {
            return null;
        }

        Cart cart = new Cart();
        cart.setCartId(dto.getCartId());
        cart.setUser(toUserEntity(dto.getUser()));
        cart.setUniqueIdentifier(dto.getUniqueIdentifier());
        cart.setTotalQuantity(dto.getTotalQuantity());
        cart.setTotalPrice(dto.getTotalPrice());
        cart.setCartItems(toCartItemEntityList(dto.getCartItems()));

        // makes sure each CartItem has its cart set
        for (CartItem item : cart.getCartItems()) {
            item.setCart(cart);
        }

        return cart;
    }



    /*
     * Convert list of users to DTOs
     */
    public List<UserDTO> toUserDTOList(List<User> users) {
        return users.stream()
                .map(this::toUserDTO)
                .collect(Collectors.toList());
    }
    
    /*
     * Convert list of items to DTOs
     */
    public List<ItemDTO> toItemDTOList(List<Item> items) {
        return items.stream()
                .map(this::toItemDTO)
                .collect(Collectors.toList());
    }

    /*
     * Convert list of CartItem entities to list of CartITemDTOs
     */
    public List<CartItemDTO> toCartItemDTOList(List<CartItem> cartItems) {
        return cartItems.stream()
                .map(this::toCartItemDTO)
                .collect(Collectors.toList());
    }

    /*
     * Convert list of CartItemDTOs to list of CartItem entities
     */
    public List<CartItem> toCartItemEntityList(List<CartItemDTO> cartItemDTOs) {
        return cartItemDTOs.stream()
                .map(this::toCartItem)
                .collect(Collectors.toList());
    }

}
