import React, { useContext } from 'react';
import { CartContext } from '../context/CartContext'; 

const CartPage = () => {
    const { cartItems, removeFromCart, decreaseQuantity } = useContext(CartContext);

    console.log("[CartPage] Cart Items:", cartItems); // check cart items

    const getTotalPrice = () => {
        const total = cartItems.reduce((total, item) => total + item.price * item.quantity, 0)
        console.log("[CartPage] Calculated Total Price:", total); // check total price calculation
        return total.toFixed(2);
    };

    return (
        <div className="p-6">
            <h2 className="text-3xl font-bold tracking-wide items-center text-center my-4">Your Cart</h2>

            {cartItems.length === 0 ? (
                <p className="text-gray-500">Your cart is empty.</p>
            ) : (
                <div>
                    <ul className="space-y-4">
                        {cartItems.map(item => (
                            <li key={item.id} className="flex justify-between items-center border-b pb-2">
                                <div>
                                    <h3 className="text-lg font-semibold">{item.itemName}</h3>
                                    <div className="flex items-center space-x-2">
                                        <button
                                            onClick={() => {
                                                console.log(`[CartPage] Decrease quantity for:`, item); // 
                                                decreaseQuantity(item.itemId)
                                            }}
                                            className="bg-gray-200 text-gray-800 px-2 py-1 rounded hover:bg-gray-300"
                                        >
                                            -
                                        </button>
                                        <p>Quantity: {item.quantity}</p>
                                    </div>

                                    <p>${(item.price * item.quantity).toFixed(2)}</p>
                                </div>
                                <button
                                    onClick={() => {
                                        console.log(`[CartPage] Remove item from cart:`, item);
                                        removeFromCart(item.itemId)
                                    }}
                                    className="bg-red-500 text-white px-4 py-2 rounded hover:bg-red-600"
                                >
                                    Remove
                                </button>
                            </li>
                        ))}
                    </ul>
                    <div className="mt-4">
                        <h3 className="text-xl font-bold">Total: ${getTotalPrice()}</h3>
                    </div>
                </div>
            )}
        </div>
    );
};

export default CartPage;