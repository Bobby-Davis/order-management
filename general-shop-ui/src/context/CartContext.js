import { createContext, useState } from 'react';


// Create new context for components to access cart data
export const CartContext = createContext();

// CartProvider component to manage cart state and provide it to children components
export const CartProvider = ({ children }) => {
    // State to hold cart items
    const [cartItems, setCartItems] = useState([]);

    // Functions to add and remove items from the cart
    const addToCart = (item) => {
        setCartItems(prevItems => [...prevItems, item]);
    };

    const removeFromCart = (itemId) => {
        setCartItems(prevItems => prevItems.filter(item => item.id !== itemId));
    };

    // Value to be provided to components that consume this context
    // This includes the cart items and functions to modify the cart
    const value = {
        cartItems,
        addToCart,
        removeFromCart
    }

    return (
        <CartContext.Provider value={value}>
            {children}
        </CartContext.Provider>
    );
};