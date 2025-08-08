import { createContext, useState } from 'react';


// Create new context for components to access cart data
export const CartContext = createContext();

// CartProvider component to manage cart state and provide it to children components
export const CartProvider = ({ children }) => {
    // State to hold cart items
    const [cartItems, setCartItems] = useState([]);

    // Functions to add and remove items from the cart
    const addToCart = (item) => {
        setCartItems(prevItems => {
            const existingItem = prevItems.find(i => i.itemId === item.itemId);
            if (existingItem) {
                return prevItems.map(i =>
                    i.itemId === item.itemId ? { ...i, quantity: i.quantity + item.quantity } : i
                ); 
            } else {
                return [...prevItems, item];
            }   
        });
    };

    const decreaseQuantity = (itemId) => {
        setCartItems(prevItems => 
            prevItems.map(item =>
                item.itemId === itemId && item.quantity > 1
                    ? { ...item, quantity: item.quantity - 1 }
                    : item
            )
            .filter(item => item.quantity > 0) // Remove items with quantity 0
        );
    };

    const removeFromCart = (itemId) => {
        setCartItems(prevItems => prevItems.filter(item => item.itemId !== itemId));
    };

    // Value to be provided to components that consume this context
    // This includes the cart items and functions to modify the cart
    const value = {
        cartItems,
        addToCart,
        removeFromCart,
        decreaseQuantity
    }

    return (
        <CartContext.Provider value={value}>
            {children}
        </CartContext.Provider>
    );
};