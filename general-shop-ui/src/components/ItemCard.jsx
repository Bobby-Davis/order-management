import React, { useContext } from 'react';
import { CartContext } from '../context/CartContext';

const ItemCard = ({ item }) => {
    const { addToCart } = useContext(CartContext);

    const handleAddToCart = () => {
        const cartItem = {
            ...item,
            quantity: 1 // Default quantity when adding to cart
        };
        addToCart(cartItem);
    };

    return (
        <div className="border rounded-lg p-4 shadow-md">
            <img src={item.imageUrl} alt={item.itemName} className="w-full h-48 object-cover rounded-md mb-4" />
            <h2 className="text-center text-lg font-semibold mb-2">{item.itemName}</h2>
            <p className="text-center text-gray-700 mb-2">${item.price.toFixed(2)}</p>
            <div className="text-center mt-4">
                <button
                    onClick={handleAddToCart}
                    className="bg-blue-500 text-white px-3 py-1 rounded hover:bg-blue-600" 
                >
                    Add to Cart
                </button>
            </div>
        </div>
    );
};


export default ItemCard;