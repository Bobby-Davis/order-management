import React, { useContext } from 'react';
import { CartContext } from '../context/CartContext'; 

const CartPage = () => {
    const { cartItems, removeFromCart } = useContext(CartContext);

    const getTotalPrice = () => {
        return cartItems.reduce((total, item) => total + item.price * item.quantity, 0).toFixed(2);
    };

    return (
        <div className="p-6">
            <h2 className="text-2xl font-bold mb-4">Your Cart</h2>

            {cartItems.length === 0 ? (
                <p className="text-gray-500">Your cart is empty.</p>
            ) : (
                <div>
                    <ul className="space-y-4">
                        {cartItems.map(item => (
                            <li key={item.id} className="flex justify-between items-center border-b pb-2">
                                <div>
                                    <h3 className="text-lg font-semibold">{item.itemName}</h3>
                                    <p>Quantity: {item.quantity}</p>
                                    <p>${(item.price * item.quantity).toFixed(2)}</p>
                                </div>
                                <button
                                    onClick={() => removeFromCart(item.id)}
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