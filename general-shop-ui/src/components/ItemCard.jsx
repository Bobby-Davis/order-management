import React, { useContext } from 'react';
import { CartContext } from '../context/CartContext';

const ItemCard = ({ item }) => {
    const { addToCart, removeFromCart } = useContext(CartContext);

    const handleAddToCart = () => {
        const cartItem = {
            ...item,
            quantity: 1 // Default quantity when adding to cart
        };
        addToCart(cartItem);
    };

    return (
        <div className="border roudned-lg p-4 shadow-md">
            <img src={item.imageUrl} alt={item.itemName} className="w-full h-48 object-cover rounded-md mb-4" />
            <h2 className="text-lg font-semibold mb-2">{item.itemName}</h2>
            <p className="text-gray-700 mb-2">${item.price.toFixed(2)}</p>
            <button
                onClick={handleAddToCart}
                className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600" 
            >
                Add to Cart
            </button>
            <button
                onClick={() => removeFromCart(item.id)}
                className="bg-red-500 text-white px-4 py-2 rounded hover:bg-red-600 ml-2"
            >
                Remove from Cart
            </button>
        </div>
    );
};


export default ItemCard;